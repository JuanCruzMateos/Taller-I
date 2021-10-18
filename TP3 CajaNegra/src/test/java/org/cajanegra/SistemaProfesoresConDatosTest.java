package org.cajanegra;

import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import excepciones.NoEncontradoException;
import modelo.IndiceDoble;
import modelo.Profesor;
import modelo.Sistema;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class SistemaProfesoresConDatosTest {
    private Sistema sistema = new Sistema();
    private Profesor profesor;

    @Before
    public void setUp() {
        this.profesor = new Profesor("Carlos Perez", "calle1 2536", "carlos@gmail.com", "4125858");

        try {
            this.sistema.agregarProfesor(profesor);
            this.sistema.agregarProfesor(new Profesor("Miguel Rodriguez", "calle2 4336", "miguel@gmail.com", "155258963"));
            this.sistema.agregarProfesor(new Profesor("Maria Paez", "calle2 1719", "maria@gmail.com", "156254782"));
            this.sistema.agregarProfesor(new Profesor("Sofia Lezama", "calle3 8929", "sofia@gmail.com", "154521478"));
            this.sistema.agregarProfesor(new Profesor("Juan Gomez", "calle7 3626", "juan@gmail.com", "155128923"));
            this.sistema.agregarProfesor(new Profesor("Lautaro Sanchez", "calle10 9936", "lautaro@gmail.com", "155248625"));
        } catch (ClaveYaExistenteException | DatoInvalidoException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        this.sistema.setProfesores(new IndiceDoble<Profesor>());
        this.profesor = null;
    }

    @Test
    public void agregarProfesorSuccess() {
        Profesor nuevo = new Profesor("Ivan Rojas", "cordoba 1452", "ivi@gmail.com", "152789456");

        try {
            this.sistema.agregarProfesor(nuevo);
        } catch (ClaveYaExistenteException | DatoInvalidoException e) {
            fail("No deberia lanzarse ninguna excepcion al agregar un nuevo profesor valido");
        }
        // si se agrego, debeo verificar que en verdad es asi
        assertTrue("No se ingreso el nuevo profesor", this.sistema.getProfesores().contieneValor(nuevo));
        // Correctamente indexado
        assertNotNull("No se genero clave primaria", nuevo.getClavePrimaria());
        assertNotNull("No se genero legajo", nuevo.getLegajo());
    }

    @Test
    public void agregarProfesorFailLegajoExistenteTest() {
        // TODO :: revisar, como hago?


    }

    @Test
    public void agregarProfesorFailNombreVacio() {
        Profesor nuevo = new Profesor("", "cordoba 1452", "ivi@gmail.com", "152789456");

        try {
            this.sistema.agregarProfesor(nuevo);
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        } catch (ClaveYaExistenteException e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void agregarProfesorFailNombreNull() {
        Profesor nuevo = new Profesor(null, "cordoba 1452", "ivi@gmail.com", "152789456");

        try {
            this.sistema.agregarProfesor(nuevo);
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        } catch (ClaveYaExistenteException e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void agregarProfesorFailDireccionVacio() {
        Profesor nuevo = new Profesor("Ivan Rojas", "", "ivi@gmail.com", "152789456");
        try {
            this.sistema.agregarProfesor(nuevo);
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        } catch (ClaveYaExistenteException e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void agregarProfesorFailDireccionNull() {
        Profesor nuevo = new Profesor("Ivan Rojas", null, "ivi@gmail.com", "152789456");
        try {
            this.sistema.agregarProfesor(nuevo);
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        } catch (ClaveYaExistenteException e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void agregarProfesorFailMailVacio() {
        Profesor nuevo = new Profesor("Ivan Rojas", "cordoba 1452", "", "152789456");
        try {
            this.sistema.agregarProfesor(nuevo);
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        } catch (ClaveYaExistenteException e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void agregarProfesorFailMailNull() {
        Profesor nuevo = new Profesor("Ivan Rojas", "cordoba 1452", null, "152789456");
        try {
            this.sistema.agregarProfesor(nuevo);
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        } catch (ClaveYaExistenteException e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void agregarProfesorFailMailSinArroba() {
        Profesor nuevo = new Profesor("Ivan Rojas", "cordoba 1452", "ivigmail.com", "152789456");
        try {
            this.sistema.agregarProfesor(nuevo);
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        } catch (ClaveYaExistenteException e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void agregarProfesorFailMailSinCaracteresAntesArroba() {
        Profesor nuevo = new Profesor("Ivan Rojas", "cordoba 1452", "@gmail.com", "152789456");
        try {
            this.sistema.agregarProfesor(nuevo);
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        } catch (ClaveYaExistenteException e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void agregarProfesorFailMailSinCaracteresDespuesArroba() {
        Profesor nuevo = new Profesor("Ivan Rojas", "cordoba 1452", "ivi@", "152789456");
        try {
            this.sistema.agregarProfesor(nuevo);
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        } catch (ClaveYaExistenteException e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void agregarProfesorFailTelefonoVacio() {
        Profesor nuevo = new Profesor("Ivan Rojas", "cordoba 1452", "ivi@gmail.com", "");
        try {
            this.sistema.agregarProfesor(nuevo);
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        } catch (ClaveYaExistenteException e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void agregarProfesorFailTelefonoNull() {
        Profesor nuevo = new Profesor("Ivan Rojas", "cordoba 1452", "ivi@gmail.com", null);
        try {
            this.sistema.agregarProfesor(nuevo);
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        } catch (ClaveYaExistenteException e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void agregarProfesorFailTelefonoNoNumerico() {
        Profesor nuevo = new Profesor("Ivan Rojas", "cordoba 1452", "ivi@gmail.com", "1452tel");
        try {
            this.sistema.agregarProfesor(nuevo);
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        } catch (ClaveYaExistenteException e) {
            fail("Deberia lanzarse una excepcion de tipo DatoInvalidoException");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void eliminarProfesor() {
        this.sistema.eliminarProfesor(this.profesor);
        assertFalse("El profesor no fue correctamente eliminado", this.sistema.getProfesores().contieneValor(this.profesor));
        // TODO :: El sistema tiene un profesor menos que fue dado de baja de todas las cursadas en las que participaba.
    }

    @Test
    public void buscarProfesorSuccess() {
        Iterator<Profesor> it;
        int cant = 0;
        try {
            it = this.sistema.buscarProfesor("sofia");
            assertTrue("Se deberian haber encontrado al menos un resultado", it.hasNext());
            while (it.hasNext()) {
                cant += 1;
                it.next();
            }
            assertEquals("El numero de resultados no se corresponde al los profesores presentes", cant, 1);
        } catch (NoEncontradoException e) {
            fail("No deberia lanzarse una excepcion al buscar a un profesor que esta en el sistema");
        }
    }

    @Test
    public void buscarProfesorFail() {
        try {
            Iterator<Profesor> it = this.sistema.buscarProfesor("eduardo");
            fail("No deberia haber coincidencias al buscar a un profesor que no esta en el sistema");
        } catch (NoEncontradoException e) {
            // OK
        }
    }

    @Test
    public void modificarProfesorSuccess() {
        Profesor modif = new Profesor("Edgardo Muller", "calleFalsa 1344", "edgar_mull@yahoo.com", "154827856");
        Object clave = this.profesor.getClavePrimaria();
        String legajo = this.profesor.getLegajo();

        try {
            this.sistema.modificarProfesor(this.profesor, modif);
        } catch (DatoInvalidoException e) {
            fail("No deberia lanzarse excepcion con datos validos");
        }
        assertEquals("No se modifico correctamente el nombre", modif.getApellidoNombre(), this.profesor.getApellidoNombre());
        assertEquals("No se modifico correctamente el domicilio", modif.getDomicilio(), this.profesor.getDomicilio());
        assertEquals("No se modifico correctamente el mail", modif.getMail(), this.profesor.getMail());
        assertEquals("No se modifico correctamente el telefono", modif.getTelefono(), this.profesor.getTelefono());
        assertEquals("La clave 1° no deberia modificarse", clave, this.profesor.getClavePrimaria());
        assertEquals("El legajo no deberia modificarse", legajo, this.profesor.getLegajo());
    }

    @Test
    public void modificarProfesorFailClasesDistintas() {
        // TODO
    }

    @Test
    public void modificarProfesorFailNombreVacio() {

    }

    @Test
    public void modificarProfesorFailNombreNull() {

    }

    @Test
    public void modificarProfesorFailDireccionVacio() {

    }

    @Test
    public void modificarProfesorFailDireccionNull() {

    }

    @Test
    public void modificarProfesorFailMailVacio() {

    }

    @Test
    public void modificarProfesorFailMailNull() {

    }

    @Test
    public void modificarProfesorFailMailSinArroba() {

    }

    @Test
    public void modificarProfesorFailMailSinCaracteresAntesArroba() {

    }

    @Test
    public void modificarProfesorFailMailSinCaracteresDespuesArroba() {
    }
}
