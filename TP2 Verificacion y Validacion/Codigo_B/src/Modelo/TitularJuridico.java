package Modelo;

/**
 * @author Taller1
 * 
 * Esta clase representa los titulares de tipo juridico en la empresa.
 *
 */
public class TitularJuridico extends Titular {

	public TitularJuridico(String nombre, int dni, String tipoDePago) {
		super(nombre, dni, tipoDePago);
	}

	@Override
	public String getTipo() {
		return "Juridico";
	}
	
	/**
	 * Este metodo permite calcular el costo final de la factura de un titular juridico. <br>
	 * 
	 * <b>pre:</b> El titular existe (no es null). <br>
	 * <b>post:</b> Se retorna el valor del costo con su respectivo descuento/incremento. <br>
	 */
	@Override
	public double getCostoFinal() {
		double respuesta = this.getCosto();

		if (this.tipoDePago.equals("Efectivo"))
			respuesta -= respuesta * 0.10;
		else if (this.tipoDePago.equals("Cheque"))
			respuesta += respuesta * 0.15;
		else if (this.tipoDePago.equals("Tarjeta"))
			respuesta += respuesta * 0.20;

		return respuesta;
	}
	
	/**
	 * Este metodo permite hacer visible la accion de clonar un titular juridico. <br>
	 * 
	 * <b>pre:</b> El titular existe (no es null). <br>
	 * <b>post:</b> El titular juridico jamas puede ser clonado. <br>
	 * 
	 * @throws java.lang.CloneNotSuportedException SIEMPRE, ya que un titular juridico no es clonable.
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Imposible clonear un Titular Juridico");
	}
}
