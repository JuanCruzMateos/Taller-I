package org.cerveceria;

import org.controlador.Controlador;
import org.modelo.BeerHouse;
import org.vista.Ventana;

/**
 * Application.<br>
 */

public class App {
    public static void main(String[] args) {
        Controlador.getInstance().setVentana(new Ventana());
        Controlador.getInstance().setModelo(new BeerHouse(10));
    }
}
