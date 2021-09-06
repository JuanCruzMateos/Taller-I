package org.prueba;

import org.controlador.Controlador;
import org.vista.Vista;

public class Prueba {

	public static void main(String[] args) {
		Vista vista = new Vista();
		Controlador c = new Controlador(vista);
	}

}
