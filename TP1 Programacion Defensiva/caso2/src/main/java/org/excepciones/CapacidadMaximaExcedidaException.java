package org.excepciones;

/**
 * Excepcion lanzada en caso de que se supere la capacidad del surtidor.<br>
 */
public class CapacidadMaximaExcedidaException extends Exception {
    public CapacidadMaximaExcedidaException(String message) {
        super(message);
    }
}
