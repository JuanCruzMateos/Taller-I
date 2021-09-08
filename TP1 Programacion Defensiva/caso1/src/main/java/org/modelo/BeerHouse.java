package org.modelo;

import org.excepciones.CapacidadExcedidaException;
import org.excepciones.MesaAbiertaException;
import org.excepciones.MesaInexistenteException;
import org.excepciones.MesaOcupadaException;

import java.util.ArrayList;

/**
 * Clase BeerHouse del modelo.<br>
 * <b>Invariante: </b><br>
 * - mesas distinto de null.<br>
 * - carta distinto de null.<br>
 * - capacidad distinto de 0.<br>
 */
public class BeerHouse {
    private int capacidad;
    private int mesasHabilitadas;
    private int mesasDisponibles;
    private ArrayList<Mesa> mesas = new ArrayList<>();
    private Carta carta = Carta.getInstance();

    /**
     * <b>pre: </b> la capacidad debe ser mayor a cero.<br>
     * <b>post: </b> se instancia la clase con capacidad indicada con las mesas y la carta vacia.<br>
     *
     * @param capacidad mayor a cero.<br>
     */
    public BeerHouse(int capacidad) {
        assert capacidad > 0 : "La capacidad del local debe ser mayor a cero.";
        this.capacidad = capacidad;
        this.invariante();
    }

    /**
     * Abre el local habilitando la cantidad de mesas pasadas por parametro.<br>
     * Instancia la cantidad de mesas requeridas.<br>
     * Inicializa la carta con valores por defecto.<br>
     *
     * <b>pre: </b> cantMesas es entero positivo.<br>
     * <b>post: </b>
     *
     * @param cantMesas entero positivo.<br>
     * @throws CapacidadExcedidaException si la cantidad de mesas a habilitar es mayor a la capacidad.<br>
     */
    public void abrirLocal(int cantMesas) throws CapacidadExcedidaException {
        assert cantMesas > 0 : "La cantidad de mesas a habilitar debe ser mayor a cero.";

        if (cantMesas > this.capacidad)
            throw new CapacidadExcedidaException("La cantidad indicada supera la capacidad del local.", this.capacidad);
        else {
            this.mesasHabilitadas = cantMesas;
            this.mesasDisponibles = cantMesas;
            for (int i = 0; i < cantMesas; i++) {
                this.mesas.add(new Mesa());
            }
            this.carta.init();
        }
        this.invariante();
    }

    /**
     * Retorna la instancia de la mesa que contiene en numero de mesa pasado por parametro
     * y marcandola como ocupada.<br>
     * <b>pre: </b> nroMesa mayor a cero.<br>
     * <b>post: </b> marca la mesa como ocupada y la retorna.<br>
     *
     * @param nroMesa mayor a cero.<br>
     * @return mesa con numero de mesa pasado por parametro.<br>
     * @throws MesaOcupadaException     si la mesa ya ha sido ocupada.<br>
     * @throws MesaInexistenteException si no existe mesa con el numero indicado.<br>
     */
    public Mesa ocuparMesa(int nroMesa) throws MesaOcupadaException, MesaInexistenteException {
        assert nroMesa > 0 : "El numero de mesa debe ser positivo.";

        int i = 0;
        while (i < this.mesas.size() && this.mesas.get(i).getNroMesa() != nroMesa) {
            i += 1;
        }
        if (i == this.mesas.size())
            throw new MesaInexistenteException("La mesa no existe.");
        else if (this.mesas.get(i).isOcupada())
            throw new MesaOcupadaException("Mesa " + nroMesa + " ya esta ocupada!");
        else {
            this.mesas.get(i).ocupar();
            this.invariante();
            return this.mesas.get(i);
        }
    }

    /**
     * Cierra la mesa indicada por parametro marcandola como desocupada y retorna el importe total de consumiciones.<br>
     * <b>pre: </b> nroMesa mayor a cero.<br>
     * <b>post: </b> marca la mesa como desocupada y la retorna el total consumido.<br>
     *
     * @param nroMesa mayor a cero.<br>
     * @return importe total de consumiciones realizadas por la mesa.<br>
     * @throws MesaAbiertaException     si la mesa indicada no esta ocupada.<br>
     * @throws MesaInexistenteException si el nro de mesa indicado no corresponde a una mesa real.<br>
     */
    public double cerrarMesa(int nroMesa) throws MesaAbiertaException, MesaInexistenteException {
        assert nroMesa > 0 : "El numero de mesa debe ser positivo.";

        int i = 0;
        while (i < this.mesas.size() && this.mesas.get(i).getNroMesa() != nroMesa) {
            i += 1;
        }
        if (i == this.mesas.size())
            throw new MesaInexistenteException("La mesa " + nroMesa + " no existe.");
        else if (!this.mesas.get(i).isOcupada())
            throw new MesaAbiertaException("Mesa " + nroMesa + " abierta: no se puede cerrar.");
        else {
            this.invariante();
            return this.mesas.get(i).cerrarMesa();
        }
    }

    /**
     * Metodo para verificar el cumplimiento de la invariante de la clase.<br>
     */
    private void invariante() {
        assert this.capacidad > 0 : "La capacidad debe ser mayor a cero.";
        assert this.mesas != null : "ArrayList de mesas no inicializado.";
        assert this.carta != null : "Carta no inicializada.";
    }
}
