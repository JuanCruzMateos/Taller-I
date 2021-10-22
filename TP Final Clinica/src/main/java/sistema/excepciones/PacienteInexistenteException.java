package sistema.excepciones;

public class PacienteInexistenteException extends Exception {
    private int dniInvalido;

    public PacienteInexistenteException(String message, int dniInvalido) {
        super(message);
        this.dniInvalido = dniInvalido;
    }

    public int getDni() {
        return dniInvalido;
    }
}
