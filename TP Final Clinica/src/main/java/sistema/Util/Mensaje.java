package sistema.Util;

public enum Mensaje {
	MEDICO("Medico"), NUMEROCONSULTAS("Numero Consultas"), ACEPTARCONSULTA("Añadir consulta"), HABITACION("Habitacion"),
	DIASINTERNACION("Dias Internacion"), ACEPTARINTERNACION("Añadir internacion"),
	FINALIZARFACTURA("Finalizar Factura"), COMENZARFACTURA("Comenzar Factura"), FACTURACION("Facturacion"),
	PACIENTESATENCION("Pacientes en atencion");

	private String valor;

	private Mensaje(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
