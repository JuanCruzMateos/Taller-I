package Modelo;

import Interfaces.IContratacion;

/**
 * @autor Taller1
 * 
 * Clase abstracta que declara el esqueleto para la implementación de los servicios
 * (Internet100 e Internet500. En esta se declaran los métodos que se han de
 * implemetar en sus herederos, cuenta con dos variables privadas (factura y costo)
 * cuyos valores serán seteado por sus hijos. Implementa la interfase IContratación.
 */



public abstract class Contratacion implements IContratacion {
	protected String factura;
	protected double costo;
        
          /**
         *    EL constructor se limita a invocar al constructor de 
         * su padre (Objeto).
        */


	public Contratacion() {

	}

        /**
         *    El método abstracto getFactura de esta clase da cuerpo a la declaración
         * provista por la interfase.
        */
        
	public String getFactura() {
		return factura;
	}
        
        /**
         *    El método abstracto getCosto() de esta clas da cuerpo a la declaración
         * prevista por la interfase.
         */

	public double getCosto() {
		return costo;
	}

}
