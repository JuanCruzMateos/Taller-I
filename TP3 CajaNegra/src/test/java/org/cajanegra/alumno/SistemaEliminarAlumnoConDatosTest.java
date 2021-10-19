package org.cajanegra.alumno;

import modelo.Cursada;
import org.cajanegra.escenarios.EscenarioConDatosAlumno;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class SistemaEliminarAlumnoConDatosTest {
    private final EscenarioConDatosAlumno escenarioConDatos = new EscenarioConDatosAlumno();

    @Before
    public void setUp() {
        this.escenarioConDatos.setUp();
    }

    @After
    public void tearDown() {
        this.escenarioConDatos.tearDown();
    }

    @Test
    public void eliminarAlumno() {
        this.escenarioConDatos.getSistema().eliminarAlumno(this.escenarioConDatos.getAlumno());

        // El sistema tiene un alumno menos
        assertFalse("El alumno deberia haberse eliminado", this.escenarioConDatos.getSistema().getAlumnos().contieneValor(this.escenarioConDatos.getAlumno()));

        // El alumno fue dado de baja de todas las cursadas en las que participaba.
        Iterator<Cursada> it = this.escenarioConDatos.getSistema().getCalendario().elementosPorClavePrimaria();
        while (it.hasNext()) {
            Cursada c = it.next();
            if (c.tieneAlumno(this.escenarioConDatos.getAlumno()))
                fail("El alumno no se elimino de todas las cursadas.");
        }
    }
}
