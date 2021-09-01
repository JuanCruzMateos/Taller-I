package modelo;

import exceptions.OperacionInvalidaException;
import exceptions.OperandoInvalidoException;

	/**
	 * Clase Calculadora: dados dos numeros enteros mayores a 0 , realiza la operacion que se le indica
	 * 
	 * 
	 * @author 
	 *
	 */

public class Calculadora {
	
	private int ultimoResultado;
	
		public Calculadora() {
			
		}
	/**
	 * Realiza la suma, resta, division o multiplicacion y la guarda en ultimoResultado.
	 * Lanza dos tipos de excepciones segun corresponda.
	 * @param PrimerOperando: primer operando de la operacion
	 * @param SegundoOperando: segundo operando de la operacion
	 * @param Operacion: operacion a realizar
	 * @throws OperacionInvalidaException: se lanza si la operacion no coincide con +,-,*,/.
	 * @throws OperandoInvalidoException: se lanza si si ingresa un numero menor o igual a 0
	 */
		public void Calcular(int PrimerOperando,int SegundoOperando, String Operacion) throws OperacionInvalidaException,OperandoInvalidoException {
			verificaInvariante(PrimerOperando,SegundoOperando,Operacion);
			
			if (PrimerOperando<=0 || SegundoOperando<=0) {
				throw new OperandoInvalidoException("Los operandos deben ser mayores a 0. ");
			}
			if (Operacion.equals("+"))
				ultimoResultado= PrimerOperando+SegundoOperando;
			else if (Operacion.equals("-"))
				ultimoResultado= PrimerOperando-SegundoOperando;
			else if (Operacion.equals("*"))
				ultimoResultado= PrimerOperando*SegundoOperando;
			else if (Operacion.equals("/"))
				ultimoResultado= PrimerOperando/SegundoOperando;
			else
				throw new OperacionInvalidaException("La operacion debe ser suma, resta, divisón o multiplicación.");
		
			verificaInvariante(PrimerOperando,SegundoOperando,Operacion);
		}
	/**
	 * Retorna el resultado de la ultima operacion exitosa
	 * @return 
	 * 
	 */
		public int traerResultado() {
			assert ultimoResultado>0:"El resultado debe ser mayor a 0";
			return ultimoResultado;
		}
		/**
		 * Verifica la invariante de clase: operacion no es null.
		 * @param PrimerOperando
		 * @param SegundoOperando
		 * @param Operacion
		 */
		private void verificaInvariante(int PrimerOperando,int SegundoOperando, String Operacion) {
			assert Operacion!=null:"La operacion debe ser distinta de null. ";
			//assert PrimerOperando!=null:"El primer operando debe ser distinto de null. ";
			//assert SegundoOperando!=null:"El segundo operando debe ser disitno de null. ";
		}
	
}
