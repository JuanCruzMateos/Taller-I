package sistema.egreso;

import sistema.clinica.Clinica;
import sistema.facturacion.ConsultaMedica;
import sistema.facturacion.Factura;
import sistema.facturacion.Internacion;
import sistema.atencion.HistoriaClinica;
import sistema.personas.medicos.IMedico;
import sistema.personas.pacientes.Paciente;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

/**
 * Clase que modela el modulo de egreso de la clinica.<br>
 */
public class ModuloEgreso implements Serializable {
    private ArrayList<Factura> facturas = new ArrayList<>();

    /**
     * Genera una factura para un paciente determinado y la almacena en un registro de facturas.<br>
     * <b>Pre:</b> fecha distina de null.<br>
     *
     * @param paciente        paciente a facturar.<br>
     * @param fecha           fecha de la factura.<br>
     * @param consultaMedicas lista de consulatas medicas.<br>
     * @param internacions    lista de internaciones.<br>
     * TODO eliminar
     */
    public void facturar(Paciente paciente, GregorianCalendar fecha, ArrayList<ConsultaMedica> consultaMedicas, ArrayList<Internacion> internacions) {
        Factura factura = new Factura(fecha, paciente, consultaMedicas, internacions);
        this.facturas.add(factura);
    }

    /**
     * TODO
     *
     * @param paciente
     * @param fecha
     */
    public void facturar(Paciente paciente, HistoriaClinica historiaClinica, GregorianCalendar fecha) {
        ArrayList<ConsultaMedica> consultaMedicas = new ArrayList<>();
        ArrayList<Internacion> internaciones = new ArrayList<>();

        for (Internacion in : historiaClinica.getInternacions()) {
            if (!in.isFacturada()) {
                in.setFacturada(true);
                internaciones.add(in);
            }
        }
        for (ConsultaMedica cm : historiaClinica.getConsultaMedicas()) {
            if (!cm.isFacturada()) {
                cm.setFacturada(true);
                consultaMedicas.add(cm);
            }
        }
        if (consultaMedicas.size() != 0 || internaciones.size() != 0) {
            Factura factura = new Factura(fecha, paciente, consultaMedicas, internaciones);
            this.facturas.add(factura);
        }
    }

    /**
     * Retorna el detalle de una factura.<br>
     * <b>Pre: </b> numeroFactura mayor a cero.<br>
     *
     * @param numeroFactura numero de la factura que se desea buscar.<br>
     * @return detalle de la factua o null, si no existe factura con el numero indicado.<br>
     */
    public String getFactura(int numeroFactura) {
        Iterator<Factura> it = this.facturas.iterator();
        Factura fact = null;
        boolean esta = false;

        while (it.hasNext() && !esta) {
            fact = it.next();
            if (fact.getNroFactura() == numeroFactura)
                esta = true;
        }
        return esta ? fact.toString() : null;
    }

    /**
     * Genera el reporte del medico en orden cronologico segun las fechas indicadas.<br>
     * <b>Pre: </b> medico, desde y hasta diferentes de null.<br>
     *
     * @param medico medico cuyo reporte se desea generar. <br>
     * @param desde  fecha inicial.<br>
     * @param hasta  fecha final.<br>
     * @return reporte del medico.<br>
     */
    public String reporteMedico(IMedico medico, GregorianCalendar desde, GregorianCalendar hasta) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<ConsultaMedica> consultaMedicas;
        double total = 0;
        String detalle;

        stringBuilder.append("********* Reporte de actividad medica ***********************************\n");
        stringBuilder.append("Medico: Dr. ").append(medico.getApellido()).append(". Matricula nro.: ").append(medico.getMatricula()).append(".\n");
        for (Factura factura : this.facturas) {
            consultaMedicas = factura.getConsultasConMedicos();
            for (ConsultaMedica consultaMedica : consultaMedicas) {
                if (consultaMedica.getMedico() == medico && (desde.compareTo(factura.getFecha()) <= 0 && hasta.compareTo(factura.getFecha()) >= 0)) {
                    total += consultaMedica.getSubtotal();
                    detalle = String.format("Fecha: %s, paciente: %s %s, honorarios: %.2f.\n", formatter.format(factura.getFecha().getTime()), factura.getPaciente().getNombre(), factura.getPaciente().getApellido(), consultaMedica.getSubtotal());
                    stringBuilder.append(detalle);
                }
            }
        }
        stringBuilder.append("Total: ").append(String.format("%.2f", total)).append("\n");
        stringBuilder.append("*************************************************************************\n");
        return stringBuilder.toString();
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }

    public String ultimaFacturaAgregada() {
        int numeroFactura = this.facturas.size();
        Iterator<Factura> it = this.facturas.iterator();
        Factura fact = null;
        boolean esta = false;

        while (it.hasNext() && !esta) {
            fact = it.next();
            if (fact.getNroFactura() == numeroFactura)
                esta = true;
        }
        return esta ? fact.toString() : null;
    }

    public Iterator<Factura> getFacturasIterator() {
        return this.facturas.iterator();
    }
}