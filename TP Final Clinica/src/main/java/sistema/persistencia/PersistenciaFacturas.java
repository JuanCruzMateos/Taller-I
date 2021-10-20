package sistema.persistencia;

import sistema.clinica.Clinica;
import sistema.facturacion.Factura;

import java.util.ArrayList;

public class PersistenciaFacturas {
    private static final String FILENAME = "facturas.xml";

    public static void persistir() {
        PersistenciaXML io = new PersistenciaXML();

        try {
            io.openOutput(FILENAME);
            io.write(Clinica.getInstance().getModuloEgreso().getFacturas());
            io.closeOutput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Factura> despersistir() {
        PersistenciaXML io = new PersistenciaXML();
        ArrayList<Factura> facturas = null;

        try {
            io.openInput(FILENAME);
            facturas = (ArrayList<Factura>) io.read();
            io.closeInput();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return facturas;
    }
}
