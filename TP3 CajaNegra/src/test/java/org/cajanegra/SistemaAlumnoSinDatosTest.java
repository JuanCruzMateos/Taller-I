package org.cajanegra;

import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import excepciones.NoEncontradoException;
import modelo.Alumno;
import modelo.IndiceDoble;
import modelo.Sistema;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

/**
 * Clase para probar los metodos de la clase Sistema en un escenario con datos.<br>
 * >>> Agregar
 * >>> Eliminar -> no hay nada que eliminar
 * >>> Buscar
 * >>> Modificar -> no hay nada que modificar
 */
public class SistemaAlumnoSinDatosTest {
    private Sistema sistema = new Sistema();
    private Alumno alumno;

    @Before
    public void setUp() {
        this.sistema = new Sistema();
        this.alumno = new Alumno("juan cruz mateos", "calle falsa 123", "juan@cruz.com");
    }

    @After
    public void tearDown() {
        this.sistema.setAlumnos(new IndiceDoble<Alumno>());
        this.alumno = null;
    }

    @Test
    public void agregarAlumnoSuccess() {
        Alumno nuevo = new Alumno("sofia alvarez", "quintana 1482", "sofi@sofi.com");
        try {
            this.sistema.agregarAlumno(nuevo);
        } catch (ClaveYaExistenteException | DatoInvalidoException e) {
            // si se lanza una excepcion es un error
            fail("No deberia lanzarse ninguna excepcion al ingresar un alumno valido");
        }
        // si se agrego, debeo verificar que en verdad es asi
        assertTrue("No se ingreso un alumno valido", this.sistema.getAlumnos().contieneValor(nuevo));
        // Correctamente indexado
        assertNotNull("No se genero clave primario", nuevo.getClavePrimaria());
        assertNotNull("No se genero legajo", nuevo.getLegajo());
    }

    @Test
    public void agregarAlumnoFailLegajoExistenteTest() {
        // TODO :: revisar, como hago?

        Alumno nuevo = new Alumno("sofia alvarez", "quintana 1482", "sofi@sofi.com");
        // Mascara de Alumno :: ALUXXXX (X 0-9)
        System.out.println(Alumno.getCANT_ALUMNOS());
        Alumno.setCANT_ALUMNOS(10000);
        // Seteandolo en 10000, ya tengo todos los legajos asignados
        try {
            this.sistema.agregarAlumno(nuevo);
            fail("No deberia agregar el alumno y deberia lanzarse la excepcion ClaveYaExistenteException");
        } catch (ClaveYaExistenteException e) {
            // OK
        } catch (DatoInvalidoException e) {
            fail("Deberia lanzarse la excepcion ClaveYaExistenteException y no DatoInvalidoException");
        }
    }

    @Test
    public void agregarAlumnoFailNombreVacio() {
        Alumno alumno = new Alumno("", "Dorrego 8256", "alguien@gmail.com");
        try {
            this.sistema.agregarAlumno(alumno);
            fail("Debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (ClaveYaExistenteException e) {
            fail("Debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void agregarAlumnoFailNombreNull() {
        Alumno alumno = new Alumno(null, "Dorrego 8256", "alguien@gmail.com");
        try {
            this.sistema.agregarAlumno(alumno);
            fail("No deberia agregarse el alumno y debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (ClaveYaExistenteException e) {
            fail("Debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void agregarAlumnoFailDireccionVacio() {
        Alumno alumno = new Alumno("pepe pepin", "", "alguien@gmail.com");
        try {
            this.sistema.agregarAlumno(alumno);
            fail("No deberia agregarse el alumno y debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (ClaveYaExistenteException e) {
            fail("Debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void agregarAlumnoFailDireccionNull() {
        Alumno alumno = new Alumno("pepe pepin", null, "alguien@gmail.com");
        try {
            this.sistema.agregarAlumno(alumno);
            fail("No deberia agregarse el alumno y debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (ClaveYaExistenteException e) {
            fail("Debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void agregarAlumnoFailMailVacio() {
        Alumno alumno = new Alumno("pepe pepin", "Dorrego 8256", "");
        try {
            this.sistema.agregarAlumno(alumno);
            fail("No deberia agregarse el alumno y debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (ClaveYaExistenteException e) {
            fail("Debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void agregarAlumnoFailMailNull() {
        Alumno alumno = new Alumno("pepe pepin", "Dorrego 8256", null);
        try {
            this.sistema.agregarAlumno(alumno);
            fail("No deberia agregarse el alumno y debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (ClaveYaExistenteException e) {
            fail("Debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void agregarAlumnoFailMailSinArroba() {
        Alumno alumno = new Alumno("pepe pepin", "Dorrego 8256", "alguiengmail.com");
        try {
            this.sistema.agregarAlumno(alumno);
            fail("No deberia agregarse el alumno y debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (ClaveYaExistenteException e) {
            fail("Debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void agregarAlumnoFailMailSinCaracteresAntesArroba() {
        Alumno alumno = new Alumno("pepe pepin", "Dorrego 8256", "@gmail.com");
        try {
            this.sistema.agregarAlumno(alumno);
            fail("No deberia agregarse el alumno y debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (ClaveYaExistenteException e) {
            fail("Debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void agregarAlumnoFailMailSinCaracteresDespuesArroba() {
        Alumno alumno = new Alumno("pepe pepin", "Dorrego 8256", "alguien@");
        try {
            this.sistema.agregarAlumno(alumno);
            fail("No deberia agregarse el alumno y debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (ClaveYaExistenteException e) {
            fail("Debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void buscarAlumno() {
        try {
            Iterator<Alumno> it = this.sistema.buscarAlumno("juan");
            fail("Deberia lanzarse una excepcion de tipo NoEncontradoException");
        } catch (NoEncontradoException e) {
            // OK
        }
    }
}
