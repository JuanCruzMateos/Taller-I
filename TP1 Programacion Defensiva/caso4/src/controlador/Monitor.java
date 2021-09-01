package controlador;

import exceptions.OperacionInvalidaException;
import exceptions.OperandoInvalidoException;
import modelo.Calculadora;
/**
 * Clase Monitor(Capa de Negocio), intermediario entre la UI(Capa de Interfase de Usuario) y la Calculadora(Capa de Modelo)
 * @author 
 *
 */
public class Monitor {
	
	private Calculadora calculadora = new Calculadora();;
	
	public Monitor() {
		this.calculadora = new Calculadora();
	}
	/**
	 * 
	 * @param PrimerOperando
	 * @param SegundoOperando
	 * @param Operacion
	 * @throws OperacionInvalidaException: propaga la excepcion a la capa de interfaz de usuario
	 * @throws OperandoInvalidoException: propaga la excepcion a la capa de interfaz de usuario
	 */
	public void Calcular(int PrimerOperando,int SegundoOperando, String Operacion) throws OperacionInvalidaException, OperandoInvalidoException {
		calculadora.Calcular(PrimerOperando, SegundoOperando, Operacion);
	}
	/**
	 * Devuelve el resultado de la ultima operacion existosa.
	 * @return
	 */
	public int traerResultado() {
		return calculadora.traerResultado();
	}
		
}
