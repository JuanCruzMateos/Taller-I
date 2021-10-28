package sistema.atencion;

import sistema.facturacion.ConsultaMedica;
import sistema.facturacion.Internacion;
import sistema.personas.pacientes.Paciente;

import java.util.*;

/**
 * Clase que modela el modulo de atencion de la clinica.<br>
 */
public class ModuloAtencion {
    private HashMap<Paciente, HistoriaClinica> historiasClinicas = new HashMap<>();
    private ArrayList<Paciente> pacientesEnAtencion = new ArrayList<>();

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
     * <b>Post: </b> Devuelve el paciente cuyo dni es el pasado por parametro, eliminandolo de pacientes en atencion, o null si no se encuentra.<br>
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

    public ArrayList<Paciente> getPacientesEnAtencion() {
        return pacientesEnAtencion;
    }

    public void setPacientesEnAtencion(ArrayList<Paciente> pacientesEnAtencion) {
        this.pacientesEnAtencion = pacientesEnAtencion;
    }

    public Iterator<Paciente> getPacientesEnAtencionIterator() {
        return this.pacientesEnAtencion.iterator();
    }

    public HashMap<Paciente, HistoriaClinica> getHistoriasClinicas() {
        return historiasClinicas;
    }

    public void setHistoriasClinicas(HashMap<Paciente, HistoriaClinica> historiasClinicas) {
        this.historiasClinicas = historiasClinicas;
    }

    public Set<Map.Entry<Paciente, HistoriaClinica>> getHistoriasClinicasIterator() {
        return this.historiasClinicas.entrySet();
    }

    public boolean existeHistoriaClinicaDePaciente(Paciente paciente) {
        return this.historiasClinicas.containsKey(paciente);
    }

    public void nuevaHistoriaClinica(Paciente paciente) {
        this.historiasClinicas.put(paciente, new HistoriaClinica(paciente.getNroHistoriaClinica()));
    }

    /**
     * TODO
     *
     * @param paciente
     * @param internacion
     */
    public void agregarInternacionPaciente(Paciente paciente, Internacion internacion) {
        HistoriaClinica historiaClinica = this.historiasClinicas.get(paciente);
        historiaClinica.agregarInternacion(internacion);
    }

    /**
     * TODO
     *
     * @param paciente
     * @param consultaMedica
     */
    public void agregarConsultaMedicaPaciente(Paciente paciente, ConsultaMedica consultaMedica) {
        HistoriaClinica historiaClinia = this.historiasClinicas.get(paciente);
        historiaClinia.agregarConsultaMedica(consultaMedica);
    }

    public HistoriaClinica getHistoriaClinicaPaciente(Paciente paciente) {
        return this.historiasClinicas.get(paciente);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModuloAtencion that = (ModuloAtencion) o;
        return Objects.equals(historiasClinicas, that.historiasClinicas) && Objects.equals(pacientesEnAtencion, that.pacientesEnAtencion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(historiasClinicas, pacientesEnAtencion);
    }
}