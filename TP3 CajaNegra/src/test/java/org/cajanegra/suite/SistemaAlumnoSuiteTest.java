package org.cajanegra.suite;

import org.cajanegra.alumno.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({SistemaAgregarAlumnoConDatosTest.class,
        SistemaEliminarAlumnoConDatosTest.class,
        SistemaBuscarAlumnoConDatosTest.class,
        SistemaModificarAlumnoConDatosTest.class,
        SistemaAgregarAlumnoSinDatosTest.class,
        SistemaBuscarAlumnoSinDatosTest.class,})
public class SistemaAlumnoSuiteTest {
    // Test Suite para Alumnos
}
