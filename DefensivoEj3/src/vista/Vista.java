package vista;

import java.util.Iterator;
import java.util.Scanner;

import modelo.Alumno;
import modelo.Materia;

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
		this.invariante();
		assert mensaje!=null : "El mensaje a informar es nulo";
		System.out.println(mensaje);
		this.invariante();
	}
	
	/**
	 * Devuelve el legajo de el alumno a hacerle el certificado
	 * @return
	 */
	public String pedirCertificado() {
		this.invariante();
		String legajo;
		System.out.println("Ingrese el legajo");
		legajo = scanner.nextLine();
		this.invariante();
		return legajo;
	}
	
	/**
	 * Muestra por consola el certificado creado
	 * PRE: el certificado es valido con todos los campos !=NULL
	 * @param c
	 */
	public void mostrarCertificado(Alumno a) {
		this.invariante();
		System.out.println("El alumno " + a.getNombre() + " " + a.getApellido() + " obtuvo las siguientes notas");
		Iterator<Materia> it = a.getMaterias().iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
		this.invariante();
	}
	
	private void invariante() {
		assert this.scanner!=null : "No se cumple el invariante de clase";
	}
}
