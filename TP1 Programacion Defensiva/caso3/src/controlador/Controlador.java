package controlador;

import modelo.AlumnoNoExistenteException;
import modelo.Institucion;
import vista.Vista;

/**
 * Controlador del programa
 * INV: vista y modelo!=null
 * @author matias
 *
 */
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
	 * POST: informa el certificado pedido o informa del error
	 */
	public void pedirCertificado() {
		this.invariante();
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
		this.invariante();
	}
	
	public void invariante() {
		assert this.vista!=null : "El controlador no posee referencia a la vista";
		assert this.modelo!=null : "El controlador no posee referencia al modelo";
	}
}
