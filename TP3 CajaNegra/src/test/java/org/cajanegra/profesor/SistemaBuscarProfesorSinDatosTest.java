package org.cajanegra.profesor;

import excepciones.NoEncontradoException;
import modelo.IndiceDoble;
import modelo.Profesor;
import modelo.Sistema;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.fail;

public class SistemaBuscarProfesorSinDatosTest {
    private Sistema sistema;

    @Before
    public void setUp() {
        this.sistema = new Sistema();
        this.sistema.setProfesores(new IndiceDoble<Profesor>());
    }

    @After
    public void tearDown() {
        this.sistema = null;
    }

    @Test
    public void buscarProfeFail() {
        try {
            Iterator<Profesor> it = this.sistema.buscarProfesor("mateos");
            fail("Se deberia haber lanzado una excepcion de tipo NoEncontradoException");
        } catch (NoEncontradoException e) {
            // OK
        } catch (Exception e) {
            fail("No deberia lanzarse ninun tipo de excepcion");
        }
    }

    @Test
    public void buscarProfeVacio() {
        try {
            Iterator<Profesor> it = this.sistema.buscarProfesor("");
            fail("No deberia haber coincidencias al buscar a un profe vacio en una coleccion vacia");
        } catch (NoEncontradoException e) {
            // OK
        } catch (Exception e) {
            fail("No contempla que alumno no sea vacio: deberia ser excepcion especifica");
        }
    }

    @Test
    public void buscarProfeNull() {
        try {
            Iterator<Profesor> it = this.sistema.buscarProfesor(null);
            fail("No deberia haber coincidencias al buscar null en una coleccion vacia");
        } catch (NoEncontradoException e) {
            // OK
        } catch (Exception e) {
            fail("No contempla que alumno no sea vacio: deberia ser excepcion especifica");
        }
    }
}
