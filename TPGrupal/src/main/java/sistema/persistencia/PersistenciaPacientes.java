package sistema.persistencia;

import sistema.clinica.Clinica;
import sistema.personas.pacientes.Paciente;

import java.util.ArrayList;

public class PersistenciaPacientes {
    private static final String FILENAME = "pacientes.xml";

    public static void persistir() {
        PersistenciaXML io = new PersistenciaXML();

        try {
            io.openOutput(FILENAME);
            io.write(new ArrayList<>(Clinica.getInstance().getModuloIngreso().getRegistroDePacientes().values()));
            io.closeOutput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Paciente> despersistir() {
        PersistenciaXML io = new PersistenciaXML();
        ArrayList<Paciente> pacientes = null;

        try {
            io.openInput(FILENAME);
            pacientes = (ArrayList<Paciente>) io.read();
            io.closeInput();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pacientes;
    }

}
