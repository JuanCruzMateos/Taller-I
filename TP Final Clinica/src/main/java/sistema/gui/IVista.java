package sistema.gui;

import sistema.habitaciones.Habitacion;
import sistema.personas.medicos.IMedico;
import sistema.personas.pacientes.Paciente;

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.Iterator;

public interface IVista {
	/**
	 * Retorna el paciente seleccionado
	 * 
	 * @return el paciente seleccionado o null en caso de no seleccionar ninguno
	 */
	Paciente getPacienteFacturacion();

	/**
	 * Retorna el medico seleccionado para la facturacion
	 * 
	 * @return el medico seleccionado o null en caso de no seleccionar ninguno
	 */
	IMedico getMedicoFacturacion();

	/**
	 * Retorna la cantidad de consultas que realizo un paciente
	 * 
	 * @return la cantidad de consultas realizadas
	 * @throws NumberFormatException si el numero de consultas en invalido
	 */
	int getCantidadConsultasFacturacion() throws NumberFormatException;

	Habitacion getHabitacionFacturacion();

	/**
	 * Retorna la cantidad de dias que estuvo internado un paciente
	 * @return la cantidad de dias que estuvo internado un paciente
	 * @throws NumberFormatException si el numero de dias en invalido
	 */
	int getCantidadDiasInternacionFacturacion() throws NumberFormatException;

	/**
	 * Actualiza la lista de pacientes en atencion
	 * @param iterator Iterator con los pacientes a mostrar
	 */
	void actualizarListaPacientesAtencion(Iterator<Paciente> iterator);

	/**
	 * Actualiza el combobox de Medicos en el panel de facturacion
	 * @param iterator Iterator con los medicos a mostrar
	 */
	void actualizarComboMedicosFacturacion(Iterator<IMedico> iterator);

	/**
	 * Actualiza el combobox de Habitaciones en el panel de facturacion
	 * @param iterator Iterator con las habitaciones a mostrar
	 */
	void actualizarComboHabitacionesFacturacion(Iterator<Habitacion> iterator);

	/**
	 * Muestra los datos de una factura en el panel Factura
	 * @param detalle Datos de la factura a ser mostrada
	 */
	void mostrarFactura(String detalle);

	void addActionListener(ActionListener actionListener);

	void addWindowListener(WindowListener windowListener);

	void habilitarBotonesFactura(boolean habilitar);
}
