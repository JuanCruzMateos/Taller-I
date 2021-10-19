package org.cajanegra.profesor;

import excepciones.NoEncontradoException;
import modelo.Profesor;
import org.cajanegra.escenarios.EscenarioConDatosProfesor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class SistemaBuscarProfesorConDatosTest {
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
    public void buscarProfesorPresente() {
        Iterator<Profesor> it;
        Profesor encontrado = null;
        try {
            it = this.es.getSistema().buscarProfesor(this.es.getProfesor().getApellidoNombre());
            assertTrue("Se deberian haber encontrado al menos un resultado", it.hasNext());
            while (it.hasNext() && encontrado != this.es.getProfesor()) {
                encontrado = it.next();
            }
            assertEquals("No se encontro el profe buscado", this.es.getProfesor(), encontrado);
        } catch (NoEncontradoException e) {
            fail("No deberia lanzarse una excepcion al buscar a un profe que esta en el sistema");
        } catch (Exception e) {
            fail("No deberia lanzarse ninun tipo de excepcion");
        }
    }

    @Test
    public void buscarProfesorCantidadDeCoincidenciasCorrecta() {
        Iterator<Profesor> it;
        int cant = 0;
        try {
            it = this.es.getSistema().buscarProfesor("lopez");
            assertTrue("Se deberian haber encontrado al menos un resultado", it.hasNext());
            while (it.hasNext()) {
                cant += 1;
                it.next();
            }
            assertEquals("El numero de resultados no se corresponde al los profes presentes", cant, 2);
        } catch (NoEncontradoException e) {
            fail("No deberia lanzarse una excepcion al buscar a un profe que esta en el escenarioConDatos.getescenarioConDatos.getSistema()()");
        } catch (Exception e) {
            fail("No deberia lanzarse ninun tipo de excepcion");
        }
    }

    @Test
    public void buscarProfesorInexistente() {
        try {
            Iterator<Profesor> it = this.es.getSistema().buscarProfesor("Mateos");
            fail("No deberia haber coincidencias al buscar a un profe que no esta en el sistema");
        } catch (NoEncontradoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia lanzarse una excepcion de tipo NoEncontradoException");
        }
    }

    @Test
    public void buscarProfesorVacio() {
        try {
            Iterator<Profesor> it = this.es.getSistema().buscarProfesor("");
            fail("No deberia haber coincidencias al buscar a un profe vacio");
        } catch (NoEncontradoException e) {
            // OK
        } catch (Exception e) {
            fail("No contempla que profe no sea vacio");
        }
    }

    @Test
    public void buscarProfesorNull() {
        try {
            Iterator<Profesor> it = this.es.getSistema().buscarProfesor(null);
            fail("No deberia haber coincidencias al buscar null");
        } catch (NoEncontradoException e) {
            // OK
        } catch (Exception e) {
            fail("No contempla que profe no sea vacio");
        }
    }
}
