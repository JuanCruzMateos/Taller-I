package vista;

import excepciones.*;
import habitaciones.IHabitacion;
import medicos.IMedico;
import pacientes.IPaciente;

import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.Iterator;

/**
 * @author usuario <br>
 * interfaz que contiene los metodos para realizar las acciones pedidas desde la interfaz de usuario
 */
public interface IVista {

    IPaciente getPacienteSeleccionado();

    IMedico getMedicoSeleccionado();

    IHabitacion getHabitacionSeleccionada();

    int getMatriculaNuevo() throws MatriculaInvalidaException, HistoriaInvalidaException; //o numero de historia clinica

    String getNomNuevo();

    String getDomNuevo();

    String getCiudadNuevo();

    String getTelNuevo();

    String getDNINuevo();

    String getRangoEtario() throws SeleccionIncorrectaException;

    String getEspecialidad() throws EspecialidadInvalidaException;

    String getContratacion() throws ContratacionInvalidaException;

    String getPosgrado() throws PosgradoInvalidoException;

    double getHonorario() throws HonorarioInvalidoException;

    void setActionListener(ActionListener listener);

    boolean actualizaAgregaListaPacientes(Iterator<IPaciente> iterator);

    void actualizaEliminaListaMedicos(Iterator<IMedico> iterator, IMedico med);

    void EliminaMedico(IMedico medico);

    void EliminaPaciente(IPaciente paciente);

    String getTipoAgregarSeleccionado();

    int getCantidadDias() throws CantDiasInvalidosException, NumberFormatException;

    boolean actualizaAgregaListaMedicos(Iterator<IMedico> iterator);

    void actualizaEliminaListaPacientes(Iterator<IPaciente> iterator, IPaciente pax);

    void actualizaListaHabitaciones(Iterator<IHabitacion> iterator);

    void soltarSeleccionHabitaciones();

    void soltarSeleccionPacientes();

    void soltarSeleccionMedicos();

    void soltarSeleccion();

    void pacientemedicoSeleccionado();

    void actualizaFactura(String factura);

    public GregorianCalendar getFecha1() throws FechaInvalidaException;

    public GregorianCalendar getFecha2() throws FechaInvalidaException;


}
