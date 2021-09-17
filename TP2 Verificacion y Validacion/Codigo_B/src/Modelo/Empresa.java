package Modelo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Taller1
 * 
 * Clase que representa la Empresa que contiene todos los titulares con sus contrataciones.
 * los contiene en un ArrayList Titulares.
 */

public class Empresa {
	private static Empresa instance = null;
	private ArrayList<Titular> titulares = new ArrayList<Titular>();

	private Empresa() {

	}
	
	/* ----------------
	 * PATRON SINGLETON
	 * ----------------
	 */
	public static Empresa getInstance() {
		if (instance == null)
			instance = new Empresa();
		return instance;
	}

    /**
     *
     * @return
     * retorna el array con los titulares.
     */
        
    public ArrayList<Titular> getTitualares() {
		return titulares;
	}
	
	/**
	 * Este metodo permite agregar un titular a la empresa. <br>
	 * 
	 * <b>pre:</b> La empresa existe (no es null). <br>
	 * <b>post:</b> Se añade un nuevo titular al ArrayList. <br>
	 * 
	 * @param titular Es el titular que será agregado, este no debe ser null
	 */
	public void addTitular(Titular titular) {
		this.titulares.add(titular);
	}
	
	/**
	 * Este metodo permite solicitar un duplicado de un titular por medio del metodo clone(). <br>
	 * Si el titular es de tipo juridico, este metodo es el encargado de atrapar la excepcion e informar al usuario
	 * que es imposible clonar a un titular juridico. <br>
	 * 
	 * <b>pre:</b> La empresa existe (no es null) y tambien el titular a duplicar. <br>
	 * <b>post:</b> Se retornara un clon del titular o null, dependiendo si este es fisico o juridico respectivamente. <br>
	 *  
	 * @param nroIdent Es el numero de identacion del titular que se desea clonar, este debe ser mayor que 0 y menor que el
	 * largo del ArrayList.
	 * 
	 * @return Retorna una clonacion del Titular solicitado
	 */
	public Titular solicitaDuplicado(int nroIdent) {
		Titular clonado = null;
		try {
			clonado = (Titular) this.getTitualares().get(nroIdent).clone();
		} catch (CloneNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		return clonado;
	}
	
	/**
	 * Este metodo permite mostrar por pantalla todos los titulares asociados a la empresa, junto con sus facturas y los
	 * costos base y final. <br>
	 * 
	 * <b>pre:</b> La empresa existe (no es null). <br>
	 * <b>post:</b> Se muestra el detalle completo de la empresa y sus titulares por pantalla. <br>
	 */
	public void detalle() {
		Iterator<Titular> it = titulares.iterator();
		while (it.hasNext()) {
			Titular t = it.next();
			t.imprimirFactura();
		}
	}

}
