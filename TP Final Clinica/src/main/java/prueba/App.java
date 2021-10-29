package prueba;

import sistema.atencion.HistoriaClinica;
import sistema.clinica.Clinica;
import sistema.excepciones.PacienteInexistenteException;
import sistema.facturacion.ConsultaMedica;
import sistema.facturacion.Internacion;
import sistema.persistencia.AccesoDatos;
import sistema.persistencia.dto.DTOConverter;
import sistema.personas.pacientes.Paciente;

import java.io.IOException;

/**
 * Clase de prueba del sistema.<br>
 * Simula la clinica en funcionamiento harcodeando medicos, pacientes, atenciones, internaciones, facturaciones y reportes.<br>
 */
public class App {
    public static void main(String[] args) throws IOException {
        AccesoDatos.initClinica();

//        for (Paciente p : Clinica.getInstance().getHitoriasClinicas().keySet()) {
//            System.out.println(p.getNombre());
//            HistoriaClinica hc = null;
//            try {
//                hc = Clinica.getInstance().getHistoriaClinicaPaciente(p);
//            } catch (PacienteInexistenteException e) {
//                e.printStackTrace();
//            }
//            System.out.println("internacions no facturadas");
//            for (Internacion i : hc.getInternaciones()) {
//                System.out.println(i.isFacturada());
//            }
//            System.out.println("consultas no facturadas");
//            for (ConsultaMedica i : hc.getConsultaMedicas()) {
//                System.out.println(i.isFacturada());
//            }
//        }
        AccesoDatos.persistirClinica(DTOConverter.ClinicaDTOFromClinica());
    }
}