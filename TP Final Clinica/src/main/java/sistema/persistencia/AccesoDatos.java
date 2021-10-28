package sistema.persistencia;

import sistema.atencion.HistoriaClinica;
import sistema.clinica.Clinica;
import sistema.excepciones.ContratacionNoValidaException;
import sistema.excepciones.EspecialidadNoValidaException;
import sistema.excepciones.InformacionPersonalNoValidaException;
import sistema.excepciones.PosgradoNoValidoException;
import sistema.facturacion.ConsultaMedica;
import sistema.facturacion.Internacion;
import sistema.habitaciones.Habitacion;
import sistema.habitaciones.HabitacionCompartida;
import sistema.habitaciones.HabitacionPrivada;
import sistema.habitaciones.HabitacionTerapiaIntensiva;
import sistema.persistencia.dto.ClinicaDTO;
import sistema.personas.medicos.IMedico;
import sistema.personas.pacientes.Paciente;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

/**
 * Clase encargada de la pesistencia de los datos.<br>
 */
public class AccesoDatos {
    private static final String FILENAME = "clinica.xml";

    public static String getFILENAME() {
        return FILENAME;
    }

    public static ClinicaDTO despersistirClinica() throws IOException {
        PersistenciaXML io = new PersistenciaXML();
        ClinicaDTO dto;

        io.openInput(FILENAME);
        dto = (ClinicaDTO) io.read();
        io.closeInput();
        return dto;
    }

    public static void persistirClinica(ClinicaDTO clinicaDTO) throws IOException {
        PersistenciaXML persistenciaXML = new PersistenciaXML();

        persistenciaXML.openOutput(FILENAME);
        persistenciaXML.write(clinicaDTO);
        persistenciaXML.closeOutput();
    }

