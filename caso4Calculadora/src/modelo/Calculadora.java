package modelo;

import exceptions.OperacionInvalidaException;
import exceptions.OperandoInvalidoException;

public class Calculadora {
	public static int ultimoResultado;
	
		public static void Calcular(int PrimerOperando,int SegundoOperando, String Operacion) throws OperacionInvalidaException,OperandoInvalidoException {
			verificaInvariante(PrimerOperando,SegundoOperando,Operacion);
			
			if (PrimerOperando<=0 || SegundoOperando<=0) {
				throw new OperandoInvalidoException();
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
				throw new OperacionInvalidaException();
		
			verificaInvariante(PrimerOperando,SegundoOperando,Operacion);
		}
	
		public static int traerResultado() {
			assert ultimoResultado>0:"El resultado debe ser mayor a 0";
			return ultimoResultado;
		}
		
		private static void verificaInvariante(int PrimerOperando,int SegundoOperando, String Operacion) {
			assert Operacion!=null:"La operacion debe ser distinta de null";
			
		}
	
}
