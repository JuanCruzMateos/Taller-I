package org.modelo;


import org.excepciones.DescargaImposibleException;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class Manguera extends Observable implements Runnable {
    private final Surtidor surtidor;
    private double acumulado;
    private double ultimaVenta;
    private boolean enUso;

    public Manguera(Surtidor surtidor) {
        this.surtidor = surtidor;
    }

    @Override
    public void run() {
        boolean fin = false;

        this.enUso = true;
        this.ultimaVenta = 0;
        while (this.enUso && !fin) {
            try {
                this.surtidor.retirarCombustible();
                this.ultimaVenta += 1;
                this.acumulado += 1;
                this.setChanged();
                this.notifyObservers();
                Util.esperar(1);
            } catch (DescargaImposibleException e) {
//                e.printStackTrace();
                fin = true;
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
