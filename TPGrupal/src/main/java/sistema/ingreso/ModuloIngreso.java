package sistema.ingreso;

import sistema.personas.pacientes.Paciente;
import sistema.personas.pacientes.PacienteFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Clase que modela el modulo de ingreso de la clinica.<br>
 * Se ocupa se asignar numero de orden al ingresar un paciente en la espera ( vip o patio).<br>
 * Si ya esta registrado, alta solo devuelve la ref y al ingresar lo pisa con una nuevo valor.<br>
 */
public class ModuloIngreso {
    private static int nroOrden = 0;
    private HashMap<Integer, Paciente> registroDePacientes = new HashMap<>();
    private Queue<Paciente> listaDeEspera = new LinkedList<>();
    private ArrayList<Paciente> listaPacientesEnPatio = new ArrayList<>();
    private Paciente salaVip;

    /**
     * Busca al paciente en el registro historico.<br>
     * Si lo encuentra devuelve su referencia.<br>
     * Si no, lo crea, lo agrega al registro historico y devuelve su referencia.<br>
     * <b>Pre:</b> nombre, apellido, direccion, ciudad y rangoEtario diferentes de null;  dni y telefono enteros positivos.<br>
     * <b>Post:</b> Devuelve referencia a un paciente o null si rangoEtario no existe. <br>
     *
     * @param nombre      Nombre del paciente. Debe ser distinto de null.<br>
     * @param apellido    Apellido del paciente. Debe ser distinto de null.<br>
     * @param direccion   Direccion del paciente. Debe ser distinto de null.<br>
     * @param ciudad      Ciudad del paciente. Debe ser distinto de null.<br>
     * @param telefono    Telefono del paciente. Debe ser un entero positivo.<br>
     * @param dni         DNI del paciente. Debe ser un entero positivo.<br>
     * @param rangoEtario Rango etario de paciente. Debe ser distinto de null.<br>
     * @return referencia al paciente.
     */
    public Paciente altaPaciente(String nombre, String apellido, String direccion, String ciudad, int telefono, int dni, String rangoEtario) {
        Paciente paciente = null;

        if (this.registroDePacientes.containsKey(dni)) {
            return this.registroDePacientes.get(dni);
        } else {
            paciente = PacienteFactory.getPaciente(nombre, apellido, direccion, ciudad, telefono, dni, rangoEtario);
            this.registroDePacientes.put(dni, paciente);
            return paciente;
        }
    }

    /**
     * Ingresa paciente para atencion, si ya no se encuentra presente en la lista, otorgadole un numero de orden y ubicandolo en sala vip o patio segun corresponda.<br>
     * Si el paciente ya esta presente el metodo no tiene efecto.<br>
     * <b>Pre: </b> paciente distinto de null.<br>
     * <b>Post: </b> se asigna al paciente un numero de orden y se lo ubica en la sala de espera o en el patio.<br>
     *
     * @param paciente Paciente a ingresar a antencion. Debe ser distinto de null.<br>
     */
    public void ingresoPaciente(Paciente paciente) {
        if (!this.listaDeEspera.contains(paciente)) {
            ModuloIngreso.nroOrden++;
            paciente.setNroOrden(nroOrden);
            this.listaDeEspera.add(paciente);
            if (this.salaVip == null) {
                this.salaVip = paciente;
            } else {
                if (this.salaVip.quedaEnSalaVipFrenteA(paciente))
                    this.listaPacientesEnPatio.add(paciente);
                else {
                    this.listaPacientesEnPatio.add(this.salaVip);
                    this.salaVip = paciente;
                }
            }
        }
    }

    /**
     * Devuelve el proximo paciente de la cola para atender.<br>
     *
     * @return null, si no hay pacientes en sala de espera, o proximo paciente a atender en el orden que le corresponde.<br>
     */
    public Paciente getPacienteParaAtender() {

        if (this.listaDeEspera.isEmpty())
            // podria ir una excepcion -> SalaDeEsperaVaciaException
            return null;
        else {
            Paciente paciente = this.listaDeEspera.remove();
            if (paciente == this.salaVip)
                this.salaVip = null;
            else
                this.listaPacientesEnPatio.remove(paciente);
            return paciente;
        }
    }

    /**
     * Devuelve la cantidad de personas en espera de ser atendidas.<br>
     *
     * @return cantidad de personas en espera de ser atendidas.<br>
     */
    public int cantidadDePacientesEnEspera() {
        return this.listaDeEspera.size();
    }

    /**
     * Devuelve la cantidad de personas esperando en el patio.<br>
     *
     * @return cantidad de personas esperando en el patio.<br>
     */
    public int cantidadDePacientesEnPatio() {
        return this.listaPacientesEnPatio.size();
    }

    /**
     * @return true or false si salaVip esta ocupada
     */
    public boolean salaVipOcupada() {
        return this.salaVip != null;
    }
}
