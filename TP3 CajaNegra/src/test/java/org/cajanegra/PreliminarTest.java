package org.cajanegra;

import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import modelo.Alumno;
import modelo.IndiceDoble;
import modelo.Sistema;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Probar si el metodo de la clase Sistema efectivamente agrega.
 */
public class PreliminarTest {
    private Sistema sistema;
    private IndiceDoble<Alumno> colectAlumnos;
    private IndiceDoble<Alumno> testColectAlumnos;

    @Before
    public void setUp() throws Exception {
        this.sistema = new Sistema();
        this.colectAlumnos = new IndiceDoble<>();
    }

    @After
    public void tearDown() throws Exception {
        this.sistema = null;
        this.colectAlumnos = null;
        this.testColectAlumnos = null;
    }

    /**
     * Agregar un alumno desde una lista vacia.<br>
     */
    @Test
    public void agregarListaVacia() {
        // sin legajo asigado
        Alumno alumno = new Alumno("juan", "calle falsa 123", "juan@gmail.com");
        try {
            this.sistema.agregarAlumno(alumno);
        } catch (ClaveYaExistenteException | DatoInvalidoException e) {
            fail("No deberia lanzarse ninguna excepcion.");
        }
        this.testColectAlumnos = this.sistema.getAlumnos();
        assertTrue("No agrego y tenia que hacero", this.testColectAlumnos.contieneValor(alumno));
    }

    @Test
    public void agregarListaConUnAlumno() {
        this.sistema.setAlumnos(this.colectAlumnos); // inicilizo con lista vacia

        // Agrego 1 alumno
        Alumno alumno = new Alumno("juan", "calle falsa 123", "juan@gmail.com");
        try {
            this.sistema.agregarAlumno(alumno);
        } catch (ClaveYaExistenteException | DatoInvalidoException e) {
            fail("No deberia lanzarse ninguna excepcion.");
        }

        // Abrego otro alumno
        Alumno alumno1 = new Alumno("cande mateos", "calle falsa 1452", "cande@cande.com");
        try {
            this.sistema.agregarAlumno(alumno1);
        } catch (ClaveYaExistenteException | DatoInvalidoException e) {
            fail("No deberia lanzarse ninguna excepcion.");
        }
        this.testColectAlumnos = this.sistema.getAlumnos();
        assertTrue("no agrego a la coleccion", this.testColectAlumnos.contieneValor(alumno1) && this.testColectAlumnos.contieneValor(alumno));
    }

    @Test
    public void agregarListaConDosAlumno() {
        this.sistema.setAlumnos(this.colectAlumnos); // inicilizo con lista vacia

        Alumno alumno = new Alumno("juan", "calle falsa 123", "juan@gmail.com");
        try {
            this.sistema.agregarAlumno(alumno);
        } catch (ClaveYaExistenteException | DatoInvalidoException e) {
            fail("No deberia lanzarse ninguna excepcion.");
        }

        Alumno alumno1 = new Alumno("cande mateos", "calle falsa 1452", "cande@cande.com");
        try {
            this.sistema.agregarAlumno(alumno1);
        } catch (ClaveYaExistenteException | DatoInvalidoException e) {
            fail("No deberia lanzarse ninguna excepcion.");
        }
        this.testColectAlumnos = this.sistema.getAlumnos();

        Alumno alumno2 = new Alumno("guada mateos", "calle verdadera 1452", "guada@cande.com");
        try {
            this.sistema.agregarAlumno(alumno2);
        } catch (ClaveYaExistenteException | DatoInvalidoException e) {
            fail("No deberia lanzarse ninguna excepcion.");
        }
        this.testColectAlumnos = this.sistema.getAlumnos();
        assertTrue("no agrego a la coleccion", this.testColectAlumnos.contieneValor(alumno2) && this.testColectAlumnos.contieneValor(alumno1) && this.testColectAlumnos.contieneValor(alumno));
    }
}
