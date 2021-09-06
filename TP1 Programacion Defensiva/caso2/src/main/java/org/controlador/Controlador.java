package org.controlador;

import org.excepciones.DescargaImposibleException;
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
            if (cantida < 1) {
                JOptionPane.showMessageDialog(null, "Ingrese una cantidad mayor a 0.");
            } else if (cantida > 2000) {
                JOptionPane.showMessageDialog(null, "Ingrese una cantidad menor a 2000.");
            } else {
                this.surtidor = new Surtidor();
                this.surtidor.inicializarSurtidor(cantida);
                this.vistaMain = new Ventana(this.surtidor.getManguera1(), this.surtidor.getManguera2());
                this.vistaMain.setCombustible(cantida);
                this.vistaMain.visible(true);
                this.vistaInit.visible(false);
            }
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad numerica.");
        }
    }

    public void cargarSurtidor(double carga) {
        if (carga > 0) {
            this.surtidor.cargarSurtidor(carga);
            this.vistaMain.refreshTotal(this.surtidor.getExistenciaDeposito());
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar un numero mayor a cero.");
        }
    }

    public void desgargaManguera1() {
        try {
            this.surtidor.descargarManguera1();
        } catch (DescargaImposibleException e) {
            JOptionPane.showMessageDialog(null, "Combustible insuficiente");
        }
    }

    public void desgargaManguera2() {
        try {
            this.surtidor.descargarManguera2();
        } catch (DescargaImposibleException e) {
            JOptionPane.showMessageDialog(null, "Combustible insuficiente");
        }
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
        return this.surtidor.getUltimaVentaMG1();
    }

    public double getUltimaVentaManguera2() {
        return this.surtidor.getUltimaVentaMG2();
    }

    public void detenerManguera2() {
        this.surtidor.detenerManguera2();
        this.vistaMain.setAcumuladoM2(this.surtidor.getAcumuladoManguera2());
        this.vistaMain.setUltimaVentaM2(this.surtidor.getUltimaVentaMG2());
        this.vistaMain.setCombustible(this.surtidor.getExistenciaDeposito());
    }

    public void detenerManguera1() {
        this.surtidor.detenerManguera1();
        this.vistaMain.setAcumuladoM1(this.surtidor.getAcumuladoManguera1());
        this.vistaMain.setUltimaVentaM1(this.surtidor.getUltimaVentaMG1());
        this.vistaMain.setCombustible(this.surtidor.getExistenciaDeposito());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "inicializar" -> this.inicializarSurtidor();
            case "cargar" -> this.cargarSurtidor(this.vistaMain.cargarSurtidor());
            case "activarM1" -> this.desgargaManguera1();
            case "activarM2" -> this.desgargaManguera2();
            case "detenerM1" -> this.detenerManguera1();
            case "detenerM2" -> this.detenerManguera2();
        }
    }
}
