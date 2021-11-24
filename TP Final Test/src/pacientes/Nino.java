package pacientes;

/**
 * @author Clase nino que se extiende la superclase Paciente e implementa la interfaz IPaciente
 */
public class Nino extends Paciente {

    public Nino(String dni, String nomAp, String telefono, String domicilio, String ciudad, int numHistoria) {
        super(dni, nomAp, telefono, domicilio, ciudad, numHistoria);
    }

    @Override
    public boolean beats(IPaciente o) {
        return o.beatsNino();
    }

    @Override
    public boolean beatsNino() {
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