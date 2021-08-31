package org.controlador;

import org.modelo.Surtidor;
import org.vista.IVistaInit;
import org.vista.IVistaMain;
import org.vista.Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
    private static Controlador instance = null;
    private Surtidor surtidor;
    private IVistaInit vistaInit;
    private IVistaMain vistaMain;

    private Controlador() {
        // Singleton
    }

    public static Controlador getInstance() {
        if (Controlador.instance == null)
            Controlador.instance = new Controlador();
        return Controlador.instance;
    }

    public void setSurtidor(Surtidor surtidor) {
        this.surtidor = surtidor;
    }

    public void setVistaInit(IVistaInit vistaInit) {
        this.vistaInit = vistaInit;
    }

    public void inicializarSurtidor() {
        try {
            double cantida = Double.parseDouble(this.vistaInit.inicializaSurtidor());
            if (cantida >= 1) {
                this.surtidor = new Surtidor();
                this.surtidor.inicializarSurtidor(cantida);
                this.vistaMain = new Ventana();
                this.vistaMain.visible(true);
                this.vistaInit.visible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese una cantidad mayor a 0.");
            }
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad numerica.");
        }
    }

    public void cargarSurtidor(double carga) {

    }

    public void desgargaManguera1() {

    }

    public void desgargaManguera2() {

    }

    public double getExistenciaDeposito() {
        return this.surtidor.getExistenciaDeposito();
    }

    public double getAcumuladoManguera1() {
        return this.surtidor.getAcumuladoManguera1();
    }

    public double getAcumuladoManguera2() {
        return this.surtidor.getAcumuladoManguera2();
    }

    public double getUltimaVentaManguera1() {
        return this.surtidor.getUltimaVentaManguera1();
    }

    public double getUltimaVentaManguera2() {
        return this.surtidor.getUltimaVentaManguera2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Inicializar" -> this.inicializarSurtidor();
        }
    }
}
