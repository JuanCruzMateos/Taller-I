package sistema.personas.pacientes;

import sistema.personas.Persona;

import java.util.Objects;

/**
 * Clase que modela a un paciente de la clinica.<br>
 */
public abstract class Paciente extends Persona {
    protected int nroHistoriaClinica;
    protected int nroOrden;

    /**
     * Constructor vacio para persistencia XML.<br>
     */
    public Paciente() {

    }

    /**
     * Constructor. <br>
     * <b>Pre: </b> nombre, apellido, direccion, ciudad distintos de null; telenofo y dni enteros positivos.<br>
     *
     * @param nombre             Nombre del paciente. Debe ser distinto de null.<br>
     * @param apellido           Apellido del paciente. Debe ser distinto de null.<br>
     * @param direccion          Direccion del paciente. Debe ser distinto de null.<br>
     * @param ciudad             Ciudad de residencia del paciente. Debe ser distinto de null.<br>
     * @param telefono           Telefono de contacto del paciente. Numero entero positivo.<br>
     * @param dni                DNI del paciente. Numero entero positivo.<br>
     * @param nroHistoriaClinica Numero de historia clinica del paciente.<br>
     */
    public Paciente(String nombre, String apellido, String direccion, String ciudad, long telefono, int dni, int nroHistoriaClinica) {
        super(nombre, apellido, direccion, ciudad, telefono, dni);
        this.nroHistoriaClinica = nroHistoriaClinica;
    }

    /**
     * A implementar en clases extendidas - Double dispatch
     *
     * @param p debe ser distinto de null.<br>
     * @return true si this permanece o false si p permanece en sala vip.<br>
     */
    public abstract boolean quedaEnSalaVipFrenteA(Paciente p);


    /**
     * A implementar en clases extendidas - Double dispatch.<br>
     */
    public abstract boolean quedaNino();

    /**
     * A implementar en clases extendidas - Double dispatch.<br>
     */
    public abstract boolean quedaJoven();

    /**
     * A implementar en clases extendidas - Double dispatch.<br>
     */
    public abstract boolean quedaMayor();

    /**
     * Devuelve el numero de orden para ser atendido.<br>
     */
    public int getNroOrden() {
        return nroOrden;
    }

    /**
     * Setear numero de orden para ser atendido.<br>
     *
     * @param nroOrden entero positivo.<br>
     */
    public void setNroOrden(int nroOrden) {
        this.nroOrden = nroOrden;
    }

    /**
     * Retorna numero de historia clinica del paciente.<br>
     *
     * @return numero de historia clinica del paciente.<br>
     */
    public int getNroHistoriaClinica() {
        return nroHistoriaClinica;
    }

    public void setNroHistoriaClinica(int nroHistoriaClinica) {
        this.nroHistoriaClinica = nroHistoriaClinica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Paciente paciente = (Paciente) o;
        return nroHistoriaClinica == paciente.nroHistoriaClinica && nroOrden == paciente.nroOrden;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nroHistoriaClinica, nroOrden);
    }

    @Override
    public String toString() {
        return "Paciente: " + super.toString() +
                "[nroHistoriaClinica=" + nroHistoriaClinica +
                ", nroOrden=" + nroOrden + ']';
    }
}

