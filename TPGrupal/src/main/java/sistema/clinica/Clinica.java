package sistema.clinica;

import sistema.atencion.ModuloAtencion;
import sistema.egreso.ModuloEgreso;
import sistema.excepciones.ContratacionNoValidaException;
import sistema.excepciones.EspecialidadNoValidaException;
import sistema.excepciones.InformacionPersonalNoValidaException;
import sistema.excepciones.PosgradoNoValidoException;
import sistema.facturacion.ConsultaMedica;
import sistema.facturacion.Internacion;
import sistema.ingreso.ModuloIngreso;
import sistema.personas.medicos.IMedico;
import sistema.personas.medicos.factory.MedicoFactory;
import sistema.personas.pacientes.Paciente;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * @author Grupo 4
 * Clase que representa a la clinica.<br>
 * Aplica patron Singleton.<br>
 * Contiene todos los medicos<br>
 * Contiene todos los pacientes a traves de la clase ModuloIngreso.<br>
 */
public class Clinica {
    private static Clinica instance = null;
    private String nombre;
    private String direccion;
    private String ciudad;
    private long telefono;
    private HashMap<Integer, IMedico> medicos = new HashMap<>();
    private ModuloIngreso moduloIngreso = new ModuloIngreso();
    private ModuloAtencion moduloAtencion = new ModuloAtencion();
    private ModuloEgreso moduloEgreso = new ModuloEgreso();

    private Clinica() {
        // Constructor vacio
    }

    public static Clinica getInstance() {
        if (Clinica.instance == null)
            Clinica.instance = new Clinica();
        return Clinica.instance;
    }

    /**
     * Da de alta a un paciente. Si el paciente ha sido atendido previamente en la clinica, se lo busca y retorna su referencia.<br>
     * Si se trata de un paciente nuevo, lo crea, se guarda en el registro historico y se devuelve su referencia.<br>
     *
     * @param nombre      Nombre del paciente.
     * @param apellido    Apellido del paciente.
     * @param direccion   Direccion del paciente.
     * @param ciudad      Ciudad del paciente.
     * @param telefono    Telefono del paciente.
     * @param dni         DNI del paciente.
     * @param rangoEtario Rango etario de paciente.
     * @return referencia al paciente.
     */
    public Paciente altaPaciente(String nombre, String apellido, String direccion, String ciudad, long telefono, int dni, String rangoEtario) {
        return this.moduloIngreso.altaPaciente(nombre, apellido, direccion, ciudad, telefono, dni, rangoEtario);
    }

    /**
     * Ingresa al paciente a la lista de espera, asignadole un numero de orden y ubicandolo en la sala vip o en el patio
     * segun corresponda.<br>
     * Si el paciente ya esta presente el metodo no tiene efecto.<br>
     * <b>Pre: </b> paciente != null.<br>
     * <b>Post: </b> Se otorga un numero de orden al paciente, se lo ubica en la lista de espera, y en la sala vip o en el pactio segun corresponda.<br>
     *
     * @param paciente Paciente a ingresar a sala de espera.<br>
     */
    public void ingresarPaciente(Paciente paciente) {
        this.moduloIngreso.ingresoPaciente(paciente);
    }

    /**
     * Retira al primer paciente de la lista de espera para ser atendido, ingresandolo en la lista de atencion.<br>
     * <b>Post: </b> Se retira el proximo paciente a ser atendido ingreandolo a la lista de pacientes en atencion.
     * Si no hay ningun paciente en espera, no tiene ningun efecto.<br>
     */
    public void atenderPaciente() {
        Paciente paciente = this.moduloIngreso.getPacienteParaAtender();
        if (paciente != null)
            this.moduloAtencion.atenderPaciente(paciente);
    }

    /**
     * Ingresa un nuevo medico a la clinica.<br>
     * <b>Post: </b> Se agrega un nuevo medico a la clinica.<br>
     *
     * @param especialidad Especialidad del medico: Clinica, Cirugia o Pediatria..<br>
     * @param posgrado     Posgrado: Doctor, Magister.<br>
     * @param contratacion Tipo de contratacion: Permanente, Temporario.<br>
     * @param nombre       Nombre del medico.<br>
     * @param apellido     Apellido del medico.<br>
     * @param direccion    Direccion del medico.<br>
     * @param ciudad       Ciudad de residencia del medico.<br>
     * @param telefono     Telefono de contacto del medico.<br>
     * @param dni          Dni del medico.<br>
     * @param matricula    Matricula del medico.<br>
     * @throws InformacionPersonalNoValidaException
     * @throws EspecialidadNoValidaException
     * @throws PosgradoNoValidoException
     * @throws ContratacionNoValidaException
     */
    public void agregarMedico(String especialidad, String posgrado, String contratacion, String nombre, String apellido,
                              String direccion, String ciudad, long telefono, int dni, int matricula)
            throws InformacionPersonalNoValidaException, EspecialidadNoValidaException,
            PosgradoNoValidoException, ContratacionNoValidaException {

        IMedico medico = MedicoFactory.getMedico(especialidad, posgrado, contratacion, nombre, apellido, direccion, ciudad, telefono, dni, matricula);
        this.medicos.put(matricula, medico);
    }

    /**
     * Devuelve el medico cuya matricula es la solicitada o null si no existe un medico asociado a esa matricula.<br>
     * <b>Pre: </b> matricula debe ser un entero positivo.<br>
     *
     * @param matricula Matricula del medico a buscar.<br>
     * @return Medico cuya matricula se pasa por parametro o null si no existe el medico.<br>
     */
    public IMedico getMedico(int matricula) {
        return this.medicos.getOrDefault(matricula, null);
    }

