package sistema.persistencia;

/**
 * Lanza Exception y no IOException/ClassNotFound para dejar abieta la puerta a BBDD.
 */
public interface IPersistencia<E> {
    void openInput(String fileName) throws Exception;

    void closeInput() throws Exception;

    void openOutput(String fileName) throws Exception;

    void closeOutput() throws Exception;

    void write(E obj) throws Exception;

    E read() throws Exception;
}
