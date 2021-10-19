package org.cajanegra.alumno;

import excepciones.NoEncontradoException;
import modelo.Alumno;
import org.cajanegra.escenarios.EscenarioConDatosAlumno;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class SistemaBuscarAlumnoConDatosTest {
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
    public void buscarAlumnoPresente() {
        Iterator<Alumno> it;
        Alumno encontrado = null;
        try {
            it = this.escenarioConDatos.getSistema().buscarAlumno(this.escenarioConDatos.getAlumno().getApellidoNombre());
            assertTrue("Se deberian haber encontrado al menos un resultado", it.hasNext());
            while (it.hasNext() && encontrado != this.escenarioConDatos.getAlumno()) {
                encontrado = it.next();
            }
            assertEquals("No se encontro el alumno buscado", this.escenarioConDatos.getAlumno(), encontrado);
        } catch (NoEncontradoException e) {
            fail("No deberia lanzarse una excepcion al buscar a un alumno que esta en el escenarioConDatos.getescenarioConDatos.getSistema()()");
        } catch (Exception e) {
            fail("No deberia lanzarse ninun tipo de excepcion");
        }
    }

    @Test
    public void buscarAlumnoCantidadDeCoincidenciasCorrecta() {
        Iterator<Alumno> it;
        int cant = 0;
        try {
            it = this.escenarioConDatos.getSistema().buscarAlumno("mateos");
            assertTrue("Se deberian haber encontrado al menos un resultado", it.hasNext());
            while (it.hasNext()) {
                cant += 1;
                it.next();
            }
            assertEquals("El numero de resultados no se corresponde al los alumnos presentes", cant, 3);
        } catch (NoEncontradoException e) {
            fail("No deberia lanzarse una excepcion al buscar a un alumno que esta en el escenarioConDatos.getescenarioConDatos.getSistema()()");
        } catch (Exception e) {
            fail("No deberia lanzarse ninun tipo de excepcion");
        }
    }

    @Test
    public void buscarAlumnoInexistente() {
        try {
            Iterator<Alumno> it = this.escenarioConDatos.getSistema().buscarAlumno("carlos diaz");
            fail("No deberia haber coincidencias al buscar a un alumno que no esta en el sistema");
        } catch (NoEncontradoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia lanzarse una excepcion de tipo NoEncontradoException");
        }
    }

    @Test
    public void buscarAlumnoVacio() {
        try {
            Iterator<Alumno> it = this.escenarioConDatos.getSistema().buscarAlumno("");
            fail("No deberia haber coincidencias al buscar a un alumno vacio");
        } catch (NoEncontradoException e) {
            // OK
        } catch (Exception e) {
            fail("No contempla que alumno no sea vacio");
        }
    }

    @Test
    public void buscarAlumnoNull() {
        try {
            Iterator<Alumno> it = this.escenarioConDatos.getSistema().buscarAlumno(null);
            fail("No deberia haber coincidencias al buscar null");
        } catch (NoEncontradoException e) {
            // OK
        } catch (Exception e) {
            fail("No contempla que alumno no sea vacio");
        }
    }
}
