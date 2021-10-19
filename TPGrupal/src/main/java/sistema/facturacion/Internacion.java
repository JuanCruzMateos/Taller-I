package sistema.facturacion;

import sistema.habitaciones.Habitacion;

/**
 * Clase que modela una internacion.<br>
 * Contiene informacion sobre la habitacion, la cantidad de dias internado, el costo de la habitacion y el subtotal.<br>
 */
public class Internacion {
    private String habitacion;
    private int diasInternado;
    private double costoHabitacion;
    private double subtotal;

    public Internacion() {

    }

    /**
     * Constructor.<br>
     * <b>Pre: habitacion distinto de null, diasInternado mayor a cero.</b>
     * <b>Post: </b> se genera un a nueva instancia de internacion.<br>
     *
     * @param habitacion    Habitacion en que tiene lugar la internacion. Debe ser distinto de null.<br>
     * @param diasInternado Cantidad de dias internado. Debe ser mayor a cero.<br>
     */
    public Internacion(Habitacion habitacion, int diasInternado) {
        this.habitacion = habitacion.toString();
        this.diasInternado = diasInternado;
        this.costoHabitacion = habitacion.getCostoHabitacion();
        this.subtotal = habitacion.getCostoInternacion(diasInternado);
    }

    /**
     * Devuelve la habitacion en la que tiene lugar la internacion.<br>
     *
     * @return habitacion donde se interno al paciente.<br>
     */
    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion.toString();
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    /**
     * Devuelve el costo de la habitacion.<br>
     *
     * @return costo de la habitacion.<br>
     */
    public double getCostoHabitacion() {
        return this.costoHabitacion;
    }

    public void setCostoHabitacion(double costoHabitacion) {
        this.costoHabitacion = costoHabitacion;
    }

    /**
     * Devuelve la cantidad de dias internado.<br>
     *
     * @return cantidad de dias internado.<br>
     */
    public int getCantidadDiasInternacion() {
        return this.diasInternado;
    }

    /**
     * Devuelve el subtotal de la internacion.<br>
     *
     * @return subtotal de la internacion.<br>
     */
    public double getSubtotal() {
        return this.subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return String.format("%-20s %5s %.2f %10s %-10d %5s %.2f \n", this.habitacion, " ", this.costoHabitacion, " ", this.diasInternado, " ", this.subtotal);
    }

    public int getDiasInternado() {
        return diasInternado;
    }

    public void setDiasInternado(int diasInternado) {
        this.diasInternado = diasInternado;
    }
}