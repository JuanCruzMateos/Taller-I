package org.modelo;

import org.excepciones.DescargaImposibleException;

public class Surtidor {
    private static final double CAPACIDAD = 2000.0;
    private double cantCombustible;
    private double acumuladoManguera1;
    private double acumuladoManguera2;
    private double ultimaVentaManguera1;
    private double ultimaVentaManguera2;
    private boolean manguera1Disponible;
    private boolean manguera2Disponible;

    /**
     * <b>Pre:</b> carga mayor o igual a 1.<br>
     * <b>Post:</b> cantCombustible igual a carga.<br>
     * @param carga mayor o igual a 1.
     */
    public void inicializarSurtidor(double carga) {
        assert carga >= 1: "Inicializacion del surtidor invalida, debe ser >= 1";
        this.cantCombustible = carga;
    }

    /**
     * <b>Pre:</b> carga mayor o igual a 0.<br>
     * <b>Post:</b> cantCombustible aumenta en una cantidad igual carga.<br>
     * @param carga mayor o igual a 0.
     */
    public void cargarSurtidor(double carga) {
        assert carga > 0: "Carga no pertmitida, debe ser mayor a cero";
        this.cantCombustible += carga;
    }

    public void descargaManguera1() throws DescargaImposibleException {
        if (this.cantCombustible == 0)
            throw new DescargaImposibleException();
        else {
            while (this.cantCombustible > 0 && this.manguera1Disponible) {
                this.cantCombustible -= 1;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void descargaManguera2() {

    }

    public void setManguera1Disponible(boolean manguera1Disponible) {
        this.manguera1Disponible = manguera1Disponible;
    }

    public void setManguera2Disponible(boolean manguera2Disponible) {
        this.manguera2Disponible = manguera2Disponible;
    }

    public boolean isManguera1Disponible() {
        return manguera1Disponible;
    }

    public boolean isManguera2Disponible() {
        return manguera2Disponible;
    }

    public double getExistenciaDeposito() {
        return cantCombustible;
    }

    public double getAcumuladoManguera1() {
        return acumuladoManguera1;
    }

    public double getAcumuladoManguera2() {
        return acumuladoManguera2;
    }

    public double getUltimaVentaManguera1() {
        return ultimaVentaManguera1;
    }

    public double getUltimaVentaManguera2() {
        return ultimaVentaManguera2;
    }
}
