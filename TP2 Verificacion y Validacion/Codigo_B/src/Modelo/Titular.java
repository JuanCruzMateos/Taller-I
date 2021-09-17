package Modelo;

import java.util.ArrayList;
import java.util.Iterator;

import Excepciones.DomicilioRepetidoException;
import Factory.DomicilioFactory;

/**
 * @author Taller1
 * 
 * Esta clase representa los titulares de la Empresa, los cuales pueden ser de tipo Fisico o Juridico.
 * la clase mantiene un array (domicilios) con los domicilios asociados al Titular.
 * 
 */
public abstract class Titular implements Cloneable {
	private static int nroActual = 0;
	protected int nroIdentacion;
	protected String nombre;
	protected int dni;
	protected String tipoDePago;
	protected ArrayList<Domicilio> domicilios = new ArrayList<Domicilio>();

    /**
     *      Crea un titular asignando los siguientes atributos:
     * @param nombre : String nombre del titular (no valida)
     * @param dni : Entero con el DNI (no valida)
     * @param tipoDePago : String con el tipoDePago (no valida)
     * Adicionalmente asigna un número de Identacion correlativo (nroIdentacion)
     * este comienza desde cero.
     */
        
    public Titular(String nombre, int dni, String tipoDePago) {
		this.nombre = nombre;
		this.dni = dni;
		this.tipoDePago = tipoDePago;
		this.nroIdentacion = nroActual++;
	}

    /**
     *
     * @return
     * devuelve el numero de identación
     */
    
    public int getNroIdentacion() {
		return nroIdentacion;
	}

    /**
     *
     * @return
     * devuelve el nombre
     */
    public String getNombre() {
		return nombre;
	}

    /**
     *
     * @return
     * devuelve el DNI
     */
    public int getDni() {
		return dni;
	}

    /**
     *
     * @return
     * devuelve el tipo de pago.
     */
    
    public String getTipoDePago() {
		return tipoDePago;
	}

    /**
     *
     * @return
     * retorna el arreglo de domicilios;
     */
    
    public ArrayList<Domicilio> getDomicilios() {
		return domicilios;
	}
	
	/**
	 * Este metodo cambia el tipo de pago del titular.<br>
	 * 
	 * <b>pre:</b> El titular existe (no es null). <br>
	 * <b>post:</b> Se acambia el tipo de pago. <br>
	 * 
	 * @param tipoDePago Es el tipo de pago nuevo, puede ser "Efectico", "Cheque" o "Tarjeta"
	 */
	public void setTipoDePago(String tipoDePago) {
		this.tipoDePago = tipoDePago;
	}
	
	/**
	 * Este metodo agrega un domicilio al ArrayList de domicilios de un Titular, invocando al metodo estatico getDomicilio
	 * ubicado en la clase DomicilioFactory, la cual es la encargada de crear un domicilio y de lanzar una excepcion si el
	 * domicilio ya existe.<br>
	 * La excepcion es atrapada en el catch y se informa por pantalla si no es posible agregar la direccion.<br>
	 * 
	 * <b>pre:</b> El titular existe (no es null). <br>
	 * <b>post:</b> Se agrega un domicilio o se muestra por pantalla que es repetido si es el caso. <br>
	 * 
	 * @param direccion Es la direccion a la cual se contratará el servicio, tiene que ser !=null o !=""
	 * @param internet Es el tipo de servicio, debe ser "Internet100" o "Internet500".
	 * @param celular Es un booleano que indica si contrata Celular.
	 * @param telFijo Es un booleano que indica si contrata Telefono Fijo.
	 * @param tv Es un booleano que indica si contrata TV-Cable.
	 */
	public void addDomicilio(String direccion, String internet, boolean celular, boolean telFijo, boolean tv) {
		try {
			this.domicilios.add(DomicilioFactory.getDomicilio(direccion, internet, celular, telFijo, tv));
		} catch (DomicilioRepetidoException e) {
			System.out.println(e.getMessage()+e.getDirecDuplicada());
		}
	}
	
	/**
	 * Este metodo permite calcular el costo base total que debera pagar un Titular. <br>
	 * 
	 * <b>pre:</b> El titular existe (no es null). <br>
	 * <b>post:</b> Se retorna el valor total de la suma de cada factura de contratacion. <br>
	 * 
	 * @return Retorna el costo base de la factura de un Titular
	 */
	public double getCosto() {
		double respuesta = 0;
		Iterator<Domicilio> it = this.domicilios.iterator();
		while (it.hasNext()) {
			Domicilio domicilio = it.next();
			respuesta += domicilio.getContrato().getCosto();
		}

		return respuesta;
	}

	public abstract String getTipo();

	public abstract double getCostoFinal();
	
	/*
	 * ---------------
	 * PATRON TEMPLETE
	 * ---------------
	 */
	public void imprimirFactura() {
		Iterator<Domicilio> it = this.getDomicilios().iterator();
		System.out.println("*************************************** FACTURA ***************************************");
		System.out.println("Cliente Nro:" + this.nroIdentacion);
		System.out.println("Titular:" + this.getNombre());
		System.out.println("DNI:" + this.getDni());
		System.out.println("Tipo:" + this.getTipo());
		System.out.println("Forma de pago:" + this.getTipoDePago());
		System.out.println("Domicilios:");
		while (it.hasNext()) {
			Domicilio domicilio = it.next();
			System.out.println("	-" + domicilio);
		}
		System.out.println("");
		System.out.println("Costo base: $" + this.getCosto());
		System.out.println("Costo final: $" + this.getCostoFinal());
		System.out.println("");
		System.out.println("***************************************************************************************");
		System.out.println("");
	}
	
	/**
	 *Este metodo permite hacer visible el metodo clone(). <br>
	 * 
	 * <b>pre:</b> El titular existe (no es null). <br>
	 * <b>post:</b> Si el titular es fisico se retornara un clon del mismo, en caso de ser juridico habra una exception. <br>
	 * 
	 * @throws java.lang.CloneNotSuportedException solo en el caso de que el titular sea juridico.
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
