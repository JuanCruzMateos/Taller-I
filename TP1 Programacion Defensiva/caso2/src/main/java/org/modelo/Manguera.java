package org.modelo;


import org.excepciones.DescargaImposibleException;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class Manguera extends Observable implements Runnable {
    private double acumulado;
    private double ultimaVenta;
    private boolean enUso;

    @Override
    public void run() {
        this.enUso = true;
        this.ultimaVenta = 0;
        while (this.enUso) {
            try {
                Surtidor.getInstance().retirarCombustible();
                this.ultimaVenta += 1;
                this.acumulado += 1;
                Util.esperar(1);
            } catch (DescargaImposibleException e) {
                e.printStackTrace();
            }
        }
    }

    public void desconectar() {
        this.enUso = false;
    }

    public double getAcumulado() {
        return acumulado;
    }

    public double getUltimaVenta() {
        return ultimaVenta;
    }
}
