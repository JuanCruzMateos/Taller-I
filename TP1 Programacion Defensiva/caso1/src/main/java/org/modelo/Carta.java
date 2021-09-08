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
     * Metodo auxiliar para inicializar la carta con productos por defecto.<br>
     * <b>post: </b> inicializa la carta con productos por defecto.<br>
     */
    public void init() {
        this.productos.put("CERVEZA", 100.0);
        this.productos.put("PIZZA", 120.0);
        this.productos.put("HAMBURGUESA", 200.0);
        this.productos.put("EMPANADAS", 150.0);
        this.productos.put("FERNET", 130.0);
        this.invariante();
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
        this.invariante();
        return this.productos.containsKey(producto.toUpperCase());
    }

    /**
     * Devuelve el costo del producto pasado por parametro.<br>
     * <b>pre: </b> producto distinto de null y debe existir en la carta.br
     *
     * @param producto distinto de null.<br>
     * @return costo del producto.<br>
     */
    public double getCosto(String producto) {
        assert producto != null : "El producto no puede ser null.";
        assert this.productos.containsKey(producto.toUpperCase()) : "El producto debe existir en la carta.";
        this.invariante();
        return this.productos.get(producto.toUpperCase());
    }

    /**
     * Devuelve la cantida de productos presentes en la carta.<br>
     *
     * @return cantidad de productos en la carta.<br>
     */
    public int cantProductos() {
        this.invariante();
        return this.productos.size();
    }

    /**
     * Agrega un producto nuevo a la carta.<br>
     * <b>pre: </b> el nombre es distinto de null y distinto de una cadena vacia; y costo es mayor a cero.<br>
     * <b>post: </b> se agrega un nuevo producto a la carta.<br>
     *
     * @param nombre distinto de null y distinto de cadena vacia.<br>
     * @param costo  mayor a cero.<br>
     */
    public void agregarProducto(String nombre, double costo) {
        assert nombre != null : "El nombre no puede ser null.";
        assert !nombre.equals("") : "El nombre no puede ser una cadena vacia.";
        assert costo > 0 : "El costo debe ser mayor a cero.";

        this.productos.put(nombre.toUpperCase(), costo);
        this.invariante();
    }

    /**
     * Elimina un producto de la carta.<br>
     * <b>pre: </b> el producto debe existir en la carta y debe ser distinto de null.<br>
     * <b>post: </b> se elimina el producto de la carta contando con un item menos en su lista.<br>
     *
     * @param producto distinto de null y debe existir en la carta.<br>
     */
    public void removerProducto(String producto) {
        assert producto != null : "El producto no puede ser null.";
        assert this.productos.containsKey(producto.toUpperCase()) : "El producto debe existir en la carta.";

        int oldCantidad = this.productos.size();
        this.productos.remove(producto.toUpperCase());
        assert oldCantidad == this.productos.size() + 1 : "Error en la eliminacion del producto.";
        this.invariante();
    }

    /**
     * Genera y devuelve una lista con los nombres de los productos presentes en la carta.<br>
     *
     * @return lista de nombres de productos presentes en la carta.<br>
     */
    public ArrayList<String> getListadoProductos() {
        return new ArrayList<>(this.productos.keySet());
    }

    /**
     * Metodo auxiliar para verificar el cumplimiento de la invariante de la clase.<br>
     */
    private void invariante() {
        assert this.productos != null : "El ArrayList de productos no esta inicializado";
    }
}
