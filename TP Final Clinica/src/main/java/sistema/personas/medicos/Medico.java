package sistema.personas.medicos;

import sistema.personas.Persona;

/**
 * Clase abstracta que Modela un medico generico de la clinica.<br>
 */
public abstract class Medico extends Persona implements IMedico {
    protected static double sueldoBasico = 100.0;
    protected int matricula;

    /**
     * Constructor vacio para persistencia XML.<br>
     */
    public Medico() {

    }

    /**
     * Constructor. <br>
     * <b>Pre: </b> nombre, apellido, direccion, ciudad distintos de null; telenofo y dni enteros positivos.<br>
     * <b>Post: </b> se genera una nueva instancia de la clase.<br>
     *
     * @param nombre    Nombre del medico. Debe ser distinto de null.<br>
     * @param apellido  Apellido del medico. Debe ser distinto de null.<br>
     * @param direccion Direccion del medico. Debe ser distinto de null.<br>
     * @param ciudad    Ciudad de residencia del medico. Debe ser distinto de null.<br>
     * @param telefono  Telefono de contacto del medico. Numero entero positivo.<br>
     * @param dni       DNI del medico. Numero entero positivo.<br>
     * @param matricula Numero de matricula del medico.<br>
     */
    public Medico(String nombre, String apellido, String direccion, String ciudad, long telefono, int dni, int matricula) {
        super(nombre, apellido, direccion, ciudad, telefono, dni);
        this.matricula = matricula;
    }

    /**
     * Devuelve el sueldo basico de cualquier medico sin importar especialidad, posgrado o contratacion.<br>
     *
     * @return sueldoBasico del medico.<br>
     */
    public static double getSueldoBasico() {
        return sueldoBasico;
    }

    /**
     * Setea el sueldo basico para todos los medicos, sin importar especialidad, posgrado o contratacion.<br>
     * Este metodo se debe llamar desde la clase Medico y no desde sus hijas (para mayor claridad).<br>
     * <b>Pre: </b> sueldoBasico debe ser mayor o igual a cero.<br>
     *
     * @param sueldoBasico Sueldo basico de medico. Debe ser mayor o igual a cero.<br>
     */
    public static void setSueldoBasico(double sueldoBasico) {
        Medico.sueldoBasico = sueldoBasico;
    }

    @Override
    public int getMatricula() {
        return matricula;
    }

    @Override
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Medico: " + super.toString() + "[matricula=" + matricula + ']';
    }
}
