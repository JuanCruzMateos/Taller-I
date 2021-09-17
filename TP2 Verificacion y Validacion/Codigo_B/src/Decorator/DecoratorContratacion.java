package Decorator;

/**
 * @autor Taller1
 * 
 * Clase abstracta que declara el esqueleto para la implementación de los servicios
 * (Celular, Telefono FIjo y TV. En esta se declaran los métodos que se han de
 * implemetar en sus herederos.
 * Implementa la interfase IContratación.
 */

import Interfaces.IContratacion;

public abstract class DecoratorContratacion implements IContratacion 
{
    
	protected IContratacion encapsulado;
        
        /**
         *     El constructor DecoratorContratación incorpora una instancia de la
         * Interfase IContatatación para luego dar cuerpo (abstracto) a los métodos 
         * de dicha interfase.
        */

	public DecoratorContratacion(IContratacion encapsulado) {
		this.encapsulado = encapsulado;
	}
        
        /**
         *    El método abstracto getFactura de esta clase da cuerpo a la declaración
         * provista por la interfase.
        */
        
	@Override
	public String getFactura() {
		return encapsulado.getFactura();
	}
        
        /**
         *    El método abstracto getCosto() de esta clas da cuerpo a la declaración
         * prevista por la interfase.
         */
        
	@Override
	public double getCosto() {
		return encapsulado.getCosto();
	}

}
