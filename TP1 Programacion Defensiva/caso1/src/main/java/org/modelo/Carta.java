package org.modelo;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * Modela la carta de productos disponiles.<br>
 * Aplica patron Singleton.<br>
 *
 * <b>Invariante: </b><br>
 * - productos distinto de null.<br>
 */
public class Carta {
    private static Carta instance = null;
    private final HashMap<String, Double> productos = new HashMap<>();

    private Carta() {
        // Singleton
    }

    public static Carta getInstance() {
        if (Carta.instance == null)
            Carta.instance = new Carta();
        return Carta.instance;
    }

    /**
     * Inicializa la carta con productos por defecto.<br>
     * El metodo debe ser invocado inmediatamente despues de instanciar la clase.<br>
     */
    public void init() {
        this.productos.put("CERVEZA", 100.0);
        this.productos.put("PIZZA", 120.0);
        this.productos.put("HAMBURGUESA", 200.0);
        this.productos.put("EMPANADAS", 150.0);
        this.productos.put("FERNET", 130.0);
    }

    /**
     * Verifica si el producto existe en la carta.<br>
     * <b>pre: </b> producto distinto de null;
     *
     * @param producto distinto de null;
     * @return true si el producto se encuentra en la carta, de lo contrario false.<br>
     */
    public boolean contiene(String producto) {
        assert producto != null : "El producto no puede ser null";
        return this.productos.containsKey(producto.toUpperCase());
    }

    public double getCosto(String producto) {
        return this.productos.get(producto.toUpperCase());
    }

    public int cantProductos() {
        return this.productos.size();
    }

    public void agregarProducto(String nombre, double costo) {
        this.productos.put(nombre.toUpperCase(), costo);
    }

    public void removerProducto(String producto) {
        this.productos.remove(producto.toUpperCase());
    }

    public ArrayList<String> getListadoProductos() {
        return new ArrayList<String>(this.productos.keySet());
    }

    private void invariante() {
        assert this.productos != null : "El ArrayList de productos no esta inicializado";
    }
}
