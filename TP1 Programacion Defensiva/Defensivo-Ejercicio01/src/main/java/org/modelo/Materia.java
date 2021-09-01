package modelo;

/**
 * INV: nombre !=null y !=""
 * INV: estado !=null
 * @author matias
 *
 */
public class Materia {
	private String nombre;
	private int nota;
	private String estado;
	
	public Materia(String nombre, int nota, String estado) {
		super();
		this.nombre = nombre;
		this.nota = nota;
		this.estado = estado;
	}
	
	

	public Materia(String nombre) {
		super();
		this.nombre = nombre;
		this.estado = "A cursar";
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}



	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", nota=" + nota + ", estado=" + estado + "]";
	}
	
	
	
	
}
