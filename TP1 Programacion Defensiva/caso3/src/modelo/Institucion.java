package modelo;

import java.util.HashMap;

/**
 * Clase contedora de los alumnos
 * INV: alumnos!= null y nroAlumnos>=0
 * @author matias
 *
 */
public class Institucion {
	private HashMap<Integer, Alumno> alumnos = new HashMap<>();
	private static int nroAlumnos=0;
	
	/**
	 * El metodo agrega alumnos a la estructura 
	 * PRE: los parametros nombre y apellido son strings != null y no son vacios
	 * POST: los alumnos son creados y agregados a la estructura
	 * @param nombre
	 * @param apellido
	 */
	public void agregaAlumno(String nombre, String apellido) {		
		this.invariante();
		assert nombre!=null && !nombre.equalsIgnoreCase("") : "El nombre no puede ser ni null ni vacio";
		assert apellido!=null && !apellido.equalsIgnoreCase("") : "El apellido no puede ser ni null ni vacio";
		
		Alumno a = new Alumno(nombre, apellido);
		
		this.alumnos.put(++nroAlumnos, a);
		assert this.alumnos.containsValue(a) : "El alumno no fue ingresado correctamente";
		this.invariante();
	}
	
	/**
	 * Devuelve el alumno para informar su situacion o lanza un error si no lo encuentra
	 * PRE: El legajo es un numero positivo
	 * POST: Si encuentra un alumno con el legajo ingresado lo retorna, y sino lanza una excepcion
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
		respuesta = this.alumnos.get(legajo);
		respuesta.chequeaCond();
		return respuesta;
	}
	
	/**
	 * Setea como cursada una materia para el alumno pasado por legajo
	 * PRE : el legajo es un numero mayor que 0 y la cadena no es vacia ni nula
	 * POST : la materia es seteada como cursada o lanza una excepcion si no existe la materia o el alumno, o si ya habia sido seteada previamente
	 * @param legajo
	 * @param materia
	 * @throws AlumnoNoExistenteException
	 * @throws MateriaInexistenteException
	 * @throws MateriaYaCursadaException 
	 */
	public void CursaMateria(int legajo, String materia) throws AlumnoNoExistenteException, MateriaInexistenteException, MateriaYaCursadaException{
		assert legajo>0 : "El lagajo debe ser un numero positivo";
		assert materia!=null && !materia.equalsIgnoreCase("") : "La materia no puede ser ni null ni vacio";
		this.invariante();
		if(!this.alumnos.containsKey(legajo))
			throw new AlumnoNoExistenteException("No existe un alumno con el legajo " + legajo);
		this.alumnos.get(legajo).cursaMateria(materia);
	}
	
	private void invariante() {
		assert this.alumnos !=null : "Se perdio la referencia a los alumnos";
		assert Institucion.nroAlumnos>=0 : "El numero de alumnos no puede ser negativo";
	}
}
