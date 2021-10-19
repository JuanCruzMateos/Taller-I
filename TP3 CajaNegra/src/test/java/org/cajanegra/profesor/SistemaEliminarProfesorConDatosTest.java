package org.cajanegra.profesor;

import modelo.Cursada;
import org.cajanegra.escenarios.EscenarioConDatosProfesor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class SistemaEliminarProfesorConDatosTest {
    private final EscenarioConDatosProfesor es = new EscenarioConDatosProfesor();

    @Before
    public void setUp() throws Exception {
        this.es.setUp();
    }

    @After
    public void tearDown() throws Exception {
        this.es.tearDown();
    }

    @Test
    public void eliminarAlumno() {
        this.es.getSistema().eliminarProfesor(this.es.getProfesor());

        // El sistema tiene un profesor menos
        assertFalse("El profesor deberia haberse eliminado", this.es.getSistema().getProfesores().contieneValor(this.es.getProfesor()));

        // El profesor fue dado de baja de todas las cursadas en las que participaba.
        Iterator<Cursada> it = this.es.getSistema().getCalendario().elementosPorClavePrimaria();
        while (it.hasNext()) {
            Cursada c = it.next();
            if (c.tieneProfesor(this.es.getProfesor()))
                fail("El profesor no se elimino de todas las cursadas.");
        }
    }
}
