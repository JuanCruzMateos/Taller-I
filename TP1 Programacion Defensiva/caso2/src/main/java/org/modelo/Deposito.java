package org.modelo;

import org.excepciones.DescargaImposibleException;

public class Deposito {
    private static Deposito instance = null;
    private static final double CAPACIDAD_MAX = 2000.0;
    private double cantCombustible;

    private Deposito() {
        // Singleton
    }

    public synchronized static Deposito getInstance() {
        if (Deposito.instance == null)
            Deposito.instance = new Deposito();
        return Deposito.instance;
    }

    public void setCantCombustible(double cantCombustible) {
        this.cantCombustible = cantCombustible;
    }

    public synchronized void retirarCombustible() throws DescargaImposibleException {
        if (this.cantCombustible == 0)
            throw new DescargaImposibleException();
        else
            this.cantCombustible -= 1;
    }

    public synchronized void cargar(double cantCombustible) {
        this.cantCombustible += cantCombustible;
    }

    public synchronized double getCantCombustible() {
        return cantCombustible;
    }

    public boolean empty() {
        return this.cantCombustible == 0;
    }
}
