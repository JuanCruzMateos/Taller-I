package controlador;

import modelo.AlumnoNoExistenteException;
import modelo.Institucion;
import modelo.MateriaInexistenteException;
import vista.Vista;

/**
 * Controlador del programa INV: vista y modelo!=null
 * 
 * @author matias
 *
 */
public class Controlador {
	private Vista vista;
	private Institucion modelo;
	private boolean state;

	public Controlador(Vista vista) {
		this.vista = vista;
		this.modelo = new Institucion();
		this.state = true;
		this.modelo.agregaAlumno("Juan Carlos", "Gomez");
		this.modelo.agregaAlumno("Maria", "Marta");
		this.menu();
	}

	/**
	 * Metodo que controla y selecciona la accion a realizar
	 */
	private void menu() {
		this.invariante();
		int accion;
		String cadena;
		while (this.state) {
			cadena = this.vista.menu();
			try {
				accion = Integer.parseInt(cadena);
				if (accion < 0)
					this.vista.informaMensaje("Ingrese por favor un numero valido");
				else
					switch (accion) {
					case 1:
						this.agregarAlumno();
						break;
					case 2:
						this.pedirCertificado();
						break;
					case 3:
						this.cursaMateria();
						break;
					case 4:
						this.cursaMateria();
						break;
					case 0:
						this.state = false;
						break;
					default:
						this.vista.informaMensaje("Ingrese por favor un numero valido");
					}
			} catch (NumberFormatException e) {
				this.vista.informaMensaje("Ingrese por favor un numero valido");
			}
		}
		this.invariante();
	}

	/**
	 * Se pide un alumno y una materia y se cambia el estado de esa materia a "cursada" para ese alumno
	 */
	private void cursaMateria() {
		this.invariante();
		
		String legajo = this.vista.pedirLegajo();
		String materia = this.vista.pedirMateria();

		try {
			int nroLegajo = Integer.parseInt(legajo);
			if (nroLegajo <= 0)
				this.vista.informaMensaje("El legajo debe ser positivo");
			else if(materia== null || materia.equalsIgnoreCase(""))
				this.vista.informaMensaje("La materia ingresada no existe");
			else
				try {
					this.modelo.CursaMateria(nroLegajo, materia);
					this.vista.informaMensaje("El alumno ahora registra como cursante");
				} catch (AlumnoNoExistenteException e) {
					this.vista.informaMensaje(e.getMessage());
				} catch (MateriaInexistenteException e) {
					this.vista.informaMensaje(e.getMessage());;
				}
		} catch (NumberFormatException e) {
			this.vista.informaMensaje("Debe ingresar un numero");
		}
		this.invariante();
	}

	private void agregarAlumno() {
		// TODO Auto-generated method stub

	}

	/**
	 * Recibe el string proveniente de la vista, lo intenta convertir a int y llama
	 * al modelo para intentar hacer el certificado. Captura la excepcion del parse
	 * y las emitidas por el modelo PRE : POST: informa el certificado pedido o
	 * informa del error
	 */
	public void pedirCertificado() {
		this.invariante();
		String legajo = this.vista.pedirLegajo();

		try {
			int nroLegajo = Integer.parseInt(legajo);
			if (nroLegajo <= 0)
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
		assert this.vista != null : "El controlador no posee referencia a la vista";
		assert this.modelo != null : "El controlador no posee referencia al modelo";
	}
}
