package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * INV: apellido, nombre y materias !=null
 * @author matias
 *
 */
public class Alumno {
	private String nombre;
	private String apellido;
	private HashMap<String, Materia> materias = new HashMap<>();
	private String condicion;
	
	/**
	 * Crea los alumnos con referencia a cada materia
	 * POST: se crea una instancia de la clase
	 * @param nombre
	 * @param apellido
	 */
	public Alumno(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.materias.put("Historia", new Materia("Historia"));
		this.materias.put("Matematica", new Materia("Matematica"));
		this.materias.put("Literatura", new Materia("Literatura"));
		this.materias.put("Fisica", new Materia("Fisica"));
		this.invariante();
		
	}
	
	/**
	 * Setea una materia pasada por parametro como cursada
	 * PRE != la materia es distinta de null y vacia
	 * POST: setea como cursada una materia o lanza una excepcion que no existe la materia
	 * @param materia
	 * @throws MateriaInexistenteException 
	 */
	public void cursaMateria(String materia) throws MateriaInexistenteException {
		this.invariante();
		assert materia!=null && !materia.equalsIgnoreCase("") : "La materia debe ser distinto de null o vacio";		
		
		Materia m = this.materias.get(materia);
		if(m==null)
			throw new MateriaInexistenteException("No existe un nombre con esa materia");
		m.setEstado("Cursada");
		assert this.materias.get(materia).getEstado().equals("Cursada") : "Hubo error al setear el estado";
		this.invariante();
	}
	
	public void ApruebaMateria(int nro, int nota) {
		this.materias.get(nro).setEstado("Aprobada");
		this.materias.get(nro).setNota(nota);
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", materias=" + materias + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}
	
	public HashMap<String, Materia> getMaterias() {
		return materias;
	}

	public String getCondicion() {
		return condicion;
	}
	
	public Iterator<Materia> getIteratorMaterias() {
		ArrayList<Materia> aux = new ArrayList<Materia>();
		for (String i : this.materias.keySet()) {
			aux.add(this.materias.get(i));
		}
		return aux.iterator();
	}

	public void invariante() {
		assert this.apellido!=null : "El apellido no puede ser nulo";
		assert this.nombre!=null : "El nombre no puede ser nulo";
		assert this.materias!=null : "No posee referencia a las materias";
	}
	
}
