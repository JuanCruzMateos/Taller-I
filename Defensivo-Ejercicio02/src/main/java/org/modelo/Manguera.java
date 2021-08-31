package org.modelo;

public class Manguera implements Runnable {
    private Surtidor surtidor;
    private int nro;

    public Manguera(Surtidor surtidor, int nro) {
        this.surtidor = surtidor;
        this.nro = nro;
    }

    @Override
    public void run() {

    }
}
