package gm.zona_fit.controlador;

import gm.zona_fit.modelo.Cliente;
import gm.zona_fit.servicio.IClienteServicio;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
@Data
@ViewScoped
// @ViewScoped Mantiene los datos mientras la vista esté cargada
// útil para aplicaciones de una sola página con JSF
public class IndexController {

    @Autowired
    private IClienteServicio clienteServicio;
    private List<Cliente> clienteList;
    private Cliente clienteSelec;

    // @PostConstruct Se ejecuta después de que Spring crea la instancia de la clase.
    // JSF llama automaticamente a este metodo,
    // por eso se pone la etiqueta PostContruct
    //el nombre del metodo puedo ser cualquiera
    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.clienteList = this.clienteServicio.listarClientes();
        System.out.println("Se llamo al metodo cargarDatos()");
    }

    public void agregarCliente(){
        this.clienteSelec = new Cliente();
    }

    public void guardarCliente(){
        System.out.println("Cliente a guardar: " + this.clienteSelec);

        try {
            //Agregar
            if (this.clienteSelec.getId() == null) {
                this.clienteServicio.guardarCliente(this.clienteSelec);
                // luego de la oprecion de guardado, debido a la persistencia de la BD
                // implementada utilzando JPA el id del cliente se asigna automaticamente
                // debido a que en el modelo usamos la etiqueta
                // @GeneratedValue(strategy = GenerationType.IDENTITY)
                System.out.println("El cliente " + this.clienteSelec + " se guardo correctamente");
                this.clienteList.add(this.clienteSelec);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Cliente agregado"));
            }
            //Modificar
            else {
                this.clienteServicio.guardarCliente(this.clienteSelec);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Cliente actualizado"));
            }

            //Ocultar la ventana modal
            PrimeFaces.current().executeScript("PF('ventanaModalCliente').hide()");
            //Actualizar tabla con AJAX
            PrimeFaces.current().ajax().update("forma-clientes:mensajes",
                    "forma-clientes:clientes-tabla");
            //Reset objeto cliente seleccionado
            this.clienteSelec = null;

        }catch (DataIntegrityViolationException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "La membresía ingresada ya existe. " +
                                    "Por favor, ingrese otra.", null));
            // ACTUALIZAR MENSAJES PARA QUE SE MUESTREN EN LA VISTA
            PrimeFaces.current().ajax().update("forma-clientes:mensajes");
        }catch (RuntimeException e) {
            // Captura cualquier otra excepción
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Ocurrió un error inesperado", null));
            // ACTUALIZAR MENSAJES PARA QUE SE MUESTREN EN LA VISTA
            PrimeFaces.current().ajax().update("forma-clientes:mensajes");
        }
    }

    public void eliminarCliente(){
        System.out.println("Cliente a eliminar: " + this.clienteSelec);
        this.clienteServicio.eliminarCliente(this.clienteSelec);
        // Eliminar el registro de la lista de clientes
        this.clienteList.remove(this.clienteSelec);
        this.clienteSelec = null;
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Cliente eliminado"));
        PrimeFaces.current().ajax().update("forma-clientes:mensajes",
                "forma-clientes:clientes-tabla");
    }
}
