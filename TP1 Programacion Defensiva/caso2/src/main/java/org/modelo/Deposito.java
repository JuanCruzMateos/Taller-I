package org.modelo;


import org.excepciones.DescargaImposibleException;

public class Deposito {
    private static double CAPACIDAD_MAX = 2000.0;
    private double cantCombustible;

    public Deposito(double cantCombustible) {
        this.cantCombustible = cantCombustible;
    }

    public synchronized void retirarCombustible() throws DescargaImposibleException {
        if (this.cantCombustible == 0)
            throw new DescargaImposibleException();
        else
            this.cantCombustible -= 1;
    }

    public void cargar(double cantCombustible) {
        this.cantCombustible += cantCombustible;
    }

    public synchronized double getCantCombustible() {
        return cantCombustible;
    }
}
