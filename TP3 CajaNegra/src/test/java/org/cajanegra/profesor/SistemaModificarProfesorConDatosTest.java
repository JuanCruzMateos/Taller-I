package org.cajanegra.profesor;

import excepciones.DatoInvalidoException;
import modelo.Profesor;
import org.cajanegra.escenarios.EscenarioConDatosProfesor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SistemaModificarProfesorConDatosTest {
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
    public void modificarProfesorSuccess() {
        Profesor modif = new Profesor("sofia alvarez", "quintana 1482", "sofi@gmail.com", "154741258");
        Object clave = this.es.getProfesor().getClavePrimaria();
        String legajo = this.es.getProfesor().getLegajo();

        try {
            this.es.getSistema().modificarProfesor(this.es.getProfesor(), modif);
        } catch (DatoInvalidoException e) {
            fail("No deberia lanzarse excepcion con datos validos");
        } catch (Exception e) {
            fail("No deberia lanzarse ningun tipo de excepcion");
        }
        assertEquals("No se modifico correctamente el nombre", modif.getApellidoNombre(), this.es.getProfesor().getApellidoNombre());
        assertEquals("No se modifico correctamente el domicilio", modif.getDomicilio(), this.es.getProfesor().getDomicilio());
        assertEquals("No se modifico correctamente el mail", modif.getMail(), this.es.getProfesor().getMail());
        assertEquals("No se modifico correctamente el telefono", modif.getTelefono(), this.es.getProfesor().getTelefono());
        assertEquals("La clave primaria no deberia modificarse", clave, this.es.getProfesor().getClavePrimaria());
        assertEquals("El legajo no deberia modificarse", legajo, this.es.getProfesor().getLegajo());
    }

    @Test
    public void modificarProfesorModifNull() {
        try {
            this.es.getSistema().modificarProfesor(this.es.getProfesor(), null);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        }
    }

    @Test
    public void modificarProfesorFailNombreVacio() {
        Profesor modif = new Profesor("", "quintana 1482", "sofi@gmail.com", "154741258");

        try {
            this.es.getSistema().modificarProfesor(this.es.getProfesor(), modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        }
    }

    @Test
    public void modificarProfesorFailNombreNull() {
        Profesor modif = new Profesor(null, "quintana 1482", "sofi@gmail.com", "154741258");

        try {
            this.es.getSistema().modificarProfesor(this.es.getProfesor(), modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        }
    }

    @Test
    public void modificarProfesorFailDireccionVacio() {
        Profesor modif = new Profesor("sofia alvarez", "", "sofi@gmail.com", "154741258");

        try {
            this.es.getSistema().modificarProfesor(this.es.getProfesor(), modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        }
    }

    @Test
    public void modificarProfesorFailDireccionNull() {
        Profesor modif = new Profesor("sofia alvarez", null, "sofi@gmail.com", "154741258");

        try {
            this.es.getSistema().modificarProfesor(this.es.getProfesor(), modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        }
    }

    @Test
    public void modificarProfesorFailMailNull() {
        Profesor modif = new Profesor("sofia alvarez", "quintana 1482", null, "154741258");

        try {
            this.es.getSistema().modificarProfesor(this.es.getProfesor(), modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        }
    }

    @Test
    public void modificarProfesorFailMailSinArroba() {
        Profesor modif = new Profesor("sofia alvarez", "quintana 1482", "sofigmail.com", "154741258");

        try {
            this.es.getSistema().modificarProfesor(this.es.getProfesor(), modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        }
    }

    @Test
    public void modificarProfesorFailMailSinCaracteresAntesArroba() {
        Profesor modif = new Profesor("sofia alvarez", "quintana 1482", "@gmail.com", "154741258");

        try {
            this.es.getSistema().modificarProfesor(this.es.getProfesor(), modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        }
    }

    @Test
    public void modificarProfesorFailMailSinCaracteresDespuesArroba() {
        Profesor modif = new Profesor("sofia alvarez", "quintana 1482", "sofi@", "154741258");

        try {
            this.es.getSistema().modificarProfesor(this.es.getProfesor(), modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        }
    }

    @Test
    public void modificarProfesorFailTelefonoVacio() {
        Profesor modif = new Profesor("sofia alvarez", "quintana 1482", "sofi@gmail.com", "");

        try {
            this.es.getSistema().modificarProfesor(this.es.getProfesor(), modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        }
    }

    @Test
    public void modificarProfesorFailTelefonoNull() {
        Profesor modif = new Profesor("sofia alvarez", "quintana 1482", "sofi@gmail.com", null);

        try {
            this.es.getSistema().modificarProfesor(this.es.getProfesor(), modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        }
    }
}
