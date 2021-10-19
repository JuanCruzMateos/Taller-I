package sistema.persistencia;

import sistema.clinica.Clinica;
import sistema.excepciones.*;
import sistema.facturacion.ConsultaMedica;
import sistema.facturacion.Internacion;
import sistema.habitaciones.Habitacion;
import sistema.habitaciones.HabitacionCompartida;
import sistema.habitaciones.HabitacionPrivada;
import sistema.habitaciones.HabitacionTerapiaIntensiva;
import sistema.persistencia.dto.ClinicaDTO;
import sistema.persistencia.dto.DTOConverter;
import sistema.personas.medicos.IMedico;
import sistema.personas.pacientes.Paciente;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Clase encargada de la pesistencia de los datos.<br>
 */
public class AccesoDatos {

//    public static void initClinica(String file) {
//        PersistenciaXML io = new PersistenciaXML();
//
//        try {
//            io.openInput(file);
////            DTOConverter.ClinicaFromClinicaDTO((ClinicaDTO) io.read());
//            io.closeInput();
//        } catch (Exception e) {
//            Habitacion.setCostoAsignacion(100);
//            HabitacionCompartida.getInstance().setCostoHabCompartida(10);
//            HabitacionPrivada.getInstance().setCostoHabPrivada(20);
//            HabitacionTerapiaIntensiva.getInstance().setCostoHabTerapiaIntensiva(30);
//
//            // Creo la clinica. Guardo la referencia del singleton en la variable clinica.
//            Clinica clinica = Clinica.getInstance();
//            clinica.setNombre("HIGA");
//            clinica.setCiudad("Mar del Plata");
//            clinica.setDireccion("Juan B. Justo 10000");
//            clinica.setTelefono(4827593L);
//
//            try {
//                clinica.agregarMedico("clinica", "doctor", "permanente", "Rene", "Favaloro", "Alverar 3101", "Buenos Aires", 369258L, 8125936, 1);
//                clinica.agregarMedico("pediatria", "doctor", "permanente", "Carlos", "Rivas", "Libertador 1401", "Buenos Aires", 4852963L, 272589, 2);
//                clinica.agregarMedico("clinica", "magister", "temporario", "Marta", "Perez", "Diagonal 3 2589", "La Plata", 155937825L, 853259, 3);
//                clinica.agregarMedico("cirugia", "magister", "temporario", "Lucia", "Rodriguez", "Mitre 1479", "Mar del Plata", 369258L, 15236, 4);
//                clinica.agregarMedico("cirugia", "doctor", "temporario", "Lucas", "Gonzales", "Salta 936", "Mar del Plata", 369258L, 78932, 5);
//                clinica.agregarMedico("pediatria", "doctor", "permanente", "Carolina", "Sanchez", "Falucho 3705", "Buenos Aires", 369258L, 93624, 6);
//            } catch (Exception exception) {
//                e.printStackTrace();
//            }
//
//            IMedico medico1 = clinica.getMedico(1);
//            IMedico medico2 = clinica.getMedico(2);
//            IMedico medico3 = clinica.getMedico(3);
//            IMedico medico4 = clinica.getMedico(4);
//            IMedico medico5 = clinica.getMedico(5);
//            IMedico medico6 = clinica.getMedico(6);
//
//            Paciente paciente1 = clinica.altaPaciente("Juan Cruz", "Mateos", "Almafuerte 2356", "Mar del Plata", 101L, 1, "joven");
//            Paciente paciente2 = clinica.altaPaciente("Camila", "Ezama", "Formosa 2014", "Mar del Plata", 102L, 2, "nino");
//            Paciente paciente3 = clinica.altaPaciente("Noelia", "Echeverria", "Matheu 3952", "Mar del Plata", 103L, 3, "mayor");
//            Paciente paciente4 = clinica.altaPaciente("Sebastian", "Bengoa", "Quintana 1016", "Mar del Plata", 104L, 4, "joven");
//            Paciente paciente5 = clinica.altaPaciente("Candela", "Ramos", "Primera Junta 1006", "Mar del Plata", 105L, 5, "nino");
//            Paciente paciente6 = clinica.altaPaciente("Marcos", "Jimenez", "Roca 1782", "Mar del Plata", 106L, 6, "mayor");
//            Paciente paciente7 = clinica.altaPaciente("Lucas", "Rodriguez", "Paso 3691", "Mar del Plata", 107L, 7, "joven");
//
//            Paciente paciente8 = clinica.altaPaciente("Sebastian", "Bengoa", "Quintana 1016", "Mar del Plata", 104L, 4, "joven");
//
//            clinica.ingresarPaciente(paciente1);
//            clinica.ingresarPaciente(paciente2);
//            clinica.ingresarPaciente(paciente3);
//            clinica.ingresarPaciente(paciente4);
//            clinica.ingresarPaciente(paciente5);
//            clinica.ingresarPaciente(paciente6);
//            clinica.ingresarPaciente(paciente7);
//            clinica.ingresarPaciente(paciente8);
//
//            clinica.atenderPaciente();
//            clinica.atenderPaciente();
//            clinica.atenderPaciente();
//            clinica.atenderPaciente();
//
////            paciente1 = clinica.egresoPaciente(1);
////            paciente2 = clinica.egresoPaciente(2);
////            paciente3 = clinica.egresoPaciente(3);
//
//            // intervenciones #1
//            ArrayList<ConsultaMedica> consultaMedicas1 = new ArrayList<>();
//            consultaMedicas1.add(new ConsultaMedica(medico1, 2));
//            consultaMedicas1.add(new ConsultaMedica(medico3, 3));
//            ArrayList<Internacion> internacions1 = new ArrayList<>();
//            internacions1.add(new Internacion(HabitacionCompartida.getInstance(), 3));
//            internacions1.add(new Internacion(HabitacionPrivada.getInstance(), 1));
//            internacions1.add(new Internacion(HabitacionTerapiaIntensiva.getInstance(), 1));
//
//            clinica.facturar(paciente1, new GregorianCalendar(2021, Calendar.APRIL, 17), consultaMedicas1, internacions1);
//
//            // intervenciones #2
//            ArrayList<ConsultaMedica> consultaMedicas2 = new ArrayList<>();
//            consultaMedicas2.add(new ConsultaMedica(medico2, 2));
//            consultaMedicas2.add(new ConsultaMedica(medico4, 1));
//            ArrayList<Internacion> internacions2 = new ArrayList<>();
//            internacions2.add(new Internacion(HabitacionPrivada.getInstance(), 1));
//            internacions2.add(new Internacion(HabitacionTerapiaIntensiva.getInstance(), 1));
//
//            clinica.facturar(paciente2, new GregorianCalendar(2022, Calendar.APRIL, 17), consultaMedicas2, internacions2);
////
////            // intervenciones #3
////            ArrayList<ConsultaMedica> consultaMedicas3 = new ArrayList<>();
////            consultaMedicas3.add(new ConsultaMedica(medico2, 1));
////            consultaMedicas3.add(new ConsultaMedica(medico6, 4));
////            ArrayList<Internacion> internacions3 = new ArrayList<>();
////            internacions3.add(new Internacion(HabitacionTerapiaIntensiva.getInstance(), 3));
////
////            clinica.facturar(paciente3, new GregorianCalendar(2021, Calendar.JANUARY, 23), consultaMedicas3, internacions3);
//        }
//    }
//
//    public static void persistirClinica() {
//        PersistenciaXML persistenciaXML = new PersistenciaXML();
//
//        try {
//            persistenciaXML.openOutput("clinica.xml");
////            persistenciaXML.write(DTOConverter.ClinicaDTOFromClinica());
//            persistenciaXML.closeOutput();
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
//    }
}
