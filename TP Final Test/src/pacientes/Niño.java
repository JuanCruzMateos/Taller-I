package pacientes;

/**
 * @author Clase nino que se extiende la superclase Paciente e implementa la interfaz IPaciente
 */
public class Niño extends Paciente {

    public Niño(String dni, String nomAp, String telefono, String domicilio, String ciudad, int numHistoria) {
        super(dni, nomAp, telefono, domicilio, ciudad, numHistoria);
    }

    @Override
    public boolean beats(IPaciente o) {
        return o.beatsNiño();
    }

    @Override
    public boolean beatsNiño() {
        return true;
    }

    @Override
    public boolean beatsJoven() {
        return false;
    }

    @Override
    public boolean beatsMayor() {
        return true;
    }


}