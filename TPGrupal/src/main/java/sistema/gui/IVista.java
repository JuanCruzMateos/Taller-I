package sistema.gui;

import sistema.personas.pacientes.Paciente;

public interface IVista {
    String getNombre();
    String getApellido();
    int getDni();
    int getTelefono();
    String getDomicilio();
    String getCiudad();

    String getEspecialidad();
    String getPosgrado();
    String getContratacion();

    String getRangoEtareo();

    Paciente getSelectedValue();
}
