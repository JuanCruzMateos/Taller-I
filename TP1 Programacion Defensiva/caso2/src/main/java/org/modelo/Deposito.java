package org.modelo;

import org.excepciones.CapacidadMaximaExcedidaException;
import org.excepciones.DescargaImposibleException;


/**
 * Clase que modela el deposito de combustible.<br>
 * Aplica patron Singleton:<br>
 * todas las mangueras comparten el mismo deposito del cual extraer el combustible.<br>
 *
 * <b>Invariante: </b><br>
 * - cantidad de combustible mayor o igual a cero.<br>
 */
public class Deposito {
    private static Deposito instance = null;
    private static final double CAPACIDAD_MAX = 2000.0;
    private double cantCombustible;

    /**
     * Constructor private correspondiente con patron Singleton.<br>
     */
    private Deposito() {
        this.verificarInvariante();
    }

    /**
     * Metodo getInstance() correspondiente al Patron Singleton.<br>
     *
     * @return unica instancia del Deposito.<br>
     */
    public synchronized static Deposito getInstance() {
        if (Deposito.instance == null)
            Deposito.instance = new Deposito();
        return Deposito.instance;
    }

    /**
     * Metodo que permite inicializar la cantidad de combustible del deposito.<br>
     * <b>pre: </b> cantCombustible mayor a cero.<br>
     * <b>post: </b> se setea la cantidad de combustible igual al numero especificado.<br>
     *
     * @param cantCombustible mayor a cero.<br>
     * @throws CapacidadMaximaExcedidaException si la capacidad del deposito es superada, no se realiza la carga.<br>
     */
    public void setCantCombustible(double cantCombustible) throws CapacidadMaximaExcedidaException {
        assert cantCombustible > 0 : "La cantidad de combustible para inicializar el surtidor debe ser positiva.";

        if (cantCombustible > Deposito.CAPACIDAD_MAX) {
            throw new CapacidadMaximaExcedidaException("El limite del deposito es de " + Deposito.CAPACIDAD_MAX + " litros.");
        } else {
            this.cantCombustible = cantCombustible;
            assert this.cantCombustible == cantCombustible : "Error en asignacion del combustible al deposito.";
            this.verificarInvariante();
        }
    }

    /**
     * Retirar combustible del deposito.<br>
     * <b>post:</b> la cantidad de combustible del deposito desciende en una unidad.<br>
     *
     * @throws DescargaImposibleException si el deposito se encuetra vacio, no hay combustible para retirar.<br>
     */
    public synchronized void retirarCombustible() throws DescargaImposibleException {
        if (this.cantCombustible == 0) {
            throw new DescargaImposibleException("El deposito se encuentra vacio. Debe cargarlo para extraer combustible");
        } else {
            double cantAnterior = this.cantCombustible;
            this.cantCombustible -= 1;
            assert cantAnterior - 1 == this.cantCombustible : "Error en la descarga de combustible";
            this.verificarInvariante();
        }
    }

    /**
     * Recargar el deposito.<br>
     * <b>pre: </b> cantCombustible mayor a cero.<br>
     * <b>post: </b> la cantida de combustible del deposito aumenta en la cantidad indicada.<br>
     *
     * @param cantCombustible mayor a cero.<br>
     * @throws CapacidadMaximaExcedidaException si la capacidad del deposito es superada con la cantidad que
     *                                          se quiere cargar, no se realiza la carga.<br>
     */
    public synchronized void cargar(double cantCombustible) throws CapacidadMaximaExcedidaException {
        assert cantCombustible > 0 : "La cantidad de combustible a cargar debe ser mayor a cero.";

        if (this.cantCombustible + cantCombustible > Deposito.CAPACIDAD_MAX) {
            throw new CapacidadMaximaExcedidaException("Capacidad excedida! Puede cargar como maximo " + (Deposito.CAPACIDAD_MAX - this.cantCombustible) + " listros");
        } else {
            double anterior = this.cantCombustible;
            this.cantCombustible += cantCombustible;
            assert anterior + cantCombustible == this.cantCombustible;
            this.verificarInvariante();
        }
    }

    /**
     * Getter.<br>
     *
     * @return cantidad de combustible en deposito.<br>
     */
    public synchronized double getCantCombustible() {
        return cantCombustible;
    }

    /**
     * Metodo auxiliar para verificar el cumplimiento de la invariante de clase.<br>
     */
    private void verificarInvariante() {
        assert this.cantCombustible >= 0 : "La cantidad de combustible en el deposito no puede ser negativa.";
    }
}
