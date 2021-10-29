package sistema.personas.pacientes;

/**
 * Patrón Factory: creacional.<br>
 * Responsable de crear un paciente asignandole un número de historia clínica.<br>
 * El rango etareo debe ser alguna de estas opciones "Joven", "Mayor" o "Nino".<br>
 */
public class PacienteFactory {
    private static int nroHistoriaClinica = 0;

    /**
     * Método encargado de la la instanciacion de un paciente.<br>
     * <b>Pre: </b> nombre, apellido, direccion, ciudad, teñetono, rangoEtario distinto de null y no vacio; dni entero positivo.<br>
     * <b>Post:</b> Retorna un paciente con historia clinica o null si el rango etareo no corresponde a una opcion valida (no lanza excepciones).<br>
     *
     * @param nombre      distinto de null y no vacio
     * @param apellido    distinto de null y no vacio
     * @param direccion   distinto de null y no vacio
     * @param ciudad      distinto de null y no vacio
     * @param telefono    distinto de null y no vacio
     * @param dni         entero positivo
     * @param rangoEtario distinto de null y no vacio
     * @return paciente con historia clinica o null si el rango etareo no corresponde a una opcion valida (no lanza excepciones).
     */
    public static Paciente getPaciente(String nombre, String apellido, String direccion, String ciudad, String telefono, int dni, String rangoEtario) {
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