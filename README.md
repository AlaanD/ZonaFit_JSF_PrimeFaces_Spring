# ZonaFit_JSF_PrimeFaces_Spring

**ZonaFit_JSF_PrimeFaces_Spring** es una evolución del proyecto **ZonaFitSpringSwing** que reemplaza la interfaz gráfica basada en **Swing** por una interfaz web utilizando **JavaServer Faces (JSF)** y **PrimeFaces**, manteniendo **Spring Boot** en el backend.

## Características

- **Integración de Spring Boot con JSF y PrimeFaces**: Combina la potencia de Spring Boot para la lógica de negocio y la persistencia de datos con la flexibilidad de JSF y los componentes enriquecidos de PrimeFaces para la interfaz de usuario.
- **Arquitectura modular**: Organización del código en capas para mejorar la mantenibilidad y escalabilidad.
- **Gestión de dependencias con Maven**: Facilita la incorporación y manejo de bibliotecas externas necesarias para el proyecto.
- **Interfaz web interactiva**: Proporciona una experiencia de usuario mejorada mediante componentes avanzados de PrimeFaces.

## Requisitos Previos

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) versión 11 o superior.
- [Apache Maven](https://maven.apache.org/) para la gestión de dependencias y construcción del proyecto.
- Un entorno de desarrollo integrado (IDE) compatible con proyectos Spring Boot y JSF, como **IntelliJ IDEA**, **Eclipse** con el plugin Spring Tools, o **Spring Tool Suite (STS)**.

## Estructura del Proyecto

La estructura del proyecto es la siguiente:

- **ZonaFit_JSF_PrimeFaces_Spring/**
  - **.mvn/wrapper/**  
    - Contiene los archivos necesarios para utilizar el wrapper de Maven, permitiendo construir el proyecto sin necesidad de tener Maven instalado previamente.
  - **src/**  
    - Carpeta principal que contiene el código fuente de la aplicación, organizada según las convenciones de Spring Boot, con paquetes específicos para la lógica de negocio y la interfaz de usuario basada en JSF y PrimeFaces.
  - **.gitattributes**  
    - Archivo de configuración para Git, utilizado para manejar aspectos específicos como la normalización de finales de línea.
  - **.gitignore**  
    - Especifica los archivos y directorios que deben ser ignorados por Git, como archivos generados automáticamente o configuraciones locales.
  - **mvnw** y **mvnw.cmd**  
    - Scripts para ejecutar Maven Wrapper en sistemas Unix y Windows, respectivamente.
  - **pom.xml**  
    - Archivo de configuración de Maven que define las dependencias, plugins y configuraciones necesarias para construir y ejecutar la aplicación.

## Instalación y Ejecución

1. **Clonar el repositorio**:

   ```bash
   git clone https://github.com/AlaanD/ZonaFit_JSF_PrimeFaces_Spring.git

## Autor

- **Alán David Dri**  
