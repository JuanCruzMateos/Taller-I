# Práctica de caja negra

El práctico de caja negra consiste en tomar el proyecto PGA (pga.jar) y en base a los javadoc y la SRS, construir los test para
los métodos de la clase sistema de la capa "modelo" relacionados con las operaciones de:

* agregar
* buscar
* eliminar
* modificar

para Alumnos y Profesores. Estos métodos se encuentran enumerados en el javadoc, del proyecto PGA.

* Nota : asumir que todos los otros métodos están probados. en particular los get y set de las colecciones que se
  implementan en la capa del modelo (útiles para el test de los métodos anteriores).

* Nota 1: El código presenta una diseño, que no considera las necesidades del testing a modo de ejemplo, se presenta un
  fragmento de código y la forma de resolver la dificultad.

* Nota 2: No se prueba GUI ni Persistencia.