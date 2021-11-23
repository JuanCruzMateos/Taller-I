package pacientes;

import habitaciones.IHabitacion;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * @author Interfaz IPaciente en donde se enumeraran los metodos sin implementarse que seran desarrollados en la clase que implemente
 * esta interfaz<br>
 */
public interface IPaciente extends Comparable<IPaciente>, Serializable {


    /**
     * Metodo boolean que toma como parametro un objeto de tipo IPaciente para determinar que objeto segun su rangoEtario se queda con el lugar de la sala de espera privado y quien iria al patio <br>
     * <b> Pre : </b> Objeto paciente distinto de null <br>
     * <b> Post : </b> invoca a otro metodo beat(Rango) para devolver el boolean que se busca
     */
    boolean beats(IPaciente o);


    /**
     * Metodo boolean que toma como parametro un objeto de tipo IPaciente para determinar<br>
     * si el IPaciente como parametro "vence" al rango nino para quedarse con el lugar de la sala de espera privada <br>
     *
     * @return retorna un boolean que determina si el IPaciente pasado como parametro en el metodo beats (IPaciente o) vence o no al nino
     */
    boolean beatsNiño();

    /**
     * Metodo boolean que toma como parametro un objeto de tipo IPaciente para determinar<br>
     * si el IPaciente como parametro "vence" al rango joven para quedarse con el lugar de la sala de espera privada<br>
     *
     * @return retorna un boolean que determina si el IPaciente pasado como parametro en el metodo beats (IPaciente o) vence o no al joven
     */

    boolean beatsJoven();

    /**
     * Metodo boolean que toma como parametro un objeto de tipo IPaciente para determinar<br>
     * si el IPaciente como parametro "vence" al rango mayor para quedarse con el lugar de la sala de espera privada <br>
     *
     * @return retorna un boolean que determina si el IPaciente pasado como parametro en el metodo beats (IPaciente o) vence o no al mayor
     */
    boolean beatsMayor();

    int getNroTurno();

    void setNroTurno(int nroTurno);

    String getNombre();

    String getDNI();

    IHabitacion getHabitacion();

    void setHabitacion(IHabitacion h);

    void setPedido(String pedido);

    /**
     * Metodo int que retorna el numero de historia clinica del paciente<br>
     *
     * @return valor int con el numero de historia
     */

    int getNumHistoria();

    boolean isFacturo();

    void setFacturo(boolean facturo);

    GregorianCalendar getFechaEgreso();

    void setFechaEgreso(GregorianCalendar fechaEgreso);


}