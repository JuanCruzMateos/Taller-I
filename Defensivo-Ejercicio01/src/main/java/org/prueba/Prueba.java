package prueba;

import controlador.Controlador;
import vista.Vista;

public class Prueba {

	public static void main(String[] args) {
		Vista vista = new Vista();
		Controlador c = new Controlador(vista);
	}

}
