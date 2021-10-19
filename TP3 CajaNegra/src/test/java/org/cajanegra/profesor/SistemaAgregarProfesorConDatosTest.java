package org.cajanegra.profesor;

import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import excepciones.NoEncontradoException;
import modelo.Profesor;
import org.cajanegra.escenarios.EscenarioConDatosProfesor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SistemaAgregarProfesorConDatosTest {
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
    public void agregarProfesorSuccess() {
        Profesor nuevo = new Profesor("sofia alvarez", "quintana 1482", "sofi@gmail.com", "154741258");
        try {
            this.es.getSistema().agregarProfesor(nuevo);
        } catch (ClaveYaExistenteException | DatoInvalidoException e) {
            fail("No deberia lanzarse ninguna excepcion al ingresar un profe valido");
        } catch (Exception e) {
            fail("No deberia lanzarse ningun tipo de excepcion");
        }

        // si se agrego, debeo verificar que en verdad es asi
        assertTrue("No se ingreso un profe valido", this.es.getSistema().getProfesores().contieneValor(nuevo));
        // se indexo correctamente
        assertNotNull("No se genero clave primario", nuevo.getClavePrimaria());
        assertNotNull("No se genero legajo", nuevo.getLegajo());
        // se agrego el alumno correctante
        try {
            assertEquals("No se ingreso el profe indicado", nuevo, this.es.getSistema().getProfesores().buscarPorClavePrimaria(nuevo.getClavePrimaria()));
        } catch (NoEncontradoException e) {
            fail("No deberia lanzarse ningun tipo de excepcion");
        }
    }

    @Test
    public void agregarProfeNullTest() {
        try {
            this.es.getSistema().agregarProfesor(null);
            fail("No deberia agregarse un null como profesor");
        } catch (ClaveYaExistenteException | DatoInvalidoException e) {
            fail("No deberia lanzarse ninguna excepcion de tipo ClaveYaExistenteException o DatoInvalidoException");
        } catch (Exception e) {
            fail("Argumento nulo, deberia salir por excepcion especifica");
        }
    }

    @Test
    public void agregarProfeRepetidoTest() {
        Profesor nuevo = new Profesor("sofia alvarez", "quintana 1482", "sofi@sofi.com", "154741258");
        try {
            this.es.getSistema().agregarProfesor(nuevo);
            this.es.getSistema().agregarProfesor(nuevo);
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
    public void agregarProfeDuplicado() {
        Profesor nuevo = new Profesor(this.es.getProfesor().getApellidoNombre(), this.es.getProfesor().getDomicilio(), this.es.getProfesor().getMail(), this.es.getProfesor().getTelefono());
        try {
            this.es.getSistema().agregarProfesor(nuevo);
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
    public void agregarProfeFailNombreVacio() {
        Profesor nuevo = new Profesor("", "quintana 1482", "sofi@gmail.com", "154741258");
        try {
            this.es.getSistema().agregarProfesor(nuevo);
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
    public void agregarProfeFailNombreNull() {
        Profesor nuevo = new Profesor(null, "quintana 1482", "sofi@gmail.com", "154741258");
        try {
            this.es.getSistema().agregarProfesor(nuevo);
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
    public void agregarProfeFailDireccionVacio() {
        Profesor nuevo = new Profesor("sofia alvarez", "", "sofi@gmail.com", "154741258");
        try {
            this.es.getSistema().agregarProfesor(nuevo);
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
    public void agregarProfeFailDireccionNull() {
        Profesor nuevo = new Profesor("sofia alvarez", null, "sofi@gmail.com", "154741258");
        try {
            this.es.getSistema().agregarProfesor(nuevo);
            fail("No deberia agregarse el alumno con domicilio null");
        } catch (ClaveYaExistenteException e) {
            fail("Debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia resolverser por excepcion del tipo DatoInvalidoException");
        }
    }

    @Test
    public void agregarProfeFailMailNull() {
        Profesor nuevo = new Profesor("sofia alvarez", "quintana 1482", null, "154741258");
        try {
            this.es.getSistema().agregarProfesor(nuevo);
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
    public void agregarProfeFailMailSinArroba() {
        Profesor nuevo = new Profesor("sofia alvarez", "quintana 1482", "sofigmail.com", "154741258");
        try {
            this.es.getSistema().agregarProfesor(nuevo);
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
    public void agregarProfeFailMailSinCaracteresAntesArroba() {
        Profesor nuevo = new Profesor("sofia alvarez", "quintana 1482", "@gmail.com", "154741258");
        try {
            this.es.getSistema().agregarProfesor(nuevo);
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
    public void agregarProfeFailMailSinCaracteresDespuesArroba() {
        Profesor nuevo = new Profesor("sofia alvarez", "quintana 1482", "sofi@", "154741258");
        try {
            this.es.getSistema().agregarProfesor(nuevo);
            fail("No deberia agregarse el alumno con mail sin caracteres despues del @");
        } catch (ClaveYaExistenteException e) {
            fail("Debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia resolverser por excepcion del tipo DatoInvalidoException");
        }
    }

    @Test
    public void agregarProfeFailTelefonoNull() {
        Profesor nuevo = new Profesor("sofia alvarez", "quintana 1482", "sofi@gmail.com", null);
        try {
            this.es.getSistema().agregarProfesor(nuevo);
            fail("No deberia agregarse el alumno con mail sin caracteres despues del @");
        } catch (ClaveYaExistenteException e) {
            fail("Debe lanzarse la excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia resolverser por excepcion del tipo DatoInvalidoException");
        }
    }

    @Test
    public void agregarProfeFailTelefonoVacio() {
        Profesor nuevo = new Profesor("sofia alvarez", "quintana 1482", "sofi@gmail.com", "");
        try {
            this.es.getSistema().agregarProfesor(nuevo);
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
