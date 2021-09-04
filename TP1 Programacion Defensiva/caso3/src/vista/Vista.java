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
	 * Devuelve el legajo de un alumno en formato string sin realizar ningun chequeo
	 * @return
	 */
	public String pedirLegajo() {
		this.invariante();
		String legajo;
		System.out.println("Ingrese el legajo");
		legajo = scanner.nextLine();
		this.invariante();
		return legajo;
	}
	
	/**
	 * Devuelve el nombre de una materia en formato string sin realizar ningun chequeo
	 * @return
	 */
	public String pedirMateria() {
		this.invariante();
		String materia;
		System.out.println("Ingrese la materia");
		materia = scanner.nextLine();
		this.invariante();
		return materia;
	}
	
	/**
	 * Muestra por consola el certificado creado
	 * PRE: el certificado es valido con todos los campos !=NULL
	 * @param c
	 */
	public void mostrarCertificado(Alumno a) {
		this.invariante();
		System.out.println("El alumno " + a.getNombre() + " " + a.getApellido() + " obtuvo las siguientes notas");
		Iterator<Materia> it = a.getIteratorMaterias();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
		this.invariante();
	}
	
	private void invariante() {
		assert this.scanner!=null : "No se cumple el invariante de clase";
	}

	public String menu() {
		this.invariante();
		
		String respuesta;
		
		this.informaMensaje("Ingrese la accion que desea realizar");
		this.informaMensaje("1. Para agregar un alumno");
		this.informaMensaje("2. Para realizar un certificado");
		this.informaMensaje("3. Cambiar el estado de un alumno a cursado");
		this.informaMensaje("4. Ingresar la nota de un alumno");
		this.informaMensaje("0. Cerrar");
		respuesta = this.scanner.nextLine();
		
		this.invariante();
		
		return respuesta;
	}
}
