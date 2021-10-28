package prueba;

import sistema.atencion.HistoriaClinica;
import sistema.clinica.Clinica;
import sistema.facturacion.ConsultaMedica;
import sistema.facturacion.Internacion;
import sistema.habitaciones.HabitacionPrivada;
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
//        AccesoDatos.initClinica();
//
//        for (Paciente p : Clinica.getInstance().getHitoriasClinicas().keySet()) {
//            System.out.println(p.getNombre());
//            HistoriaClinica hc = Clinica.getInstance().getHistoriaClinicaPaciente(p);
//            System.out.println("internacions no facturadas");
//            for (Internacion i : hc.getInternaciones()) {
//                System.out.println(i.isFacturada());
//            }
//            System.out.println("consultas no facturadas");
//            for (ConsultaMedica i : hc.getConsultaMedicas()) {
//                System.out.println(i.isFacturada());
//            }
//        }
//        AccesoDatos.persistirClinica(DTOConverter.ClinicaDTOFromClinica());

        Clinica clinica = Clinica.getInstance();

        Paciente paciente = clinica.altaPaciente("Juan Cruz", "Mateos", "Almafuerte 2356", "Mar del Plata", 101, 1, "joven");
        System.out.println(paciente);
        clinica.ingresarPaciente(paciente);
        clinica.atenderSiguentePaciente();
        Paciente devueltor = clinica.egresoPaciente(1);
        System.out.println(devueltor);
        System.out.println(devueltor == paciente);

        //clinica.agregarInternacionPaciente(devueltor, new Internacion(HabitacionPrivada.getInstance(),12 ));
        HistoriaClinica hc = clinica.getHistoriaClinicaPaciente(devueltor);
        System.out.println(hc);

        System.out.println(paciente.equals(devueltor));
    }
}