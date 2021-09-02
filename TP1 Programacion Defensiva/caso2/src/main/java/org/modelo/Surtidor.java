package org.modelo;

import org.excepciones.DescargaImposibleException;

public class Surtidor {
    private static Surtidor instance = null;
    private Deposito deposito;
    private Manguera manguera1 = new Manguera();
    private Manguera manguera2 = new Manguera();

    private Surtidor() {

    }

    public static Surtidor getInstance() {
        if (Surtidor.instance == null)
            Surtidor.instance = new Surtidor();
        return Surtidor.instance;
    }

    public void inicializarSurtidor(double cantidad) {
        this.deposito = new Deposito(cantidad);
    }

    public void cargarSurtidor(double cantidad) {
        this.deposito.cargar(cantidad);
    }

    public void descargarManguera1() throws DescargaImposibleException {
        new Thread(this.manguera1).start();
    }

    public void descargarManguera2() throws DescargaImposibleException {
        new Thread(this.manguera2).start();
    }

    public void detenerManguera1() {
        this.manguera1.desconectar();
    }

    public void detenerManguera2() {
        this.manguera2.desconectar();
    }

    public void retirarCombustible() throws DescargaImposibleException {
        this.deposito.retirarCombustible();
    }

    public double getExistenciaDeposito() {
        return this.deposito.getCantCombustible();
    }

    public double getAcumuladoManguera1() {
        return this.manguera1.getAcumulado();
    }

    public double getAcumuladoManguera2() {
        return this.manguera2.getAcumulado();
    }

    public double getUltimaVentaMG1() {
        return this.manguera1.getUltimaVenta();
    }

    public double getUltimaVentaMG2() {
        return this.manguera2.getUltimaVenta();
    }

    public Manguera getManguera1() {
        return manguera1;
    }

    public Manguera getManguera2() {
        return manguera2;
    }
}