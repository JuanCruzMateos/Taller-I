package org.modelo;

import org.excepciones.CapacidadMaximaExcedidaException;
import org.excepciones.DescargaImposibleException;

/**
 * Clase que modela el suritidor.<br>
 * Contiene un deposito compartido por dos mangueras.<br>
 *
 * <b>Invariante: </b>
 * -
 */
public class Surtidor {
    private Deposito deposito;
    private Manguera manguera1;
    private Manguera manguera2;

    /**
     * Carga la cantidad inicial de combustible en deposito del surtidor.<br>
     * <b>pre: </b> cantidad mayor a cero.<br>
     * <b>post: </b> se inicializa el surtidor con una cantidad de combustible en el deposito igual al parametro
     * indicado y se inicializan las mangueras con sus atributos acumulado y ultima venta en cero.<br>
     *
     * @param cantidad mayor a cero.<br>
     * @throws CapacidadMaximaExcedidaException si la cantidad pasada por parametro es superior a la capacidad
     *                                          del deposito.<br>
     */
    public void inicializarSurtidor(double cantidad) throws CapacidadMaximaExcedidaException {
        assert cantidad > 0 : "La cantidad de combustible para inicializar el surtidor no puede ser negativa.";

        this.deposito = Deposito.getInstance();
        this.deposito.setCantCombustible(cantidad);
        this.manguera1 = new Manguera();
        this.manguera2 = new Manguera();
//        this.verificarInvariante();
    }

    /**
     * Carga del deposito del surtidor.<br>
     * <b>pre: </b> cantidad mayor a cero.<br>
     * <b>post: </b> la cantidad de combustible en el deposito aumenta en la cantidad pasada por parametro.<br>
     *
     * @param cantidad mayor a cero.<br>
     * @throws CapacidadMaximaExcedidaException si se desea cargar una cantidad que sumada a la cantidad actual del
     *                                          deposito excede su capacidad, no se realiza la carga.<br>
     */
    public void cargarSurtidor(double cantidad) throws CapacidadMaximaExcedidaException {
        assert cantidad > 0 : "La cantidad de combustible a cargar en el surtidor no puede ser negativa.";
        this.deposito.cargar(cantidad);
        // postcondicion "validada" en clase deposito -> delegacion.
    }

    /**
     * Inicia la descarga de la manguera 1.
     * <b>post: </b> la manguera comienza a retirar combustible hasta que se le indique detenerse o el deposito se vacie.<br>
     *
     * @throws DescargaImposibleException si la manguera ya esta descargando combustible o si el deposito se encuentra vacio.<br>
     */
    public void descargarManguera1() throws DescargaImposibleException {
        if (this.manguera1.isActiva())
            throw new DescargaImposibleException("La manguera 1 ya se encuentra activa!");
        else if (this.deposito.vacio())
            throw new DescargaImposibleException("Deposito Vacio!");
        else
            new Thread(this.manguera1).start();
    }

    /**
     * Inicia la descarga de la manguera 2.
     * <b>post: </b> la manguera comienza a retirar combustible hasta que se le indique detenerse o el deposito se vacie.<br>
     *
     * @throws DescargaImposibleException si la manguera ya esta descargando combustible o si el deposito se encuentra vacio.<br>
     */
    public void descargarManguera2() throws DescargaImposibleException {
        if (this.manguera2.isActiva())
            throw new DescargaImposibleException("La manguera 2 ya se encuentra activa!");
        else if (this.deposito.vacio())
            throw new DescargaImposibleException("Deposito Vacio!");
        else
            new Thread(this.manguera2).start();
    }

    /**
     * Da señal a la manguera de detenerse.<br>
     */
    public void detenerManguera1() {
        if (this.manguera1.isActiva())
            this.manguera1.desconectar();
    }

    /**
     * Da señal a la manguera de detenerse.<br>
     */
    public void detenerManguera2() {
        if (this.manguera2.isActiva())
            this.manguera2.desconectar();
    }

    /**
     * Getters.<br>
     * Delegacion en atributos.<br>
     *
     * @return double
     */
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
}
