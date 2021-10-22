package sistema.gui;

import sistema.ambulancia.Ambulancia;
import sistema.clinica.Clinica;
import sistema.excepciones.AsociadoExistenteException;
import sistema.excepciones.AsociadoInexistenteException;
import sistema.excepciones.SimulacionImposibleExeption;
import sistema.facturacion.ConsultaMedica;
import sistema.facturacion.Internacion;
import sistema.habitaciones.Habitacion;
import sistema.habitaciones.HabitacionCompartida;
import sistema.habitaciones.HabitacionPrivada;
import sistema.habitaciones.HabitacionTerapiaIntensiva;
import sistema.persistencia.AccesoDatos;
import sistema.personas.Operario;
import sistema.simulacion.Simulacion;
import sistema.temporizador.ObservadorAmbulanciaVentana;
import sistema.temporizador.Temporizador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;


/**
 * Controlador segun modelo MVC.<br>
 * Dirige el flujo de control de la aplicaion, administrando la comunicacion entre la ventana y el modelo.<br>
 */
public class ControladorAnterior implements ActionListener, WindowListener {

    private static ControladorAnterior instance;
    //FACTURACION
    ArrayList<ConsultaMedica> consultasMedicas = new ArrayList<>();
    ArrayList<Internacion> internaciones = new ArrayList<>();
    private Clinica clinica;
    private IVistaAnterior ventana;
    //SIMULACION
    private int CantidadTotalSolicitudes;
    private Simulacion simulacion;

    private ControladorAnterior() {
        // constructor vacio
    }

    public static ControladorAnterior getInstance() {
        if (ControladorAnterior.instance == null)
            ControladorAnterior.instance = new ControladorAnterior();
        return ControladorAnterior.instance;
    }

    public IVistaAnterior getVista() {
        return ventana;
    }

    public void setVista(IVistaAnterior vista) {
        this.ventana = vista;
        this.ventana.addActionListener(this);
        this.ventana.addWindowListener(this);
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    public void Inicializar() {

        //FACTURACION
        this.ventana.actualizarListaPacientesFacturacion(this.clinica.getPacientesEnAtencion().iterator());
        this.ventana.actualizarComboMedicosFacturacion(this.clinica.getListaMedicos().iterator());
        this.ventana.actualizarListaAsociados(this.clinica.getListaAsociados().iterator());
        ArrayList<Habitacion> Lista = new ArrayList<Habitacion>();
        Lista.add(HabitacionPrivada.getInstance());
        Lista.add(HabitacionCompartida.getInstance());
        Lista.add(HabitacionTerapiaIntensiva.getInstance());
        this.ventana.actualizarComboHabitacionesFacturacion(Lista.iterator());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            //FACTURACION:
            case "ComenzarFactura":
                ComenzarFactura();
                break;
            case "AñadirConsulta":
                AñadirConsulta();
                break;
            case "AñadirInternacion":
                AñadirInternacion();
                break;
            case "FinalizarFactura":
                FinalizarFactura();
                break;

            //ALTA/BAJA:
            case "AgregarAsociado":
                AgregarAsociado();
                break;
            case "EliminarAsociado":
                EliminarAsociado();
                break;

            //SIMULACION:
            case "AñadirSolicitud":
                AñadirSolicitud();
                break;
            case "NuevaSimulacion":
                NuevaSimulacion();
                break;
            case "ComenzarSimulacion":
                ComenzarSimulacion();
                break;
            default:
                System.out.println("No se encontro action comand");
        }
    }

    //FACTURACION:

    private void ComenzarFactura() {
        //System.out.println("ComenzarFactura");
        this.consultasMedicas = new ArrayList<>();
        this.internaciones = new ArrayList<>();
        this.ventana.MostrarFactura("");
        this.ventana.habilitarBotonesFactura(true);
    }

    private void AñadirConsulta() {
        //System.out.println("AñadirConsulta");
        consultasMedicas.add(new ConsultaMedica(this.ventana.getMedicoFacturacion(), this.ventana.getCantidadConsultasFacturacion()));
    }

    private void AñadirInternacion() {
        //System.out.println("AñadirInternacion");
        internaciones.add(new Internacion(this.ventana.getHabitacionFacturacion(), this.ventana.getCantidadDiasInternacionFacturacion()));
    }

    private void FinalizarFactura() {
        //System.out.println("FinalizarFactura");
        this.clinica.facturar(this.ventana.getPacienteFacturacion(), new GregorianCalendar(), consultasMedicas, internaciones);
        this.ventana.MostrarFactura(this.clinica.getDetalleUltimaFactura());
        this.ventana.habilitarBotonesFactura(false);
    }

    //ALTA/BAJA:
    private void AgregarAsociado() {
        //System.out.println("AgregarAsociado");
        try {
            this.clinica.AgregarAsociado(this.ventana.getNombreAsociado(), this.ventana.getApellidoAsociado(), this.ventana.getDireccionAsociado(), this.ventana.getTelefonoAsociado(), this.ventana.getDNIAsociado());
        } catch (AsociadoExistenteException exception) {
            JOptionPane.showMessageDialog(null, "Asociado ya existente");
        }
        this.ventana.actualizarListaAsociados(this.clinica.getListaAsociados().iterator());
        AccesoDatos.persistirClinica();
    }

    private void EliminarAsociado() {
        //System.out.println("Eliminar Asociado");
//        Asociado AsociadoAElim = this.clinica.DevolverAsociado(this.ventana.getDNIAsociadoAEliminar());
//        if (AsociadoAElim != null) {
        try {
            this.clinica.EliminarAsociado(this.ventana.getDNIAsociadoAEliminar());
        } catch (AsociadoInexistenteException e) {
            JOptionPane.showMessageDialog(null, "Asociado no existe");
        }
//        }
        this.ventana.actualizarListaAsociados(this.clinica.getListaAsociados().iterator());
        AccesoDatos.persistirClinica();
    }

    private void AñadirSolicitud() {
        //System.out.println("AñadirSolicitud");
        this.simulacion.agregarAsociado(this.ventana.getAsociadoSimulacion(), this.ventana.getCantidadSolicitudesAsociado());
    }

    private void NuevaSimulacion() {
        this.CantidadTotalSolicitudes = 0;
        Operario operario = new Operario();
        Temporizador temp = new Temporizador();
        this.simulacion = new Simulacion(operario, temp);
    }

    private void ComenzarSimulacion() {
        //System.out.println("ComenzarSimulacion");
        this.CantidadTotalSolicitudes += this.ventana.getCantidadSolicitudesOperario();
        this.simulacion.cantidadDeConultasOperario(this.ventana.getCantidadSolicitudesOperario());
        Ambulancia.getInstance().setCantidadTotalSolicitudes(CantidadTotalSolicitudes);
        try {
            this.simulacion.iniciarSimulacion(new ObservadorAmbulanciaVentana(Ambulancia.getInstance(), this.ventana.getTextPane()));
        } catch (SimulacionImposibleExeption simulacionImposibleExeption) {
            JOptionPane.showMessageDialog(null, "Debe agregar al menos un asociado a la simulacion");
        }
        /*this.simulacion.iniciarSimulacion(new ObservadorAmbulanciaConsola(Ambulancia.getInstance()));   */
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowClosing(WindowEvent e) {
        AccesoDatos.persistirClinica();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        AccesoDatos.persistirClinica();
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }


}
