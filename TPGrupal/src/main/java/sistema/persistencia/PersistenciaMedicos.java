package sistema.persistencia;

import sistema.clinica.Clinica;
import sistema.personas.medicos.IMedico;

import java.util.ArrayList;

public class PersistenciaMedicos {
    private static final String FILENAME = "medicos.xml";

    public static void persistir() {
        PersistenciaXML io = new PersistenciaXML();

        try {
            io.openOutput(FILENAME);
            io.write(Clinica.getInstance().getMedicos());
            io.closeOutput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<IMedico> despersistir() {
        PersistenciaXML io = new PersistenciaXML();
        ArrayList<IMedico> medicos = null;

        try {
            io.openInput(FILENAME);
            medicos = (ArrayList<IMedico>) io.read();
            io.closeInput();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicos;
    }
}
