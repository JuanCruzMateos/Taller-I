package org.surtidorcombustible;

import org.controlador.Controlador;
import org.modelo.Surtidor;
import org.vista.InitVentana;


public class App {
    public static void main(String[] args) {
        Controlador.getInstance().setSurtidor(Surtidor.getInstance());
        Controlador.getInstance().setVistaInit(new InitVentana());
    }
}
