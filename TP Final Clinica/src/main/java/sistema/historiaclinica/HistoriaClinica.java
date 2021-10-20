package sistema.historiaclinica;

import sistema.facturacion.ConsultaMedica;
import sistema.facturacion.Internacion;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * TODO
 */
public class HistoriaClinica {
    private ArrayList<Internacion> internacions = new ArrayList<>();
    private ArrayList<ConsultaMedica> consultaMedicas = new ArrayList<>();

    public void agregarInternacion(Internacion internacion) {
        this.internacions.add(internacion);
    }

    public void agregarConsultaMedica(ConsultaMedica consultaMedica) {
        this.consultaMedicas.add(consultaMedica);
    }

    public int getCantidadDeInternaciones() {
        return this.internacions.size();
    }

    public int getCantidadDeConsultasMedicas() {
        return this.consultaMedicas.size();
    }

    public int getCantidadDeInternacionesSinFacturar() {
        int total = 0;

        for (Internacion internacion : this.internacions) {
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
        return this.internacions.iterator();
    }

    public Iterator<ConsultaMedica> getConsultasMedicasIterator() {
        return this.consultaMedicas.iterator();
    }

    public ArrayList<Internacion> getInternacions() {
        return internacions;
    }

    public void setInternacions(ArrayList<Internacion> internacions) {
        this.internacions = internacions;
    }

    public ArrayList<ConsultaMedica> getConsultaMedicas() {
        return consultaMedicas;
    }

    public void setConsultaMedicas(ArrayList<ConsultaMedica> consultaMedicas) {
        this.consultaMedicas = consultaMedicas;
    }
}
