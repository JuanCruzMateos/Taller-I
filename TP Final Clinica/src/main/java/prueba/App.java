package prueba;

import sistema.clinica.Clinica;
import sistema.gui.Controlador;
import sistema.gui.Ventana;

import java.io.IOException;

/**
 * Clase de prueba del sistema.<br>
 * Simula la clinica en funcionamiento harcodeando medicos, pacientes, atenciones, internaciones, facturaciones y reportes.<br>
 */
public class App {
    public static void main(String[] args) throws IOException {

        Controlador controlador = Controlador.getInstance();
        controlador.setVentana(new Ventana());
        controlador.setClinica(Clinica.getInstance());
        controlador.init();
    }
}