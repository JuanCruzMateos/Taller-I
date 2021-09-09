package org.excepciones;

/**
 * Excepcion lanzada en caso de que exista un impedimento para realizar la descarga del surtidor.<br>
 */
public class DescargaImposibleException extends Exception {
    public DescargaImposibleException(String message) {
        super(message);
    }
}
