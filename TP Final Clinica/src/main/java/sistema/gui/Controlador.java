package sistema.gui;

import sistema.clinica.Clinica;
import sistema.persistencia.AccesoDatos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador implements ActionListener, WindowListener {
    private static Controlador instance = null;
    private IVista ventana;
    private Clinica clinica;

    private Controlador() {
    	
    }

    public static Controlador getInstance() {
        if (Controlador.instance == null)
            Controlador.instance = new Controlador();
        return Controlador.instance;
    }

    public void setVentana(IVista ventana) {
        this.ventana = ventana;
        this.ventana.addActionListener(this);
        this.ventana.addWindowListener(this);
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    public void init() {
        this.ventana.actualizarComboHabitacionesFacturacion(this.clinica.getHabitacionesIterator());
        this.ventana.actualizarComboMedicosFacturacion(this.clinica.getMedicosIterator());
        this.ventana.actualizarListaPacientesAtencion(this.clinica.getPacientesEnAtencionIterator());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getActionCommand().equals("ComenzarFactura")) {
    		//TODO
    		System.out.println("Comenzar Factura");
    	}
    	if(e.getActionCommand().equals("FinalizarFactura")) {
    		//TODO
    		System.out.println("Finalizar faactura");
    	}
    	if(e.getActionCommand().equals("AñadirConsulta")) {
    		//TODO
    		System.out.println("Añadir Consulta");
    	}
    	if(e.getActionCommand().equals("AñadirInternacion")) {
    		//TODO
    		System.out.println("Añadir Internacion");
    	}
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
