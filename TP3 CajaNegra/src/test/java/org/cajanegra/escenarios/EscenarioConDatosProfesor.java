package org.cajanegra.escenarios;

import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import modelo.IndiceDoble;
import modelo.Profesor;
import modelo.Sistema;

public class EscenarioConDatosProfesor {
    private final Sistema sistema = new Sistema();
    private final Profesor profesor = new Profesor("Miguel Perez", "cordoba 1785", "miguel_perez@hotmail.com", "155257489");

    public void setUp() {
        this.sistema.setProfesores(new IndiceDoble<Profesor>());
        try {
            this.sistema.agregarProfesor(this.profesor);
            this.sistema.agregarProfesor(new Profesor("Carlos Diaz", "mitre 2585", "carlos@hotmail.com", "158267489"));
            this.sistema.agregarProfesor(new Profesor("Laura Lopez", "gascon 3485", "laulos@hotmail.com", "158274189"));
            this.sistema.agregarProfesor(new Profesor("Maria Sanchez", "falucho 85", "maria@hotmail.com", "156258963"));
            this.sistema.agregarProfesor(new Profesor("Lucia Rodrigues", "san luis 1785", "lucia@hotmail.com", "154125632"));
            this.sistema.agregarProfesor(new Profesor("Valentina Gimenez", "paso 552", "valen@hotmail.com", "155123456"));
            this.sistema.agregarProfesor(new Profesor("Pedro Lopez", "brown 452", "pedro@hotmail.com", "155963852"));
        } catch (ClaveYaExistenteException | DatoInvalidoException e) {
            e.printStackTrace();
        }
    }

    public void tearDown() {
        this.sistema.setProfesores(new IndiceDoble<Profesor>());
    }

    public Sistema getSistema() {
        return this.sistema;
    }

    public Profesor getProfesor() {
        return this.profesor;
    }
}
