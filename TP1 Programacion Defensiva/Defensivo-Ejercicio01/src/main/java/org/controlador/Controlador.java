package controlador;

import modelo.AlumnoNoExistenteException;
import modelo.Institucion;
import vista.Vista;

public class Controlador {
	private Vista vista;
	private Institucion modelo;
	
	public Controlador(Vista vista) {
		this.vista = vista;
		this.modelo = new Institucion();
		
		this.modelo.agregaAlumno("Juan Carlos", "Gomez");
		this.modelo.agregaAlumno("Maria", "Marta");
		this.pedirCertificado();
	}
	
	/**
	 * Recibe el string proveniente de la vista, lo intenta convertir a int y llama al modelo 
	 * para intentar hacer el certificado. Captura la excepcion del parse y las emitidas por el modelo
	 * PRE : 
	 * POST:
	 * @param legajo
	 */
	public void pedirCertificado() {
		String legajo = this.vista.pedirCertificado();
		
		try {
			int nroLegajo = Integer.parseInt(legajo);
			if(nroLegajo<=0)
				this.vista.informaMensaje("El legajo debe ser positivo");
			else
				try {
					this.vista.mostrarCertificado(this.modelo.pedirCertificado(nroLegajo));
				} catch (AlumnoNoExistenteException e) {
					this.vista.informaMensaje(e.getMessage());
				}
		} catch (NumberFormatException e) {
			this.vista.informaMensaje("Debe ingresar un numero");
		}
		
	}
}
