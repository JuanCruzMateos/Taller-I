package sistema.gui;

import sistema.clinica.Clinica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
    private static Controlador instance;
    private Clinica clinica;
    private IVista ventana;

    private Controlador() {
        // constructor vacio
    }

    public static Controlador getInstance() {
        if (Controlador.instance == null)
            Controlador.instance = new Controlador();
        return Controlador.instance;
    }

    public void setVentana(IVista ventana) {
        this.ventana = ventana;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
