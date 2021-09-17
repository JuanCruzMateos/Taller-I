package Excepciones;

/**
 * @autor Taller1
 * 
 * Esta clase representa una excepcion lanzada cuando se intenta instaciar un domicilio 
 * con direccion repetida.
 */

public class DomicilioRepetidoException extends Exception {
	private String direcDuplicada;
	
        /**
         *    Constructor de la interrupción con dos argumentos
         * Mensaje y dirección repetida.
        */
        
	public DomicilioRepetidoException(String arg0, String direccion) {
		super(arg0);
		this.direcDuplicada=direccion;
	}

         /**
         *    El método devuelve la dirección repetida.
        */
        
	public String getDirecDuplicada() {
		return direcDuplicada;
	}
}
