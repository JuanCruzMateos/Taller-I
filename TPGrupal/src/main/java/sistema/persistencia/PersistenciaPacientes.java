package sistema.persistencia;

import sistema.clinica.Clinica;
import sistema.personas.pacientes.Paciente;

import java.util.ArrayList;

public class PersistenciaPacientes {

    public static void persistir() {
        PersistenciaXML io = new PersistenciaXML();

        try {
            io.openOutput("pacientes.xml");
            io.write(Clinica.getInstance().getModuloIngreso().getRegistroDePacientes());
            io.closeOutput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Paciente> despersistir() {
        PersistenciaXML io = new PersistenciaXML();
        ArrayList<Paciente> pacientes = null;

        try {
            io.openInput("pacientes.xml");
            pacientes = (ArrayList<Paciente>) io.read();
            io.closeInput();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pacientes;
    }
}
