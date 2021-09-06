package org.vista;

import org.modelo.Alumno;
import org.modelo.Materia;

import java.util.Iterator;
import java.util.Scanner;


/**
 * 
 * @author matias
 *
 */
public class Vista {
	
	private Scanner scanner = new Scanner(System.in);
	
	/**
	 * Informa un mensaje pasado por parametro
	 * PRE: mensaje!=NULL
	 * @param mensaje
	 */
	public void informaMensaje(String mensaje) {
		assert this.invariante() : "No se cumple el invariante de clase";
		assert mensaje!=null : "El mensaje a informar es nulo";
		System.out.println(mensaje);
		assert this.invariante() : "No se cumple el invariante de clase";
	}
	
	/**
	 * Devuelve el legajo de el alumno a hacerle el certificado
	 * @return
	 */
	public String pedirCertificado() {
		assert this.invariante() : "No se cumple el invariante de clase";
		String legajo;
		System.out.println("Ingrese el legajo: ");
		legajo = scanner.nextLine();
		assert this.invariante() : "No se cumple el invariante de clase";
		return legajo;
	}
	
	/**
	 * Muestra por consola el certificado creado
	 * PRE: el certificado es valido con todos los campos !=NULL
	 * @param c
	 */
	public void mostrarCertificado(Alumno a) {
		assert this.invariante() : "No se cumple el invariante de clase";
		System.out.println("El alumno " + a.getNombre() + " " + a.getApellido() + " obtuvo las siguientes notas");
		Iterator<Materia> it = a.getMaterias().iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
		assert this.invariante() : "No se cumple el invariante de clase";
	}
	
	private boolean invariante() {
		return this.scanner!=null;
	}
}
