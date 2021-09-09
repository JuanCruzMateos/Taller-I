package org.surtidorcombustible;

import org.controlador.Controlador;
import org.modelo.Surtidor;
import org.vista.InitVentana;

/**
 * Entry point for app.<br>
 */
public class App {
    public static void main(String[] args) {
        Controlador.getInstance().setSurtidor(new Surtidor());
        Controlador.getInstance().setVistaInit(new InitVentana());
    }
}
