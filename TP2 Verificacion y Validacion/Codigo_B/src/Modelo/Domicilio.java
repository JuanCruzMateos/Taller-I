package Modelo;

import Interfaces.IContratacion;

/**
 * @autor Taller1
 * 
 * Clase Domicilio que especifica uno de los domcilios del cliente y los servicios
 * contratados asociados a dicho domicilio.
 */

public class Domicilio {
	private String direccion;
	IContratacion contrato;

    /**
     *
     * @param direccion : String con la dirección del cliente.
     * @param contrato : una instancia de contratación sea un hijo de 
     * DecoratoComtratacion o Contratación.
     * No se validan los parametros de entrada.
     */
        
    public Domicilio(String direccion, IContratacion contrato) {
		this.direccion = direccion;
		this.contrato = contrato;
	}

    /**
     *
     * @return
     * retorna la dirección
     */
    public String getDireccion() {
		return direccion;
	}

    /**
     *
     * @return
     * retorna el contrato (hay que castearlo)
     */
  
    public IContratacion getContrato() {
		return contrato;
	}

    /**
     *
     * @return
     * 
     * retorna un string con el servivio y su costo
     */
    
    @Override
	public String toString() {
		return direccion + " - " + contrato.getFactura() + " = $" + contrato.getCosto();
	}

}