    public static void initClinica() {
        Habitacion.setCostoAsignacion(100);
        HabitacionCompartida.getInstance().setCostoHabCompartida(10);
        HabitacionPrivada.getInstance().setCostoHabPrivada(20);
        HabitacionTerapiaIntensiva.getInstance().setCostoHabTerapiaIntensiva(30);

        Clinica clinica = Clinica.getInstance();
        clinica.setNombre("HIGA");
        clinica.setCiudad("Mar del Plata");
        clinica.setDireccion("Juan B. Justo 10000");
        clinica.setTelefono(4827593);
        System.out.println(clinica);
        System.out.println("*************************************************************************************");

        try {
            clinica.agregarMedico("clinica", "doctor", "permanente", "Rene", "Favaloro", "Alverar 3101", "Buenos Aires", "369258", 8125936, 1);
            clinica.agregarMedico("pediatria", "doctor", "permanente", "Carlos", "Rivas", "Libertador 1401", "Buenos Aires", "4852963", 272589, 2);
            clinica.agregarMedico("clinica", "magister", "temporario", "Marta", "Perez", "Diagonal 3 2589", "La Plata", "155937825", 853259, 3);
            clinica.agregarMedico("cirugia", "magister", "temporario", "Lucia", "Rodriguez", "Mitre 1479", "Mar del Plata", "369258", 15236, 4);
            clinica.agregarMedico("cirugia", "doctor", "temporario", "Lucas", "Gonzales", "Salta 936", "Mar del Plata", "369258", 78932, 5);
            clinica.agregarMedico("pediatria", "doctor", "permanente", "Carolina", "Sanchez", "Falucho 3705", "Buenos Aires", "369258", 93624, 6);
        } catch (InformacionPersonalNoValidaException e) {
            System.out.println(e.getMessage());
        } catch (EspecialidadNoValidaException e) {
            System.out.println(e.getMessage() + " Especialidad invalida = " + e.getEspecialidadInvalida());
        } catch (PosgradoNoValidoException e) {
            System.out.println(e.getMessage() + " Posgrado Invalido = " + e.getPosgradoInvalido());
        } catch (ContratacionNoValidaException e) {
            System.out.println(e.getMessage() + " Contratacion Invalida = " + e.getContratacionInvalida());
        }

        IMedico medico1 = clinica.getMedico(1);
        IMedico medico2 = clinica.getMedico(2);
        IMedico medico3 = clinica.getMedico(3);
        IMedico medico4 = clinica.getMedico(4);
        IMedico medico5 = clinica.getMedico(5);
        IMedico medico6 = clinica.getMedico(6);

        System.out.println(medico1);
        System.out.println(medico2);
        System.out.println(medico3);
        System.out.println(medico4);
        System.out.println(medico5);
        System.out.println(medico6);
        System.out.println("*************************************************************************************");

        Paciente paciente1 = clinica.altaPaciente("Juan Cruz", "Mateos", "Almafuerte 2356", "Mar del Plata", "101", 1, "joven");
        Paciente paciente2 = clinica.altaPaciente("Camila", "Ezama", "Formosa 2014", "Mar del Plata", "102", 2, "nino");
        Paciente paciente3 = clinica.altaPaciente("Noelia", "Echeverria", "Matheu 3952", "Mar del Plata", "103", 3, "mayor");
        Paciente paciente4 = clinica.altaPaciente("Sebastian", "Bengoa", "Quintana 1016", "Mar del Plata", "104", 4, "joven");
        Paciente paciente5 = clinica.altaPaciente("Candela", "Ramos", "Primera Junta 1006", "Mar del Plata", "105", 5, "nino");
        Paciente paciente6 = clinica.altaPaciente("Marcos", "Jimenez", "Roca 1782", "Mar del Plata", "106", 6, "mayor");
        Paciente paciente7 = clinica.altaPaciente("Lucas", "Rodriguez", "Paso 3691", "Mar del Plata", "107", 7, "joven");

        Paciente paciente8 = clinica.altaPaciente("Sebastian", "Bengoa", "Quintana 1016", "Mar del Plata", "104", 4, "joven");

        System.out.println(paciente1);
        System.out.println(paciente2);
        System.out.println(paciente3);
        System.out.println(paciente4);
        System.out.println(paciente5);
        System.out.println(paciente6);
        System.out.println(paciente7);
        System.out.println(paciente8);
        System.out.println("Paciente 4 == Paciente 8: " + (paciente4 == paciente8)); // no permite duplicados
        System.out.println("*************************************************************************************");

        clinica.ingresarPaciente(paciente1);
        clinica.ingresarPaciente(paciente2);
        clinica.ingresarPaciente(paciente3);
        clinica.ingresarPaciente(paciente4);
        clinica.ingresarPaciente(paciente5);
        clinica.ingresarPaciente(paciente6);
        clinica.ingresarPaciente(paciente7);
        clinica.ingresarPaciente(paciente8);
        System.out.println("*************************************************************************************");
        System.out.println(clinica.estadoDeLaClinica());
        System.out.println(paciente1);
        System.out.println(paciente2);
        System.out.println(paciente3);
        System.out.println(paciente4);
        System.out.println(paciente5);
        System.out.println(paciente6);
        System.out.println(paciente7);

        clinica.atenderSiguentePaciente();
        clinica.atenderSiguentePaciente();
        clinica.atenderSiguentePaciente();
        System.out.println("*************************************************************************************");
        System.out.println(clinica.estadoDeLaClinica());
        System.out.println("*************************************************************************************");

        paciente1 = clinica.egresoPaciente(1);
        paciente2 = clinica.egresoPaciente(2);
        paciente3 = clinica.egresoPaciente(3);
        System.out.println(clinica.estadoDeLaClinica());

        for (Map.Entry<Paciente, HistoriaClinica> entry : Clinica.getInstance().getHistoriasClinicasIterator()) {
//            System.out.println(entry.getKey().getNombre() + ", dni=" + entry.getKey().getDni());
            System.out.println(entry.getValue());
        }

        System.out.println(paciente1.getNombre());
        HistoriaClinica hc =  Clinica.getInstance().getModuloAtencion().getHistoriaClinicaPaciente(paciente1);
        System.out.println(hc);
//         intervenciones #1
//        ArrayList<ConsultaMedica> consultaMedicas1 = new ArrayList<>();
//        consultaMedicas1.add(new ConsultaMedica(medico1, 2));
//        consultaMedicas1.add(new ConsultaMedica(medico3, 3));
//        ArrayList<Internacion> internacions1 = new ArrayList<>();
//        internacions1.add(new Internacion(HabitacionCompartida.getInstance(), 3));
//        internacions1.add(new Internacion(HabitacionPrivada.getInstance(), 1));
//        internacions1.add(new Internacion(HabitacionTerapiaIntensiva.getInstance(), 1));
//        clinica.facturar(paciente1, new GregorianCalendar(2018, Calendar.MARCH, 17), consultaMedicas1, internacions1);


        // con historias clinicas
//        clinica.agregarConsultaMedicaPaciente(paciente1, new ConsultaMedica(medico3, 3));
//        clinica.agregarConsultaMedicaPaciente(paciente1, new ConsultaMedica(medico1, 2));
        clinica.agregarInternacionPaciente(paciente1, new Internacion(HabitacionCompartida.getInstance(), 3));
        clinica.agregarInternacionPaciente(paciente1, new Internacion(HabitacionPrivada.getInstance(), 1));
        clinica.agregarInternacionPaciente(paciente1, new Internacion(HabitacionTerapiaIntensiva.getInstance(), 1));
        clinica.facturar(paciente1, new GregorianCalendar(2018, Calendar.MARCH, 17));

//         intervenciones #2
//        ArrayList<ConsultaMedica> consultaMedicas2 = new ArrayList<>();
//        consultaMedicas2.add(new ConsultaMedica(medico2, 2));
//        consultaMedicas2.add(new ConsultaMedica(medico4, 1));
//        ArrayList<Internacion> internacions2 = new ArrayList<>();
//        internacions2.add(new Internacion(HabitacionPrivada.getInstance(), 1));
//        internacions2.add(new Internacion(HabitacionTerapiaIntensiva.getInstance(), 1));
//        clinica.facturar(paciente2, new GregorianCalendar(2019, Calendar.APRIL, 15), consultaMedicas2, internacions2);

        // con historias clinicas
        clinica.agregarConsultaMedicaPaciente(paciente2, new ConsultaMedica(medico2, 2));
        clinica.agregarConsultaMedicaPaciente(paciente2, new ConsultaMedica(medico4, 1));
        clinica.agregarInternacionPaciente(paciente2, new Internacion(HabitacionPrivada.getInstance(), 1));
        clinica.agregarInternacionPaciente(paciente2, new Internacion(HabitacionTerapiaIntensiva.getInstance(), 1));
        clinica.facturar(paciente2, new GregorianCalendar(2019, Calendar.APRIL, 15));

//        // intervenciones #3
//        ArrayList<ConsultaMedica> consultaMedicas3 = new ArrayList<>();
//        consultaMedicas3.add(new ConsultaMedica(medico2, 1));
//        consultaMedicas3.add(new ConsultaMedica(medico6, 4));
//        ArrayList<Internacion> internacions3 = new ArrayList<>();
//        internacions3.add(new Internacion(HabitacionTerapiaIntensiva.getInstance(), 3));
//        clinica.facturar(paciente3, new GregorianCalendar(2020, Calendar.MAY, 23), consultaMedicas3, internacions3);

        // con historias clinicas
        clinica.agregarConsultaMedicaPaciente(paciente3, new ConsultaMedica(medico2, 1));
        clinica.agregarConsultaMedicaPaciente(paciente3, new ConsultaMedica(medico6, 4));
        clinica.agregarInternacionPaciente(paciente3, new Internacion(HabitacionTerapiaIntensiva.getInstance(), 3));
        clinica.facturar(paciente3, new GregorianCalendar(2020, Calendar.MAY, 23));


        System.out.println(clinica.getDetalleFactura(1));
        System.out.println(clinica.getDetalleFactura(2));
        System.out.println(clinica.getDetalleFactura(3));

        System.out.println(clinica.getReporteMedico(medico1, new GregorianCalendar(2015, Calendar.FEBRUARY, 1), new GregorianCalendar()));
        System.out.println(clinica.getReporteMedico(medico2, new GregorianCalendar(2020, Calendar.FEBRUARY, 1), new GregorianCalendar()));
        System.out.println(clinica.getReporteMedico(medico3, new GregorianCalendar(2020, Calendar.FEBRUARY, 1), new GregorianCalendar()));
        System.out.println(clinica.getReporteMedico(medico4, new GregorianCalendar(2020, Calendar.FEBRUARY, 1), new GregorianCalendar()));
        System.out.println(clinica.getReporteMedico(medico5, new GregorianCalendar(2020, Calendar.FEBRUARY, 1), new GregorianCalendar()));
        System.out.println(clinica.getReporteMedico(medico6, new GregorianCalendar(2020, Calendar.FEBRUARY, 1), new GregorianCalendar()));

        System.out.println(clinica.estadoDeLaClinica());
        clinica.atenderSiguentePaciente();
        clinica.atenderSiguentePaciente();
        clinica.atenderSiguentePaciente();
        clinica.atenderSiguentePaciente();
//        clinica.atenderPaciente(); // no tiene efecto
        clinica.ingresarPaciente(clinica.altaPaciente("Pepe", "Argento", "Flores 1234", "Buenos Aires", "123654", 325863, "Mayor"));
        System.out.println(clinica.estadoDeLaClinica());

        paciente4 = clinica.egresoPaciente(4);
        paciente5 = clinica.egresoPaciente(5);
        paciente6 = clinica.egresoPaciente(6);

        System.out.println(clinica.estadoDeLaClinica());

//        // intervenciones #4
//        ArrayList<ConsultaMedica> consultaMedicas4 = new ArrayList<>();
//        consultaMedicas4.add(new ConsultaMedica(medico5, 2));
//        consultaMedicas4.add(new ConsultaMedica(medico3, 3));
//        ArrayList<Internacion> internacions4 = new ArrayList<>();
//        internacions4.add(new Internacion(HabitacionPrivada.getInstance(), 5));
//        internacions4.add(new Internacion(HabitacionTerapiaIntensiva.getInstance(), 1));
//        clinica.facturar(paciente4, new GregorianCalendar(2021, Calendar.JULY, 12), consultaMedicas4, internacions4);

        // con historias clinicas
        clinica.agregarConsultaMedicaPaciente(paciente4, new ConsultaMedica(medico5, 2));
        clinica.agregarConsultaMedicaPaciente(paciente4, new ConsultaMedica(medico3, 3));
        clinica.agregarInternacionPaciente(paciente4, new Internacion(HabitacionPrivada.getInstance(), 5));
        clinica.agregarInternacionPaciente(paciente4, new Internacion(HabitacionTerapiaIntensiva.getInstance(), 1));
        clinica.facturar(paciente4, new GregorianCalendar(2021, Calendar.JULY, 12));

//        // intervenciones #5
//        ArrayList<ConsultaMedica> consultaMedicas5 = new ArrayList<>();
//        consultaMedicas5.add(new ConsultaMedica(medico2, 2));
//        consultaMedicas5.add(new ConsultaMedica(medico6, 1));
//        ArrayList<Internacion> internacions5 = new ArrayList<>();
//        internacions5.add(new Internacion(HabitacionPrivada.getInstance(), 10));
//        clinica.facturar(paciente5, new GregorianCalendar(2021, Calendar.AUGUST, 26), consultaMedicas5, internacions5);

        // con historias clinicas
        clinica.agregarConsultaMedicaPaciente(paciente5, new ConsultaMedica(medico2, 2));
        clinica.agregarConsultaMedicaPaciente(paciente5, new ConsultaMedica(medico6, 1));
        clinica.agregarInternacionPaciente(paciente5, new Internacion(HabitacionPrivada.getInstance(), 10));
        clinica.facturar(paciente5, new GregorianCalendar(2021, Calendar.AUGUST, 26));

//        // intervenciones #6
//        ArrayList<ConsultaMedica> consultaMedicas6 = new ArrayList<>();
//        consultaMedicas6.add(new ConsultaMedica(medico2, 1));
//        consultaMedicas6.add(new ConsultaMedica(medico6, 4));
//        ArrayList<Internacion> internacions6 = new ArrayList<>();
//        internacions6.add(new Internacion(HabitacionTerapiaIntensiva.getInstance(), 2));
//        clinica.facturar(paciente6, new GregorianCalendar(2021, Calendar.OCTOBER, 27), consultaMedicas6, internacions6);

        // con historias clinicas
        clinica.agregarConsultaMedicaPaciente(paciente6, new ConsultaMedica(medico2, 1));
        clinica.agregarConsultaMedicaPaciente(paciente6, new ConsultaMedica(medico6, 4));
        clinica.agregarInternacionPaciente(paciente6, new Internacion(HabitacionTerapiaIntensiva.getInstance(), 2));
        clinica.facturar(paciente6, new GregorianCalendar(2021, Calendar.OCTOBER, 27));

        System.out.println(clinica.getDetalleFactura(4));
        System.out.println(clinica.getDetalleFactura(5));
        System.out.println(clinica.getDetalleFactura(6));

        System.out.println(clinica.getReporteMedico(medico1, new GregorianCalendar(2017, Calendar.FEBRUARY, 1), new GregorianCalendar(2021, Calendar.DECEMBER, 31)));
        System.out.println(clinica.getReporteMedico(medico2, new GregorianCalendar(2017, Calendar.FEBRUARY, 1), new GregorianCalendar(2021, Calendar.DECEMBER, 31)));
        System.out.println(clinica.getReporteMedico(medico3, new GregorianCalendar(2017, Calendar.FEBRUARY, 1), new GregorianCalendar(2021, Calendar.DECEMBER, 31)));
        System.out.println(clinica.getReporteMedico(medico4, new GregorianCalendar(2017, Calendar.FEBRUARY, 1), new GregorianCalendar(2021, Calendar.DECEMBER, 31)));
        System.out.println(clinica.getReporteMedico(medico5, new GregorianCalendar(2017, Calendar.FEBRUARY, 1), new GregorianCalendar(2021, Calendar.DECEMBER, 31)));
        System.out.println(clinica.getReporteMedico(medico6, new GregorianCalendar(2017, Calendar.FEBRUARY, 1), new GregorianCalendar(2021, Calendar.DECEMBER, 31)));

        System.out.println(clinica.estadoDeLaClinica());
        clinica.ingresarPaciente(clinica.altaPaciente("Paola", "Argento", "Flores 1234", "Buenos Aires", "123654", 159327258, "Nino"));
        clinica.atenderSiguentePaciente();
        Paciente paciente9 = clinica.egresoPaciente(7);

        clinica.agregarInternacionPaciente(paciente9, new Internacion(HabitacionPrivada.getInstance(), 15));
        System.out.println(clinica.estadoDeLaClinica());
        clinica.atenderSiguentePaciente();
        System.out.println(clinica.estadoDeLaClinica());
    }
}
