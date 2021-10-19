package org.cajanegra.alumno;

import excepciones.DatoInvalidoException;
import modelo.Alumno;
import org.cajanegra.escenarios.EscenarioConDatosAlumno;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SistemaModificarAlumnoConDatosTest {
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
    public void modificarAlumnoSuccess() {
        Alumno modif = new Alumno("carlos carlitos", "lodecarlos 1344", "carlos@carlitos.com");
        Object clave = this.escenarioConDatos.getAlumno().getClavePrimaria();
        String legajo = this.escenarioConDatos.getAlumno().getLegajo();

        try {
            this.escenarioConDatos.getSistema().modificarAlumno(this.escenarioConDatos.getAlumno(), modif);
        } catch (DatoInvalidoException e) {
            fail("No deberia lanzarse excepcion con datos validos");
        } catch (Exception e) {
            fail("No deberia lanzarse ningun tipo de excepcion");
        }
        assertEquals("No se modifico correctamente el nombre", modif.getApellidoNombre(), this.escenarioConDatos.getAlumno().getApellidoNombre());
        assertEquals("No se modifico correctamente el domicilio", modif.getDomicilio(), this.escenarioConDatos.getAlumno().getDomicilio());
        assertEquals("No se modifico correctamente el mail", modif.getMail(), this.escenarioConDatos.getAlumno().getMail());
        assertEquals("La clave primaria no deberia modificarse", clave, this.escenarioConDatos.getAlumno().getClavePrimaria());
        assertEquals("El legajo no deberia modificarse", legajo, this.escenarioConDatos.getAlumno().getLegajo());
    }

    @Test
    public void modificarAlumnoMofifNull() {
        try {
            this.escenarioConDatos.getSistema().modificarAlumno(this.escenarioConDatos.getAlumno(), null);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        }
    }

    @Test
    public void modificarAlumnoFailNombreVacio() {
        Alumno modif = new Alumno("", "lodecarlos 1344", "carlos@carlitos.com");

        try {
            this.escenarioConDatos.getSistema().modificarAlumno(this.escenarioConDatos.getAlumno(), modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        }
    }

    @Test
    public void modificarAlumnoFailNombreNull() {
        Alumno modif = new Alumno(null, "lodecarlos 1344", "carlos@carlitos.com");

        try {
            this.escenarioConDatos.getSistema().modificarAlumno(this.escenarioConDatos.getAlumno(), modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        }
    }

    @Test
    public void modificarAlumnoFailDireccionVacio() {
        Alumno modif = new Alumno("carlos carlitos", "", "carlos@carlitos.com");

        try {
            this.escenarioConDatos.getSistema().modificarAlumno(this.escenarioConDatos.getAlumno(), modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        }
    }

    @Test
    public void modificarAlumnoFailDireccionNull() {
        Alumno modif = new Alumno("carlos carlitos", null, "carlos@carlitos.com");

        try {
            this.escenarioConDatos.getSistema().modificarAlumno(this.escenarioConDatos.getAlumno(), modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        }
    }

//    misma particion de equivalencia que mail sin @
//    @Test
//    public void modificarAlumnoFailMailVacio() {
//        Alumno modif = new Alumno("carlos carlitos", "lodecarlitos 12345", "");
//        try {
//            this.escenarioConDatos.getSistema().modificarAlumno(this.escenarioConDatos.getAlumno(), modif);
//            fail("No deberia haberse realizado la modificacion");
//        } catch (DatoInvalidoException e) {
//            // OK
//        } catch (Exception e) {
//            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
//        }
//    }

    @Test
    public void modificarAlumnoFailMailNull() {
        Alumno modif = new Alumno("carlos carlitos", "lodecarlitos 12345", null);
        try {
            this.escenarioConDatos.getSistema().modificarAlumno(this.escenarioConDatos.getAlumno(), modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        }
    }

    @Test
    public void modificarAlumnoFailMailSinArroba() {
        Alumno modif = new Alumno("carlos carlitos", "lodecarlitos 12345", "carloscarlitos.com");
        try {
            this.escenarioConDatos.getSistema().modificarAlumno(this.escenarioConDatos.getAlumno(), modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        }
    }

    @Test
    public void modificarAlumnoFailMailSinCaracteresAntesArroba() {
        Alumno modif = new Alumno("carlos carlitos", "lodecarlitos 12345", "@carlitos.com");
        try {
            this.escenarioConDatos.getSistema().modificarAlumno(this.escenarioConDatos.getAlumno(), modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        }
    }

    @Test
    public void modificarAlumnoFailMailSinCaracteresDespuesArroba() {
        Alumno modif = new Alumno("carlos carlitos", "lodecarlitos 12345", "carlos@");
        try {
            this.escenarioConDatos.getSistema().modificarAlumno(this.escenarioConDatos.getAlumno(), modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        } catch (Exception e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        }
    }
}
