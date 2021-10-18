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

/**
 * Clase para probar los metodos de la clase Sistema en un escenario con datos.<br>
 * >>> Agregar
 * >>> Eliminar
 * >>> Buscar
 * >>> Modificar
 */
public class SistemaAlumnoConDatosTest {
    private Sistema sistema = new Sistema();
    private Alumno alumno;

    @Before
    public void setUp() {
        this.sistema = new Sistema();
        this.alumno = new Alumno("juan cruz", "calle falsa 123", "juan@cruz.com");

        try {
            this.sistema.agregarAlumno(alumno);
            this.sistema.agregarAlumno(new Alumno("cande cande", "evergreen 1475", "cande@cande.com"));
            this.sistema.agregarAlumno(new Alumno("guada guada", "Wallaby St. 42", "guada@guada.com"));
            this.sistema.agregarAlumno(new Alumno("loli loli", "paso 145", "loli@loli.com"));
            this.sistema.agregarAlumno(new Alumno("pepe mateos", "falucho 75", "pepe@pepe.com"));
            this.sistema.agregarAlumno(new Alumno("pipi mateos", "mitre 55", "pipi@pipi.com"));
        } catch (ClaveYaExistenteException | DatoInvalidoException e) {
            e.printStackTrace();
        }
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

//    @Test
//    public void agregarAlumnoRepetidoTest() {
//        // TODO
//        Alumno nuevo = new Alumno("sofia alvarez", "quintana 1482", "sofi@sofi.com");
//        try {
//            this.sistema.agregarAlumno(nuevo);
//            this.sistema.agregarAlumno(nuevo);
//        } catch (ClaveYaExistenteException | DatoInvalidoException e) {
//            // si se lanza una excepcion es un error
//            fail("No deberia lanzarse ninguna excepcion al ingresar un alumno valido");
//        }
//    }

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
    public void eliminarAlumno() {
        this.sistema.eliminarAlumno(this.alumno);
        assertFalse("El alumno deberia haberse eliminado", this.sistema.getAlumnos().contieneValor(this.alumno));
        // TODO :: El sistema tiene un alumno menos que fue dado de baja de todas las cursadas en las que participaba.
    }

    @Test
    public void buscarAlumnoSuccess() {
        Iterator<Alumno> it;
        int cant = 0;
        try {
            it = this.sistema.buscarAlumno("mateos");
            assertTrue("Se deberian haber encontrado al menos un resultado", it.hasNext());
            while (it.hasNext()) {
                cant += 1;
                it.next();
            }
            assertEquals("El numero de resultados no se corresponde al los alumnos presentes", cant, 2);
        } catch (NoEncontradoException e) {
            fail("No deberia lanzarse una excepcion al buscar a un alumno que esta en el sistema");
        }
    }

    @Test
    public void buscarAlumnoFail() {
        Iterator<Alumno> it;
        try {
            it = this.sistema.buscarAlumno("carlos");
            fail("No deberia haber coincidencias al buscar a un alumno que no esta en el sistema");
        } catch (NoEncontradoException e) {
            // OK
        }
    }

    @Test
    public void modificarAlumnoSuccess() {
        Alumno modif = new Alumno("carlos carlitos", "lodecarlos 1344", "carlos@carlitos.com");
        Object clave = this.alumno.getClavePrimaria();
        String legajo = this.alumno.getLegajo();

        try {
            this.sistema.modificarAlumno(this.alumno, modif);
        } catch (DatoInvalidoException e) {
            fail("No deberia lanzarse excepcion con datos validos");
        }
        assertEquals("No se modifico correctamente el nombre", modif.getApellidoNombre(), this.alumno.getApellidoNombre());
        assertEquals("No se modifico correctamente el domicilio", modif.getDomicilio(), this.alumno.getDomicilio());
        assertEquals("No se modifico correctamente el mail", modif.getMail(), this.alumno.getMail());
        assertEquals("La clave 1° no deberia modificarse", clave, this.alumno.getClavePrimaria());
        assertEquals("El legajo no deberia modificarse", legajo, this.alumno.getLegajo());
    }

    @Test
    public void mofificarAlumnoFailClasesDistintas() {
        // TODO
    }

    @Test
    public void modificarAlumnoFailNombreVacio() {
        Alumno modif = new Alumno("", "lodecarlos 1344", "carlos@carlitos.com");

        try {
            this.sistema.modificarAlumno(this.alumno, modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void modificarAlumnoFailNombreNull() {
        Alumno modif = new Alumno(null, "lodecarlos 1344", "carlos@carlitos.com");

        try {
            this.sistema.modificarAlumno(this.alumno, modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void modificarAlumnoFailDireccionVacio() {
        Alumno modif = new Alumno("carlos carlitos", "", "carlos@carlitos.com");

        try {
            this.sistema.modificarAlumno(this.alumno, modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void modificarAlumnoFailDireccionNull() {
        Alumno modif = new Alumno("carlos carlitos", null, "carlos@carlitos.com");

        try {
            this.sistema.modificarAlumno(this.alumno, modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void modificarAlumnoFailMailVacio() {
        Alumno modif = new Alumno("carlos carlitos", "lodecarlitos 12345", "");
        try {
            this.sistema.modificarAlumno(this.alumno, modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void modificarAlumnoFailMailNull() {
        Alumno modif = new Alumno("carlos carlitos", "lodecarlitos 12345", null);
        try {
            this.sistema.modificarAlumno(this.alumno, modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void modificarAlumnoFailMailSinArroba() {
        Alumno modif = new Alumno("carlos carlitos", "lodecarlitos 12345", "carloscarlitos.com");
        try {
            this.sistema.modificarAlumno(this.alumno, modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void modificarAlumnoFailMailSinCaracteresAntesArroba() {
        Alumno modif = new Alumno("carlos carlitos", "lodecarlitos 12345", "@carlitos.com");
        try {
            this.sistema.modificarAlumno(this.alumno, modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }

    @Test
    public void modificarAlumnoFailMailSinCaracteresDespuesArroba() {
        Alumno modif = new Alumno("carlos carlitos", "lodecarlitos 12345", "carlos@");
        try {
            this.sistema.modificarAlumno(this.alumno, modif);
            fail("No deberia haberse realizado la modificacion");
        } catch (DatoInvalidoException e) {
            // OK
        }
    }
}
