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
	
	public Alumno(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.materias.add(new Materia("Historia"));
		this.materias.add(new Materia("Matematica"));
		this.materias.add(new Materia("Literatura"));
		this.materias.add(new Materia("Fisica"));
	}
	
	public void cursaMateria(int nro) {
		this.materias.get(nro).setEstado("Cursada");
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

	public ArrayList<Materia> getMaterias() {
		return materias;
	}
	
	
	
}
