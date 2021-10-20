package sistema.gui;

import sistema.habitaciones.Habitacion;
import sistema.personas.medicos.IMedico;
import sistema.personas.pacientes.Paciente;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.util.Iterator;

/**
 * Ventana del modelo MVC.<br>
 */
public class Ventana extends JFrame implements ListSelectionListener, IVista {


    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

    @Override
    public Paciente getPacienteFacturacion() {
        return null;
    }

    @Override
    public IMedico getMedicoFacturacion() {
        return null;
    }

    @Override
    public int getCantidadConsultasFacturacion() {
        return 0;
    }

    @Override
    public Habitacion getHabitacionFacturacion() {
        return null;
    }

    @Override
    public int getCantidadDiasInternacionFacturacion() {
        return 0;
    }

    @Override
    public void actualizarListaPacientesFacturacion(Iterator<Paciente> iterator) {

    }

    @Override
    public void actualizarComboMedicosFacturacion(Iterator<IMedico> iterator) {

    }

    @Override
    public void actualizarComboHabitacionesFacturacion(Iterator<Habitacion> iterator) {

    }

    @Override
    public void MostrarFactura(String detalle) {

    }

    @Override
    public void addActionListener(ActionListener actionListener) {

    }

    @Override
    public void habilitarBotonesFactura(boolean habilitar) {

    }
}
