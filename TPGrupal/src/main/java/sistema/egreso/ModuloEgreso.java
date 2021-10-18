package sistema.egreso;

import sistema.facturacion.ConsultaMedica;
import sistema.facturacion.Factura;
import sistema.facturacion.Internacion;
import sistema.personas.medicos.IMedico;
import sistema.personas.pacientes.Paciente;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Clase que modela el modulo de egreso de la clinica.<br>
 */
public class ModuloEgreso {
    //    private SortedArrayList<Factura> facturas = new SortedArrayList<>();
    private TreeSet<Factura> facturas = new TreeSet<>();

    /**
     * Genera una factura para un paciente determinado y la almacena en un registro de facturas.<br>
     * <b>Pre:</b> fecha distina de null.<br>
     *
     * @param paciente        paciente a facturar.<br>
     * @param fecha           fecha de la factura.<br>
     * @param consultaMedicas lista de consulatas medicas.<br>
     * @param internacions    lista de internaciones.<br>
     */
    public void facturar(Paciente paciente, GregorianCalendar fecha, ArrayList<ConsultaMedica> consultaMedicas, ArrayList<Internacion> internacions) {
        Factura factura = new Factura(fecha, paciente, consultaMedicas, internacions);
        this.facturas.add(factura);
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
}
