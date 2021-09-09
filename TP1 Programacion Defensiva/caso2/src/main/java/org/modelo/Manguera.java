package org.modelo;

import org.excepciones.DescargaImposibleException;

import java.util.Observable;

/**
 * Clase que modela una manguera del surtidor.<br>
 *
 * <b>Invariante: </b><br>
 * - acumulado mayor o igual a cero y estrictamente creciente.<br>
 * - ultimaventa mayor o igual a cero.<br>
 */
@SuppressWarnings("deprecation")
public class Manguera extends Observable implements Runnable {
    private double acumulado;
    private double ultimaVenta;
    private boolean activa;

    /**
     * Concurrencia sobre el recurso compartido (Deposito).
     */
    @Override
    public void run() {
        this.activa = true;
        this.ultimaVenta = 0;
        while (this.activa) {
            try {
                Deposito.getInstance().retirarCombustible();
                this.acumulado += 1;
                this.ultimaVenta += 1;
                this.setChanged();
                this.notifyObservers();
                Util.esperar(1);
            } catch (DescargaImposibleException e) {
//                System.out.println(e.getMessage());
                this.activa = false;
            }
        }
        this.verificarInvariante();
    }

    /**
     * Getter.<br>
     *
     * @return acumulado.<br>
     */
    public double getAcumulado() {
        return acumulado;
    }

    /**
     * Getter.<br>
     *
     * @return ultima venta.<br>
     */
    public double getUltimaVenta() {
        return ultimaVenta;
    }

    /**
     * Manguera activa.<br>
     *
     * @return true si activa, de lo contrario false.<br>
     */
    public boolean isActiva() {
        return activa;
    }

    /**
     * Setea la manguera como inactiva.<br>
     */
    public void desconectar() {
        this.activa = false;
    }

    /**
     * Metodo auxiliar para verificar en invariante de la clase.<br>
     */
    private void verificarInvariante() {
        assert this.acumulado >= 0 : "El acumulado no puede ser negativo";
        assert this.ultimaVenta >= 0 : "La ultima venta no puede ser nagativa";
    }
}
