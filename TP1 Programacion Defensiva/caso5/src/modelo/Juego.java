package modelo;


import java.util.Observable;
import java.util.Random;

import exceptions.numeroNoValidoException;

/**
 * 
 * @author Noelia
 * Clase Juego aplica patron observable
 *
 */

@SuppressWarnings("deprecation")
public class Juego extends Observable{

	private int numeroMisterioso;
	private int cantidadIntentos=-1;
	private String estado="juego sin iniciar";
	
	public Juego() {
		
	}
	
	/**
	 * <br> PRE <br>: cantidad de intentos es mayor o igual a -1 
	 * <br> POST <br>: Retorna un nuevo numero aleatorio entre 1 y 100 - Setea estado = "juego recien iniciado"
	 */
	public void inicializarJuego()
	{
		assert this.cantidadIntentos>=-1 : "La cantidad de aciertos debe ser al menos -1 (juego sin iniciar)";
		if (cantidadIntentos==-1 || cantidadIntentos>=10)
		{
			cantidadIntentos=0;
			Random r = new Random();
			numeroMisterioso = r.nextInt(100) + 1;			
			estado = "juego recien iniciado";
		}
		
	}
	
	/**
	 * 
	 * @param numero Es el valor que el usuario ingresa por teclado. 
	 * @return estado  
	 * @throws numeroNoValidoException si el numero no esta entre 1 y 100
	 *  Si no se lanza excepcion retorna el estado y notifica a los observadores
	 */
	public String probar(int numero) throws numeroNoValidoException
	{
		String str="";
		String est="";
		
		
		if (numero>100 || numero<=0)
			throw new numeroNoValidoException();
		
		if (this.estado.equalsIgnoreCase("acerto") || this.estado.equalsIgnoreCase("perdio"))
			str = "finalizado";
		else
		{
			this.cantidadIntentos++;
			if (numero == this.numeroMisterioso)			
				str = est = "acerto";
			else
			{
				if (cantidadIntentos==10)
				{
					est = str = "perdio";
					
				}
					
				else if (numero>numeroMisterioso)
					str = est = "alto";
				else
					str = est = "bajo";				
			}
		}
		System.out.println("numero mist="+this.numeroMisterioso+"  - Numero = "+numero + " - Estado = "+str);
		this.estado = est;
		setChanged();
		notifyObservers(str);
		
		return str;
	}
	
	/**
	 * 
	 * @return cantidad de intentos actuales
	 */
	public int traerIntentos()
	{
		return this.cantidadIntentos;
	}
	
	/**
	 * 
	 * @return estado del juego 
	 */
	public String traerEstado()
	{
		return this.estado;
	}
	
	/**
	 * <br> PRE <br> : el numero misterioso se ha inicializado (se ha llamado a inicializarJuego() con anterioridad)
	 * @return el numero generado aleatoriamente
	 */
	public int hacerTrampa()
	{
		assert this.cantidadIntentos>=0: "Para poder hacer trampa debe primero iniciar el juego";
		return this.numeroMisterioso;
	}
	
	
	/**
	 * Fuerza la posibilidad de generar un nuevo numero aleatorio, seteando la cantidad de intentos en -1
	 */
	public void fuerzaFinJuego()
	{
		this.cantidadIntentos = -1;
	}
	

}
