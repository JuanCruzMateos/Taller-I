package sistema.personas;

import java.util.Objects;

/**
 * Clase que modela a una persona con su informacion de contacto basica.<br>
 */
public abstract class Persona {
    protected String nombre;
    protected String apellido;
    protected String direccion;
    protected String ciudad;
    protected String telefono;
    protected int dni;

    /**
     * Constructor vacio para persistencia XML.<br>
     */
    public Persona() {

    }

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
    public Persona(String nombre, String apellido, String direccion, String ciudad, String telefono, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return dni == persona.dni && Objects.equals(nombre, persona.nombre) && Objects.equals(apellido, persona.apellido) && Objects.equals(direccion, persona.direccion) && Objects.equals(ciudad, persona.ciudad) && Objects.equals(telefono, persona.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, direccion, ciudad, telefono, dni);
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
