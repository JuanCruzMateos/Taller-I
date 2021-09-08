package org.excepciones;

public class CapacidadExcedidaException extends Exception {
    private int capacidad;

    public CapacidadExcedidaException(String message, int capacidad) {
        super(message);
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }
}
