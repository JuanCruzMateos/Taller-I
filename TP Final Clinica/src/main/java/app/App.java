package app;

import sistema.clinica.Clinica;
import sistema.facturacion.ConsultaMedica;
import sistema.facturacion.Internacion;
import sistema.historiaclinica.HistoriaClinica;
import sistema.persistencia.AccesoDatos;
import sistema.personas.pacientes.Paciente;

/**
 * Clase de prueba del sistema.<br>
 * Simula la clinica en funcionamiento harcodeando medicos, pacientes, atenciones, internaciones, facturaciones y reportes.<br>
 */
public class App {
    public static void main(String[] args) {
        AccesoDatos.initClinica();

        for (Paciente p : Clinica.getInstance().getHitoriasClinicas().keySet()) {
            System.out.println(p.getNombre());
            HistoriaClinica hc = Clinica.getInstance().getHistoriaClinicaPaciente(p);
            System.out.println("internacions no facturadas");
            for (Internacion i : hc.getInternacions()) {
                System.out.println(i.isFacturada());
            }
            System.out.println("consultas no facturadas");
            for (ConsultaMedica i : hc.getConsultaMedicas()) {
                System.out.println(i.isFacturada());
            }
        }
        AccesoDatos.persistirClinica();
    }
}