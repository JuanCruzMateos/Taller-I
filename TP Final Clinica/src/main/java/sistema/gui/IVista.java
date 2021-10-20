package sistema.gui;

import sistema.habitaciones.Habitacion;
import sistema.personas.medicos.IMedico;
import sistema.personas.pacientes.Paciente;

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.Iterator;

public interface IVista {
    //Facturacion
    Paciente getPacienteFacturacion();

    IMedico getMedicoFacturacion();

    int getCantidadConsultasFacturacion();

    Habitacion getHabitacionFacturacion();

    int getCantidadDiasInternacionFacturacion();

    void actualizarListaPacientesFacturacion(Iterator<Paciente> iterator);

    void actualizarComboMedicosFacturacion(Iterator<IMedico> iterator);

    void actualizarComboHabitacionesFacturacion(Iterator<Habitacion> iterator);

    void MostrarFactura(String detalle);

    void addActionListener(ActionListener actionListener);

    void addWindowListener(WindowListener windowListener);

    void habilitarBotonesFactura(boolean habilitar);
}
