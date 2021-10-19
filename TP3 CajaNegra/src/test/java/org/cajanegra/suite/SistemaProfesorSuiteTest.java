package org.cajanegra.suite;

import org.cajanegra.profesor.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({SistemaAgregarProfesorConDatosTest.class,
        SistemaBuscarProfesorConDatosTest.class,
        SistemaEliminarProfesorConDatosTest.class,
        SistemaModificarProfesorConDatosTest.class,
        SistemaAgregarProfesorSinDatosTest.class,
        SistemaBuscarProfesorSinDatosTest.class})
public class SistemaProfesorSuiteTest {
    // Test Suite para Profesores
}
