package org.controlador;

import org.modelo.Surtidor;
import org.vista.IVistaInit;
import org.vista.IVistaMain;

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

    public void setVistaMain(IVistaMain vistaMain) {
        this.vistaMain = vistaMain;
    }

    public void inicializarSurtidor(double carga) {

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

    }
}
