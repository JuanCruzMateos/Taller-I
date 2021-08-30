package controlador;

import exceptions.OperacionInvalidaException;
import exceptions.OperandoInvalidoException;
import modelo.Calculadora;
import vista.IVista;

public class Monitor {
	
	public static void Calcular(int PrimerOperando,int SegundoOperando, String Operacion) throws OperacionInvalidaException, OperandoInvalidoException {
		Calculadora.Calcular(PrimerOperando, SegundoOperando, Operacion);
	}
	public static int traerResultado() {
		return Calculadora.traerResultado();
	}
		
}
