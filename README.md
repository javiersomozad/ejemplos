# Proyectos de ejemplo

Los proyectos están numerados según la parte del libro a la que pertenecen.

* s01: introducción
* s02: aspectos
* s03: acceso a datos
* s04: Spring MVC
* s05: servicios
* s06: programación reactiva
* s07: testing

## Instalación de proyectos
Todos ellos son proyectos **Maven**, por lo tanto podrá importarlos a cualquier IDE que soporte Maven.
Si utiliza Eclipse o Spring STS podrá importarlos directamente como proyectos Eclipse.

Una vez importados, será necesario que el IDE descargue las dependencias necesarias de cada uno. Es probable
que lo haga automáticamente, si no es así, tendrá que hacer un *mvn install* a través del IDE o por consola.

Para que la instalación funcione correctamente, **su equipo debe estar conectado a internet**. Asegúrese de que las
dependencias se pueden descargar en su red, ya que puede haber configuraciones o proxies restrictivos que eviten
las descargas de los repositorios Maven.

## Ejecucicón de proyectos
Para ejecutar cualquier proyecto debe ejecutarlos como Spring Boot.

En el caso de proyectos Web, debe tener cuidado de no dejar un proyecto en ejecución o no le permitirá ejecutar otro 
a la vez por conflictos en los puertos. 

La mayoría de proyectos de datos utilizan H2, por tanto no es necesario instalar nada. Los proyectos que aplican MySQL,
obviamente, necesitaran un servidor MySQL local configurado con las opciones que indiquen los ficheros properties.
