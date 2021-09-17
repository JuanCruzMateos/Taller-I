package Interfaces;

/**
 * @autor Taller1
 * 
 * Esta interface declara los métodos getFactura() y getCosto() que han de implementarse
 * en las clase que pretenden implementar la interfase.
 */

public interface IContratacion {

    /**
    *   El método getFactura() es abstracto, su implementación debe devolver un String que 
    * representa la factura del servicio contratado.
    */
	String getFactura();
    
    /**
    *   El método getCosto() es abstracto, su implementación debe devolver un double con
    * el precio del servicio contratado.
    */
 
	double getCosto();

}
