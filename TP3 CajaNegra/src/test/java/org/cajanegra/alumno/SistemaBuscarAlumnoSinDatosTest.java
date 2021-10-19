package org.cajanegra.alumno;

import excepciones.NoEncontradoException;
import modelo.Alumno;
import modelo.IndiceDoble;
import modelo.Sistema;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.fail;

public class SistemaBuscarAlumnoSinDatosTest {
    private Sistema sistema;

    @Before
    public void setUp() {
        this.sistema = new Sistema();
        this.sistema.setAlumnos(new IndiceDoble<Alumno>());
    }

    @After
    public void tearDown() {
        this.sistema = null;
    }

    @Test
    public void buscarAlumnoFail() {
        try {
            Iterator<Alumno> it = this.sistema.buscarAlumno("mateos");
            fail("Se deberia haber lanzado una excepcion de tipo NoEncontradoException");
        } catch (NoEncontradoException e) {
            // OK
        } catch (Exception e) {
            fail("No deberia lanzarse ninun tipo de excepcion");
        }
    }

    @Test
    public void buscarAlumnoVacio() {
        try {
            Iterator<Alumno> it = this.sistema.buscarAlumno("");
            fail("No deberia haber coincidencias al buscar a un alumno vacio en una coleccion vacia");
        } catch (NoEncontradoException e) {
            // OK
        } catch (Exception e) {
            fail("No contempla que alumno no sea vacio: deberia ser excepcion especifica");
        }
    }

    @Test
    public void buscarAlumnoNull() {
        try {
            Iterator<Alumno> it = this.sistema.buscarAlumno(null);
            fail("No deberia haber coincidencias al buscar null en una coleccion vacia");
        } catch (NoEncontradoException e) {
            // OK
        } catch (Exception e) {
            fail("No contempla que alumno no sea vacio: deberia ser excepcion especifica");
        }
    }
}
