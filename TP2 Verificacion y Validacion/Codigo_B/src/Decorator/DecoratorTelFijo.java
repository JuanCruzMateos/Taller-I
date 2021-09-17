package Decorator;

/**
 * @autor Taller1
 * 
 * Esta clase deriva de la clase abstracta DecoratorContratacion e implementa
 * los métodos (reales) para el servicio Teléfono FIjo.
 */

import Interfaces.IContratacion;

public class DecoratorTelFijo extends DecoratorContratacion {

    /**
         *     El constructor DecoratorContratación envia una instancia de la
         * Interfase IContatatación a la clase abstracta como una forma de dar
         * referencia para la implementación de los métodos reales.
        */
	public DecoratorTelFijo(IContratacion encapsulado) {
		super(encapsulado);
	}

         /**
         *     El método getFactura() de esta clase implememta el método abstracto
         * la idea es que nos devuelva un String : ' + Telefono Fijo'.
        */
        
	@Override
	public String getFactura() {
		return super.getFactura() + " + Telefono Fijo";
	}
        
        /**
         *     El método getCosto() de esta clase implementa el método abstracto 
         * en este caso no devuelve el valor 200.
         */
        
	@Override
	public double getCosto() {
		return super.getCosto() + 200;
	}
}
