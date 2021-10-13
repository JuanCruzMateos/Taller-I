package sistema.personas;

/**
 * Clase que modela a una persona con su informacion de contacto basica.<br>
 */
public abstract class Persona {
    protected String nombre;
    protected String apellido;
    protected String direccion;
    protected String ciudad;
    protected int telefono;
    protected int dni;

    /**
     * Constructor. <br>
     * <b>Pre: </b> nombre, apellido, direccion, ciudad distintos de null; telenofo y dni enteros positivos.<br>
     *
     * @param nombre    Nombre de la persona. Debe ser distinto de null.<br>
     * @param apellido  Apellido de la persona. Debe ser distinto de null.<br>
     * @param direccion Direccion de la persona. Debe ser distinto de null.<br>
     * @param ciudad    Ciudad de residencia de la persona. Debe ser distinto de null.<br>
     * @param telefono  Telefono de contacto de la persona. Numero entero positivo.<br>
     * @param dni       DNI de la persona. Numero entero positivo.<br>
     */
    public Persona(String nombre, String apellido, String direccion, String ciudad, int telefono, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.dni = dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getDni() {
        return this.dni;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "[nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", telefono=" + telefono +
                ", dni=" + dni + ']';
    }
}
