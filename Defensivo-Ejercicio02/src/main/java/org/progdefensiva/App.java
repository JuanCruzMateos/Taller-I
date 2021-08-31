package org.progdefensiva;

import org.controlador.Controlador;
import org.modelo.Surtidor;
import org.vista.InitVentana;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Controlador.getInstance().setSurtidor(new Surtidor());
        Controlador.getInstance().setVistaInit(new InitVentana());
    }
}
