package sistema.util;

public enum Mensaje {
    TITULO("Modulo de Atencion - Historias Clinicas"),
    MEDICO("Medico"),
    NUMEROCONSULTAS("Numero Consultas"),
    ANADIRCONSULTA("Anadir consulta"),
    HABITACION("Habitacion"),
    DIASINTERNACION("Dias Internacion"),
    ANADIRINTERNACION("Anadir internacion"),
    PACIENTESATENCION("Pacientes en atencion"),
    ANADIRCONSULTA_OK("Consulta anadida exitosamente"),
    ANADIRINTERNACION_OK("Internacion agregada exitosamente"),
    ERROR_PACIENTE_NO_SELECCIONADO("Paciente no seleccionado"),
    ERROR_MEDICO_NO_SELECCIONADO("Medico no seleccionado"),
    ERROR_HABITACION_NO_SELECCIONADO("Medico no seleccionado");

    private String valor;

    Mensaje(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
