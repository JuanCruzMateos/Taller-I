package org.cajanegra.escenarios;

import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import modelo.Alumno;
import modelo.IndiceDoble;
import modelo.Sistema;

public class EscenarioConDatosAlumno {
    private final Sistema sistema = new Sistema();
    private final Alumno alumno = new Alumno("juan cruz mateos", "calle falsa 1234", "juancruz@gmail.com");

    public void setUp() {
        try {
            this.sistema.setAlumnos(new IndiceDoble<Alumno>());
            this.sistema.agregarAlumno(this.alumno);
            this.sistema.agregarAlumno(new Alumno("cande cande", "evergreen 1475", "cande@gmail.com"));
            this.sistema.agregarAlumno(new Alumno("guada guada", "Wallaby St. 42", "guada@gmail.com"));
            this.sistema.agregarAlumno(new Alumno("loli loli", "paso 145", "loli@gmail.com"));
            this.sistema.agregarAlumno(new Alumno("pepe mateos", "falucho 75", "pepe@gmail.com"));
            this.sistema.agregarAlumno(new Alumno("pipi mateos", "mitre 55", "pipi@gmail.com"));
        } catch (ClaveYaExistenteException | DatoInvalidoException e) {
            e.printStackTrace();
        }
    }

    public void tearDown() {
        // seteo colecciones vacias
        this.sistema.setAlumnos(new IndiceDoble<Alumno>());
    }

    public Sistema getSistema() {
        return this.sistema;
    }

    public Alumno getAlumno() {
        return this.alumno;
    }
}
