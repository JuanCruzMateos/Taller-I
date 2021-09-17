package Factory;


import java.util.Iterator;

import Decorator.DecoratorCelular;
import Decorator.DecoratorTelFijo;
import Decorator.DecoratorTv;
import Excepciones.DomicilioRepetidoException;
import Interfaces.IContratacion;
import Modelo.Domicilio;
import Modelo.Empresa;
import Modelo.Internet100;
import Modelo.Internet500;
import Modelo.Titular;

/**
 * @author Taller1
 * 
 * Esta clase se encarga de instanciar los domicilios de los titulares.
 */
public class DomicilioFactory {
	
	/**
	 *  Este metodo estatico permite crear un nuevo domicilio con su respectivo contrato. <br>
	 *  
	 * <b>pre:</b> El titular del domicilio existe (no es null). <br>
	 * <b>post:</b> El titular tiene un nuevo domicilio con su contrato. <br>
	 * 
	 * @param direccion Es la direccion a la cual se contratar� el servicio, tiene que ser !=null o !=""
	 * @param internet Es el tipo de servicio, debe ser "Internet100" o "Internet500".
	 * @param celular Es un booleano que indica si contrata Celular.
	 * @param telFijo Es un booleano que indica si contrata Telefono Fijo.
	 * @param tv Es un booleano que indica si contrata TV-Cable.
	 * 
	 * @return Retorna un nuevo domicilio que ser� agregado al Titular.
	 * 
	 * @throws DomicilioRepetidoException si el domicilio ingresa ya existe en este o algun otro Titular.
	 */
	public static Domicilio getDomicilio(String direccion, String internet, boolean celular, boolean telFijo, boolean tv) throws DomicilioRepetidoException {
		Domicilio domicilio = null;
		IContratacion contrato = null;

		if (repetido(direccion))
			throw new DomicilioRepetidoException("Ya fue contratado el domicilio: ", direccion);

		if (internet.equals("Internet100"))
			contrato = new Internet100();
		else if (internet.equals("Internet500"))
			contrato = new Internet500();

		if (celular)
			contrato = new DecoratorCelular(contrato);
		if (telFijo)
			contrato = new DecoratorTelFijo(contrato);
		if (tv)
			contrato = new DecoratorTv(contrato);

		domicilio = new Domicilio(direccion, contrato);

		return domicilio;
	}
	
	/**
	 * Este metodo permite saber si una direccion ya esta registrada o no. <br>
	 * <b>pre:</b> El titular del domicilio existe (no es null) al igual que la Empresa. <br>
	 * <b>post:</b> Retorna verdadero o falso segun si la direccion es repetida o no. <br>
	 * 
	 * @param direccion Es la direccion que se buscar� en la Empresa.<br>
	 * 
	 * @return Retorna un boolean que indica si es una direccion repetida o no.
	 */
	private static boolean repetido(String direccion) {
		boolean respuesta = false;

		Iterator<Titular> itTitular = Empresa.getInstance().getTitualares().iterator();
		while (itTitular.hasNext() && !respuesta) {
			Titular titular = itTitular.next();
			Iterator<Domicilio> itDomicilio = titular.getDomicilios().iterator();
			while (itDomicilio.hasNext() && !respuesta) {
				Domicilio domicilio = itDomicilio.next();
				respuesta = domicilio.getDireccion().equals(direccion);
			}

		}
		return respuesta;
	}
}
