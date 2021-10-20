package sistema.personas.pacientes;

/**
 * Patron Factory: creacional.<br>
 * Responsable de crear un paciente asignandole un numero de historia clinica.<br>
 * <b>pre:</b> El rango etareo debe ser alguna de estas opciones "Joven", "Mayor" o "Nino".<br>
 * <b>Post:</b> Retorna un paciente con historia clinica o null si el rango etareo no corresponde a una opcion valida (no lanza excepciones).<br>
 */
public class PacienteFactory {
    private static int nroHistoriaClinica = 0;

    public static Paciente getPaciente(String nombre, String apellido, String direccion, String ciudad, long telefono, int dni, String rangoEtario) {
        Paciente respuesta = null;
        PacienteFactory.nroHistoriaClinica++;

        if (rangoEtario.equalsIgnoreCase("Joven"))
            respuesta = new PacienteJoven(nombre, apellido, direccion, ciudad, telefono, dni, nroHistoriaClinica);
        else if (rangoEtario.equalsIgnoreCase("Mayor"))
            respuesta = new PacienteMayor(nombre, apellido, direccion, ciudad, telefono, dni, nroHistoriaClinica);
        else if (rangoEtario.equalsIgnoreCase("Nino"))
            respuesta = new PacienteNino(nombre, apellido, direccion, ciudad, telefono, dni, nroHistoriaClinica);
        return respuesta;
    }

    public static int getNroHistoriaClinica() {
        return nroHistoriaClinica;
    }

    public static void setNroHistoriaClinica(int nroHistoriaClinica) {
        PacienteFactory.nroHistoriaClinica = nroHistoriaClinica;
    }
}