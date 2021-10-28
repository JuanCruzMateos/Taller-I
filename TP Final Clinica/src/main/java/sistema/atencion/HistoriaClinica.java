package sistema.atencion;

import sistema.facturacion.ConsultaMedica;
import sistema.facturacion.Internacion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 * TODO
 */
public class HistoriaClinica {
    private int numero;
    private ArrayList<Internacion> internaciones = new ArrayList<>();
    private ArrayList<ConsultaMedica> consultaMedicas = new ArrayList<>();

    public HistoriaClinica() {

    }

    public HistoriaClinica(int numero) {
        this.numero = numero;
    }

    public void agregarInternacion(Internacion internacion) {
        this.internaciones.add(internacion);
    }

    public void agregarConsultaMedica(ConsultaMedica consultaMedica) {
        this.consultaMedicas.add(consultaMedica);
    }

    public int getCantidadDeInternaciones() {
        return this.internaciones.size();
    }

    public int getCantidadDeConsultasMedicas() {
        return this.consultaMedicas.size();
    }

    public int getCantidadDeInternacionesSinFacturar() {
        int total = 0;

        for (Internacion internacion : this.internaciones) {
            if (!internacion.isFacturada())
                total += 1;
        }
        return total;
    }

    public int getCantidadDeConsultasMedicasSinFacturar() {
        int total = 0;

        for (ConsultaMedica consultaMedica : this.consultaMedicas) {
            if (!consultaMedica.isFacturada())
                total += 1;
        }
        return total;
    }

    public Iterator<Internacion> getInternacionesIterator() {
        return this.internaciones.iterator();
    }

    public Iterator<ConsultaMedica> getConsultasMedicasIterator() {
        return this.consultaMedicas.iterator();
    }

    public ArrayList<Internacion> getInternaciones() {
        return internaciones;
    }

    public void setInternaciones(ArrayList<Internacion> internaciones) {
        this.internaciones = internaciones;
    }

    public ArrayList<ConsultaMedica> getConsultaMedicas() {
        return consultaMedicas;
    }

    public void setConsultaMedicas(ArrayList<ConsultaMedica> consultaMedicas) {
        this.consultaMedicas = consultaMedicas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoriaClinica that = (HistoriaClinica) o;
        return numero == that.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String toString() {
        return "HistoriaClinica{" +
                "numero=" + numero +
                ", internacions=" + internaciones +
                ", consultaMedicas=" + consultaMedicas +
                '}';
    }
}
