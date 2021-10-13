package sistema.atencion;

import sistema.personas.pacientes.Paciente;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que modela el modulo de atencion de la clinica.<br>
 */
public class ModuloAtencion {
    private ArrayList<Paciente> pacientesEnAtencion = new ArrayList<Paciente>();

    /**
     * Agrega al paciente a la lista de pacientes en atencion.<br>
     * <b>Pre: </b> paciente distinto de  null.<br>
     * <b>Post: </b> Si el paciente no se encontraba previamente en la lista de atencion se lo agrega, sino no tiene efecto.<br>
     *
     * @param paciente Paciente a agregar a la lista de atencion.<br>
     */
    public void atenderPaciente(Paciente paciente) {
        if (!this.pacientesEnAtencion.contains(paciente))
            this.pacientesEnAtencion.add(paciente);
    }

    /**
     * Devuelve el paciente de la lista de atencion cuyo dni es el sumistrado.<br>
     * <b>Pre: </b> dni mayor a 0.<br>
     * <b>Post: </b> Devuelve el paciente cuyo dni es el pasado por parametro o null si no se encuentra.<br>
     *
     * @param dni DNI del paciente; dni mayor a 0.<br>
     * @return referencia a un pacinte o null.<br>
     */
    public Paciente egresoPaciente(int dni) {
        Iterator<Paciente> it = this.pacientesEnAtencion.iterator();
        boolean esta = false;
        Paciente paciente = null;

        while (it.hasNext() && !esta) {
            paciente = it.next();
            if (paciente.getDni() == dni) {
                esta = true;
                this.pacientesEnAtencion.remove(paciente);
            }
        }
        return paciente;
    }

    /**
     * Devuelve la cantidad de pacientes que hay en atencion. <br>
     *
     * @return pacientesEnAtencion.size()
     */
    public int cantidadDePacientesEnAtencion() {
        return this.pacientesEnAtencion.size();
    }
}
