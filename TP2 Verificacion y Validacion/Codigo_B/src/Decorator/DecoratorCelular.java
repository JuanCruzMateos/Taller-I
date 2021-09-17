package Decorator;

/**
 * @autor Taller1
 * 
 * Esta clase deriva de la clase abstracta DecoratorContratacion e implementa
 * los métodos (reales) para el servicio Celular.
 */

import Interfaces.IContratacion;

public class DecoratorCelular extends DecoratorContratacion {

        /**
         *     El constructor DecoratorContratación envia una instancia de la
         * Interfase IContatatación a la clase abstracta como una forma de dar
         * referencia para la implementación de los métodos reales.
        */
	
        public DecoratorCelular(IContratacion encapsulado) {
		super(encapsulado);
	}

        /**
         *     El método getFactura() de esta clase implememta el método abstracto
         * la idea es que nos devuelva un String : ' + Celular'.
        */
        
	@Override
	public String getFactura() {
		return super.getFactura() + " + Celular";
	}

        /**
         *      El método getCosto() de esta clase implementa el método abstracto 
         * en este caso no devuelve el valor 300.
         */
        
	@Override
	public double getCosto() {
		return super.getCosto() + 300;
	}

}