    /**
     * Selecciona un paciente dado su dni de aquellos en atencion.<br>
     * <b>Pre: </b> El dni debe ser mayor a cero.<br>
     * <b>Post: </b> Se devuelve el paciente cuyo documento es dni o null en caso de no encontrarse un paciente con ese dni.<br>
     *
     * @param dni DNI del paciente a buscar. Debe ser un entero positivo.<br>
     * @return Paciente cuyo dni es el pasado por parametro o null en caso de no encontrarse ningun paciente con ese dni.<br>
     */
    public Paciente egresoPaciente(int dni) {
        return this.moduloAtencion.egresoPaciente(dni);
    }


    /**
     * Genera la factura dado un paciente, las listas de internaciones y consultas realizadas y la fecha de facturacion.<br>
     * <b>Pre: </b> paciente != null, fecha != null, consultaMedicas != null, internaciones != null.<br>
     * <b>Post: </b> Se genera la factura y se guarda en el registro de facturas.<br>
     *
     * @param paciente        Paciente a confeccionar la factura.<br>
     * @param fecha           Fecha de la factura.<br>
     * @param consultaMedicas Lista de consultas medicas.<br>
     * @param internacions    Lista de internaciones.<br>
     */
    public void facturar(Paciente paciente, GregorianCalendar fecha, ArrayList<ConsultaMedica> consultaMedicas, ArrayList<Internacion> internacions) {
        this.moduloEgreso.facturar(paciente, fecha, consultaMedicas, internacions);
    }

    /**
     * Busca una determinada factura por numero y devuelve su detalle o null si no la encuentra.
     *
     * @param numeroFactura mayor a 0, numero de la factura a buscar.<br>
     * @return detalle de la factura o null.<br>
     */
    public String getDetalleFactura(int numeroFactura) {
        return this.moduloEgreso.getFactura(numeroFactura);
    }

    /**
     * Genera reporte medico para un medico determinado, entre dos fechas estipuladas.<br>
     *
     * @param medico Medico al cual se le hace el reporte.<br>
     * @param desde  Fecha Inicial.<br>
     * @param hasta  Fecha Final.<br>
     *               <b>Pre:</b> medico distinto de null, desde menor o igual a hasta.<br>
     *               <b>Post:</b>  	Se genera el reporte medico.<br>
     * @return reporte del medico.<br>
     */
    public String getReporteMedico(IMedico medico, GregorianCalendar desde, GregorianCalendar hasta) {
        return this.moduloEgreso.reporteMedico(medico, desde, hasta);
    }

    /**
     * Metodo ToString que brinda una breve descripcion de la clinica.<br>
     */
    @Override
    public String toString() {
        return "Clinica [" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", telefono=" + telefono +
                ']';
    }

    /**
     * Genera un reporte de la situacion actual de la clinica, indicando cuantos pacientes hay en espera de ser atendidos
     * Indica la cantidad de pacientes en el patio y si hay alguien en la sala VIP
     *
     * @return String     Contiene toda la descripcion mencionada
     */
    public String estadoDeLaClinica() {
        return "Estado de la clinica:\nPacientes en sala de espera: " + this.moduloIngreso.cantidadDePacientesEnEspera() + "\n" +
                "   - en patio: " + this.moduloIngreso.cantidadDePacientesEnPatio() + "\n" +
                "   - en sala vip: " + ((this.moduloIngreso.salaVipOcupada()) ? 1 : 0) + "\n" +
                "Pacientes en atencion: " + this.moduloAtencion.cantidadDePacientesEnAtencion() + "\n";
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Setea el nombre de la Clinica.<br>
     *
     * @param nombre String que contiene nombre de la clinica.<br>
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    /**
     * Setea la direccion de la clinica.<br>
     *
     * @param direccion String que contiene la direccion de la clinica.<br>
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    /**
     * Setea la ciudad de la clinica.<br>
     *
     * @param ciudad String que contiene la ciudad en donde funciona la clinica.<br>
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public long getTelefono() {
        return telefono;
    }

    /**
     * Setea el telefono de la clinica.<br>
     *
     * @param telefono (int) que almacena el telefono de la clinica.<br>
     */
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public HashMap<Integer, IMedico> getMedicos() {
        return medicos;
    }

    public void setMedicos(HashMap<Integer, IMedico> medicos) {
        this.medicos = medicos;
    }

    public ModuloIngreso getModuloIngreso() {
        return moduloIngreso;
    }

    public void setModuloIngreso(ModuloIngreso moduloIngreso) {
        this.moduloIngreso = moduloIngreso;
    }

    public ModuloAtencion getModuloAtencion() {
        return moduloAtencion;
    }

    public void setModuloAtencion(ModuloAtencion moduloAtencion) {
        this.moduloAtencion = moduloAtencion;
    }

    public ModuloEgreso getModuloEgreso() {
        return moduloEgreso;
    }

    public void setModuloEgreso(ModuloEgreso moduloEgreso) {
        this.moduloEgreso = moduloEgreso;
    }


    public ArrayList<Paciente> getPacientesEnAtencion() {
        return this.moduloAtencion.getPacientesEnAtencion();
    }

    public ArrayList<IMedico> getListaMedicos() {
        Collection<IMedico> values = medicos.values();
        return new ArrayList<>(values);
    }

    public String getDetalleUltimaFactura() {
        return this.moduloEgreso.ultimaFacturaAgregada();
    }
}