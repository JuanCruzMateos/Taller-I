package org.controlador;

import org.excepciones.CapacidadMaximaExcedidaException;
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

    public void inicializarSurtidor() {
        double cantidad = this.vistaInit.inicializaSurtidor();
        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad positiva.");
        } else {
            try {
                this.surtidor.inicializarSurtidor(cantidad);
                this.vistaInit.visible(false);
                this.vistaMain = new Ventana();
                this.vistaMain.visible(true);
                this.vistaMain.setAcumuladoM1(this.surtidor.getAcumuladoManguera1());
                this.vistaMain.setAcumuladoM2(this.surtidor.getAcumuladoManguera2());
                this.vistaMain.setUltimaVentaM1(this.surtidor.getUltimaVentaMG1());
                this.vistaMain.setUltimaVentaM2(this.surtidor.getUltimaVentaMG2());
                this.vistaMain.setCombustible(this.surtidor.getExistenciaDeposito());
            } catch (CapacidadMaximaExcedidaException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        this.vistaInit.resetField();
    }

    public void cargarSurtidor(double carga) {
        if (carga <= 0) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad positiva.");
        } else {
            try {
                this.surtidor.cargarSurtidor(carga);
                JOptionPane.showMessageDialog(null, "Carga exitosa!");
                this.vistaMain.setCombustible(this.surtidor.getExistenciaDeposito());
            } catch (CapacidadMaximaExcedidaException e) {
                JOptionPane.showMessageDialog(null, "Capacidad excedida!");
            }
        }
        this.vistaMain.refresh();
    }

    public void desgargaManguera1() {
        this.surtidor.descargarManguera1();
    }

    public void desgargaManguera2() {
        this.surtidor.descargarManguera2();
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
    }

    public void detenerManguera1() {
        this.surtidor.detenerManguera1();
    }
}
