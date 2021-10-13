package sistema.personas.medicos.factory;

import sistema.excepciones.*;
import sistema.personas.medicos.IMedico;
import sistema.personas.medicos.decorators.DecoratorDoctor;
import sistema.personas.medicos.decorators.DecoratorMagister;
import sistema.personas.medicos.decorators.DecoratorPermanente;
import sistema.personas.medicos.decorators.DecoratorTemporario;
import sistema.personas.medicos.especialidades.Cirujano;
import sistema.personas.medicos.especialidades.Clinico;
import sistema.personas.medicos.especialidades.Pediatra;


/**
 * Clase MedicoFactory.<br>
 * <b>Pre:</b> Todos los medicos de la clinicatienen un titulo de posgrado.<br>
 * <b>Post:</b> Se crea un objeto de tipo medico con todos los decorators implementados. O lanza excepciones si se ingresan datos incorrectos.<br>
 * Implementa patron Factory para la creacion de un medico.<br>
 */
public class MedicoFactory {
    public static IMedico getMedico(String especialidad, String posgrado, String contratacion, String nombre,
                                    String apellido, String direccion, String ciudad, int telefono, int dni, int matricula)
            throws InformacionPersonalNoValidaException, EspecialidadNoValidaException,
            PosgradoNoValidoException, ContratacionNoValidaException {
        IMedico medicoBasico = null;
        IMedico medicoConPosgrado = null;
        IMedico medicoConContratacion = null;
        boolean infoPersonalValida = nombre != null && apellido != null && direccion != null && ciudad != null &&
                !nombre.equals("") && !apellido.equals("") && !direccion.equals("") && !ciudad.equals("") &&
                telefono > 0 && dni > 0 && matricula > 0;

        if (!infoPersonalValida)
            throw new InformacionPersonalNoValidaException("Los campos con los datos personales no son correctos.");
        else {
            if (especialidad.equalsIgnoreCase("clinica"))
                medicoBasico = new Clinico(nombre, apellido, direccion, ciudad, telefono, dni, matricula);
            else if (especialidad.equalsIgnoreCase("cirugia"))
                medicoBasico = new Cirujano(nombre, apellido, direccion, ciudad, telefono, dni, matricula);
            else if (especialidad.equalsIgnoreCase("pediatria"))
                medicoBasico = new Pediatra(nombre, apellido, direccion, ciudad, telefono, dni, matricula);
            else
                throw new EspecialidadNoValidaException("La especialidad no es valida.", especialidad);

            // si se ejecuta este if es porque no se lanzo una excepcion
            if (posgrado.equalsIgnoreCase("doctor"))
                medicoConPosgrado = new DecoratorDoctor(medicoBasico);
            else if (posgrado.equalsIgnoreCase("magister"))
                medicoConPosgrado = new DecoratorMagister(medicoBasico);
            else
                throw new PosgradoNoValidoException("El posgrado no es valido.", posgrado);

            // si se ejecuta este if es porque no se lanzo una excepcion
            if (contratacion.equalsIgnoreCase("permanente"))
                medicoConContratacion = new DecoratorPermanente(medicoConPosgrado);
            else if (contratacion.equalsIgnoreCase("temporario"))
                medicoConContratacion = new DecoratorTemporario(medicoConPosgrado);
            else
                throw new ContratacionNoValidaException("El tipo de contratacion no es valido.", contratacion);
            // si no ocure ninguna exception devuelvo el medico creado con todos los campos
            return medicoConContratacion;
        }
    }
}
