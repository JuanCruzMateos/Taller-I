package vista;

import controlador.Monitor;
import exceptions.OperacionInvalidaException;
import exceptions.OperandoInvalidoException;

public class Vista implements IVista{

	public void Calcular(int PrimerOperando,int SegundoOperando,String Operacion) {
		try {
			Monitor.Calcular(PrimerOperando, SegundoOperando, Operacion);
		} catch (OperacionInvalidaException | OperandoInvalidoException e) {			
			this.mostrarEstado(e.getMessage());
		}
	}
	
	public String mostrarEstado(String Mensaje) {
		return Mensaje;
	}
	
	public int MostrarResultado() {
		return Monitor.traerResultado();
	}
	
	
	
}
