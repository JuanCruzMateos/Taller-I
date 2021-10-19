package org.cajanegra.alumno;

import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import excepciones.NoEncontradoException;
import modelo.Alumno;
import org.cajanegra.escenarios.EscenarioConDatosAlumno;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SistemaAgregarAlumnoConDatosTest {
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
    public void agregarAlumnoSuccess() {
        Alumno nuevo = new Alumno("sofia alvarez", "quintana 1482", "sofi@sofi.com");
        try {
            this.escenarioConDatos.getSistema().agregarAlumno(nuevo);
        } catch (ClaveYaExistenteException | DatoInvalidoException e) {
            fail("No deberia lanzarse ninguna excepcion al ingresar un alumno valido");
        } catch (Exception e) {
            fail("No deberia lanzarse ningun tipo de excepcion");
        }
        // si se agrego, debeo verificar que en verdad es asi
        assertTrue("No se ingreso un alumno valido", this.escenarioConDatos.getSistema().getAlumnos().contieneValor(nuevo));
        // se indexo correctamente
        assertNotNull("No se genero clave primario", nuevo.getClavePrimaria());
        assertNotNull("No se genero legajo", nuevo.getLegajo());
        // se agrego el alumno correctante
        try {
            assertEquals("No se ingreso el alumno indicado", nuevo, this.escenarioConDatos.getSistema().getAlumnos().buscarPorClavePrimaria(nuevo.getClavePrimaria()));
        } catch (NoEncontradoException e) {
            fail("No deberia lanzarse ningun tipo de excepcion");
        }
    }

    @Test
    public void agregarAlumnoNullTest() {
        try {
            this.escenarioConDatos.getSistema().agregarAlumno(null);
            fail("No deberia agregarse un null como alumno");
        } catch (ClaveYaExistenteException | DatoInvalidoException e) {
            fail("No deberia lanzarse ninguna excepcion de tipo ClaveYaExistenteException o DatoInvalidoException");
        } catch (Exception e) {
            fail("Argumento nulo, deberia salir por excepcion especifica");
        }
    }

    @Test
    public void agregarAlumnoRepetidoTest() {
        Alumno nuevo = new Alumno("sofia alvarez", "quintana 1482", "sofi@sofi.com");
        try {
            this.escenarioConDatos.getSistema().agregarAlumno(nuevo);
            this.escenarioConDatos.getSistema().agregarAlumno(nuevo);
            fail("No deberia poder agregarse un alumno repetido a la coleccion");
        } catch (ClaveYaExistenteException e) {
            // OK
        } catch (DatoInvalidoException e) {
            fail("Deberia salir por ClaveYaExistenteException");
        } catch (Exception e) {
            fail("Deberia salir por ClaveYaExistenteException");
        }
    }

    @Test
    public void agregarAlumnoDuplicadoest() {
        Alumno nuevo = new Alumno(this.escenarioConDatos.getAlumno().getApellidoNombre(), this.escenarioConDatos.getAlumno().getDomicilio(), this.escenarioConDatos.getAlumno().getMail());
        try {
            this.escenarioConDatos.getSistema().agregarAlumno(nuevo);
            fail("No deberia poder agregarse un alumno duplicado a la coleccion");
        } catch (ClaveYaExistenteException e) {
            // OK
        } catch (DatoInvalidoException e) {
            fail("Deberia salir por ClaveYaExistenteException");
        } catch (Exception e) {
            fail("Deberia salir por ClaveYaExistenteException");
        }
    }

    @Test
    public void agregarAlumnoFailNombreVacio() {
        Alumno alumno = new Alumno("", "Dorrego 8256", "juan@gmail.com");
        try {
            this.escenarioConDatos.getSistema().agregarAlumno(alumno);
            fail("No debe agregarse un alumno con nombre vacio");
        } catch (ClaveYaExistenteException e) {
            fail("Debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia resolverser por excepcion del tipo DatoInvalidoException");
        }
    }

    @Test
    public void agregarAlumnoFailNombreNull() {
        Alumno alumno = new Alumno(null, "Dorrego 8256", "juan@gmail.com");
        try {
            this.escenarioConDatos.getSistema().agregarAlumno(alumno);
            fail("No debe agregarse un alumno con nombre null");
        } catch (ClaveYaExistenteException e) {
            fail("Debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia resolverser por excepcion del tipo DatoInvalidoException");
        }
    }

    @Test
    public void agregarAlumnoFailDireccionVacio() {
        Alumno alumno = new Alumno("juan cruz", "", "juan@gmail.com");
        try {
            this.escenarioConDatos.getSistema().agregarAlumno(alumno);
            fail("No deberia agregarse el alumno con domicilio vacio");
        } catch (ClaveYaExistenteException e) {
            fail("Debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia resolverser por excepcion del tipo DatoInvalidoException");
        }
    }

    @Test
    public void agregarAlumnoFailDireccionNull() {
        Alumno alumno = new Alumno("juan cruz", null, "juan@gmail.com");
        try {
            this.escenarioConDatos.getSistema().agregarAlumno(alumno);
            fail("No deberia agregarse el alumno con domicilio null");
        } catch (ClaveYaExistenteException e) {
            fail("Debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia resolverser por excepcion del tipo DatoInvalidoException");
        }
    }

//    @Test
//    // igual caso de prueba que mail sin @ :: perteneces a la misma clase de equivalencia
//    public void agregarAlumnoFailMailVacio() {
//        Alumno alumno = new Alumno("pepe pepin", "Dorrego 8256", "");
//        try {
//            this.escenarioConDatos.getSistema().agregarAlumno(alumno);
//            fail("No deberia agregarse el alumno y debe lanzarse la excepcion de tipo DatoInvalidoException");
//        } catch (ClaveYaExistenteException e) {
//            fail("Debe lanzarse la excepcion de tipo DatoInvalidoException");
//        } catch (DatoInvalidoException e) {
//            // OK
//        }
//    }

    @Test
    public void agregarAlumnoFailMailNull() {
        Alumno alumno = new Alumno("pepe pepin", "Dorrego 8256", null);
        try {
            this.escenarioConDatos.getSistema().agregarAlumno(alumno);
            fail("No deberia agregarse el alumno con main null");
        } catch (ClaveYaExistenteException e) {
            fail("Debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia resolverser por excepcion del tipo DatoInvalidoException");
        }
    }

    @Test
    public void agregarAlumnoFailMailSinArroba() {
        Alumno alumno = new Alumno("pepe pepin", "Dorrego 8256", "alguiengmail.com");
        try {
            this.escenarioConDatos.getSistema().agregarAlumno(alumno);
            fail("No deberia agregarse el alumno con mail sin @");
        } catch (ClaveYaExistenteException e) {
            fail("Debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia resolverser por excepcion del tipo DatoInvalidoException");
        }
    }

    @Test
    public void agregarAlumnoFailMailSinCaracteresAntesArroba() {
        Alumno alumno = new Alumno("pepe pepin", "Dorrego 8256", "@gmail.com");
        try {
            this.escenarioConDatos.getSistema().agregarAlumno(alumno);
            fail("No deberia agregarse el alumno con mail sin caracteres antes del @");
        } catch (ClaveYaExistenteException e) {
            fail("Debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia resolverser por excepcion del tipo DatoInvalidoException");
        }
    }

    @Test
    public void agregarAlumnoFailMailSinCaracteresDespuesArroba() {
        Alumno alumno = new Alumno("pepe pepin", "Dorrego 8256", "alguien@");
        try {
            this.escenarioConDatos.getSistema().agregarAlumno(alumno);
            fail("No deberia agregarse el alumno con mail sin caracteres despues del @");
        } catch (ClaveYaExistenteException e) {
            fail("Debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia resolverser por excepcion del tipo DatoInvalidoException");
        }
    }
}
