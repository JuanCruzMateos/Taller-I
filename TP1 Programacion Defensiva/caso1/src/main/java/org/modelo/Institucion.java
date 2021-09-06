package org.modelo;

import java.util.HashMap;

public class Institucion {
	private HashMap<Integer, Alumno> alumnos = new HashMap<>();
	private static int nroAlumnos=0;
	
	
	public void agregaAlumno(String nombre, String apellido) {
		this.alumnos.put(++nroAlumnos, new Alumno(nombre, apellido));
	}
	
	/**
	 * Devuelve el alumno para informar su situacion o lanza un error si no lo encuentra
	 * PRE: El legajo es un numero positivo
	 * @param legajo
	 * @return
	 * @throws AlumnoNoExistenteException : si no existe un alumno con ese legajo se debe informar el error
	 */
	public Alumno pedirCertificado(int legajo) throws AlumnoNoExistenteException {
		Alumno respuesta;
		assert legajo>0 : "El lagajo debe ser un numero positivo";
		this.invariante();
		if(!this.alumnos.containsKey(legajo))
			throw new AlumnoNoExistenteException("No existe un alumno con el legajo " + legajo);
		return this.alumnos.get(legajo);
	}
	
	private void invariante() {
		assert this.alumnos !=null : "no se cumplen los invariantes de clase";
	}
}
