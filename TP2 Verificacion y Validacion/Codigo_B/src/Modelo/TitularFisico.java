package Modelo;

import java.util.ArrayList;

/**
 * @author Taller1
 * 
 * Esta clase representa los titulares de tipo fisico en la empresa.
 *
 */
public class TitularFisico extends Titular {

	public TitularFisico(String nombre, int dni, String tipoDePago) {
		super(nombre, dni, tipoDePago);
	}

	@Override
	public String getTipo() {
		return "Fisico";
	}
	
	/**
	 * Este metodo permite calcular el costo final de la factura de un titular fisico. <br>
	 * 
	 * <b>pre:</b> El titular existe (no es null). <br>
	 * <b>post:</b> Se retorna el valor del costo con su respectivo descuento/incremento. <br>
	 */
	@Override
	public double getCostoFinal() {
		double respuesta = this.getCosto();

		if (this.tipoDePago.equals("Efectivo"))
			respuesta -= respuesta * 0.20;
		else if (this.tipoDePago.equals("Cheque"))
			respuesta += respuesta * 0.10;

		return respuesta;
	}
	
	/**
	 * Este metodo permite hacer visible la accion de clonar un titular fisico. <br>
	 * 
	 * <b>pre:</b> El titular existe (no es null). <br>
	 * <b>post:</b> El titular siempre será clonado con exito. <br>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object clone() {
		TitularFisico clonado = null;
		try {
			clonado = (TitularFisico) super.clone();
			clonado.domicilios = (ArrayList<Domicilio>) this.domicilios.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clonado;
	}
}
