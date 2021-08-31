package modelo;

import java.util.ArrayList;

/**
 * INV: apellido, nombre y materias !=null
 * @author matias
 *
 */
public class Alumno {
	private String nombre;
	private String apellido;
	private ArrayList<Materia> materias = new ArrayList<>();
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
		this.materias.add(new Materia("Historia"));
		this.materias.add(new Materia("Matematica"));
		this.materias.add(new Materia("Literatura"));
		this.materias.add(new Materia("Fisica"));
		this.invariante();
		
	}
	
//	public void cursaMateria(int nro) {
//		this.materias.get(nro).setEstado("Cursada");
//	}
//	
//	public void ApruebaMateria(int nro, int nota) {
//		this.materias.get(nro).setEstado("Aprobada");
//		this.materias.get(nro).setNota(nota);
//	}

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

	public ArrayList<Materia> getMaterias() {
		return materias;
	}
	
	public void invariante() {
		assert this.apellido!=null : "El apellido no puede ser nulo";
		assert this.nombre!=null : "El nombre no puede ser nulo";
		assert this.materias!=null : "No posee referencia a las materias";
	}
	
}
