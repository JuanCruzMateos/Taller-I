package org.controlador;

import org.excepciones.CapacidadMaximaExcedidaException;
import org.excepciones.DescargaImposibleException;
import org.modelo.Deposito;
import org.modelo.Surtidor;
import org.vista.IVistaInit;
import org.vista.IVistaMain;
import org.vista.Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Controlador del modelo.<br>
 * Aplica patron Singleton.<br>
 */
@SuppressWarnings("deprecation")
public class Controlador implements ActionListener, Observer {
    private static Controlador instance = null;
    private Surtidor surtidor;
    private IVistaInit vistaInit;
    private IVistaMain vistaMain;

    private Controlador() {
        // Singleton
    }

    public static Controlador getInstance() {
        if (Controlador.instance == null) {
            Controlador.instance = new Controlador();
            Deposito.getInstance().addObserver(Controlador.instance);
        }
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

    /**
     * Inicializa el surtidor si es posible validando los datos recibidos de la ventana.<br>
     * <b>post: </b> se inicializa el surtidor con la cantidad requerida y validada.<br>
     */
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

    /**
     * Carga el surtidos con la cantidad recivida de la ventana si es posible luego de validarla.<br>
     * <b>post: </b> aumenta la cantidad del deposito de combustible una cantidad igual a la pasada por parametro.<br>
     *
     * @param carga recibida de la ventana.<br>
     */
    public void cargarSurtidor(double carga) {
        if (carga <= 0) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad positiva.");
        } else {
            try {
                this.surtidor.cargarSurtidor(carga);
                JOptionPane.showMessageDialog(null, "Carga exitosa!");
                this.vistaMain.setCombustible(this.surtidor.getExistenciaDeposito());
            } catch (CapacidadMaximaExcedidaException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        this.vistaMain.refresh();
    }

    /**
     * Informa al modelo el inicio de la descarga de la manguera 1, si es posible.<br>
     */
    public void desgargaManguera1() {
        try {
            this.surtidor.descargarManguera1();
        } catch (DescargaImposibleException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * Informa al modelo el inicio de la descarga de la manguera 2, si es posible.<br>
     */
    public void desgargaManguera2() {
        try {
            this.surtidor.descargarManguera2();
        } catch (DescargaImposibleException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * getter
     *
     * @return cantidad de combustible en surtidor.<br>
     */
    public double getExistenciaDeposito() {
        return this.surtidor.getExistenciaDeposito();
    }

    /**
     * getter
     *
     * @return acumulado de manguera 1.<br>
     */
    public double getAcumuladoManguera1() {
        return this.surtidor.getAcumuladoManguera1();
    }

    /**
     * getter
     *
     * @return acumulado de manguera 2.<br>
     */
    public double getAcumuladoManguera2() {
        return this.surtidor.getAcumuladoManguera2();
    }

    /**
     * getter
     *
     * @return ultima venta de manguera 1.<br>
     */
    public double getUltimaVentaManguera1() {
        return this.surtidor.getUltimaVentaMG1();
    }

    /**
     * getter
     *
     * @return ultima venta de manguera 2.<br>
     */
    public double getUltimaVentaManguera2() {
        return this.surtidor.getUltimaVentaMG2();
    }

    /**
     * Informa al modelo que debe detener la descarga de la manguera 1.<br>
     */
    public void detenerManguera1() {
        this.surtidor.detenerManguera1();
        this.vistaMain.setAcumuladoM1(this.surtidor.getAcumuladoManguera1());
        this.vistaMain.setUltimaVentaM1(this.surtidor.getUltimaVentaMG1());
        this.vistaMain.setCombustible(this.surtidor.getExistenciaDeposito());
    }

    /**
     * Informa al modelo que debe detener la descarga de la manguera 2.<br>
     */
    public void detenerManguera2() {
        this.surtidor.detenerManguera2();
        this.vistaMain.setAcumuladoM2(this.surtidor.getAcumuladoManguera2());
        this.vistaMain.setUltimaVentaM2(this.surtidor.getUltimaVentaMG2());
        this.vistaMain.setCombustible(this.surtidor.getExistenciaDeposito());
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o != Deposito.getInstance()) {
            throw new IllegalArgumentException();
        } else {
            JOptionPane.showMessageDialog(null, arg);
            this.vistaMain.setAcumuladoM1(this.surtidor.getAcumuladoManguera1());
            this.vistaMain.setAcumuladoM2(this.surtidor.getAcumuladoManguera2());
            this.vistaMain.setUltimaVentaM1(this.surtidor.getUltimaVentaMG1());
            this.vistaMain.setUltimaVentaM2(this.surtidor.getUltimaVentaMG2());
            this.vistaMain.setCombustible(this.surtidor.getExistenciaDeposito());
        }
    }
}
