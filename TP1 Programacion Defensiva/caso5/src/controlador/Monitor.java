package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.security.InvalidParameterException;
import java.util.Observable;
import java.util.Observer;



import exceptions.numeroNoValidoException;
import modelo.Juego;
import vista.IVista;
import vista.VentanaJuegoV2;

/**
 * 
 * @author Noelia
 * Clase monitor aplica patron singleton y observer
 * 
 */
@SuppressWarnings("deprecation")
public class Monitor implements ActionListener, Observer, WindowListener{

	private Juego juego;
	private IVista vista;
	private static Monitor instancia=null;
	
	/**
	 * Constructor privado
	 */
	private Monitor() {
				
		this.vista = new VentanaJuegoV2();		
		this.vista.setActionListener(this);
		
		
	}
	
	/**
	 * 
	 * @return instancia de la clase Monitor
	 */
	public static Monitor getInstance()
	{
		if (instancia==null)
			instancia = new Monitor();
		return instancia;
			
	}
	
	/**
	 *  Inicializa el juego. Se genera un numero aleatorio cuando se llama este metodo (Delegacion)
	 */
	public void inicializarJuego()
	{
		juego.inicializarJuego();
	}
	
	/**
	 * 
	 * @param numero 
	 * @return estado --> retorna estado del juego (alto, bajo, acerto, perdio)
	 * @throws numeroNoValidoException Propaga la excepcion generada en clase Juego
	 */
	public String probarNumero(int numero) throws numeroNoValidoException
	{
		return juego.probar(numero);
	}
	
	
	/**
	 * 
	 * @return numero de intentos - Si no se ha iniciado el juego retorna -1 (delegacion)
	 */
	public int traerIntentos()
	{
		return juego.traerIntentos();
	}
	
	/**
	 * 
	 * @return estado del juego (delegacion)
	 */
	public String traerEstado()
	{
		return juego.traerEstado();
	}
	
	/**
	 * <br>PRE<br>: Se ha iniciado el juego
	 * @return numero aleatorio generado al iniciar el juego
	 */
	public int hacerTrampa()
	{
		assert this.juego!=null : "Para poder hacer trampa debe primero iniciar el juego";
		return juego.hacerTrampa();
	}
	
	/**
	 * setea cantidad de intentos en -1 para poder generar numero aleatorio nuevo
	 * <br>PRE<br>: Se ha iniciado el juego
	 */
	public void fuerzaFinJuego()
	{
		assert this.juego!=null : "Para poder reiniciar el juego, primero debe iniciarlo al menos una vez";
		this.juego.fuerzaFinJuego();
	}

	/**
	 * Update con datos observados
	 */
	@Override	
	public void update(Observable obj, Object arg) {
		if (obj!=this.juego)
			throw new InvalidParameterException();
		
		String arg2 = (String) arg;
		if (arg2.equalsIgnoreCase("bajo"))	
		{
			vista.showHint(arg2);
			vista.setTextField("");
		}
			
		else if (arg2.equalsIgnoreCase("alto"))
		{
			vista.showHint(arg2);
			vista.setTextField("");
		}
			
		else if (arg2.equalsIgnoreCase("perdio"))
		{
			vista.showPerdioMsg(juego.hacerTrampa());
			vista.setTextField("");
			vista.enableIniciarJuego();
		}	
		else if (arg2.equalsIgnoreCase("acerto"))
		{
			vista.showGanoMsg(juego.hacerTrampa());
			vista.setTextField("");
			vista.enableIniciarJuego();
		}			
		else
		{
			vista.showFinalizadoMsg();
			vista.setTextField("");
			vista.enableIniciarJuego();
		}
			
	}	

	/**
	 * Genera las interacciones entre los eventos o comandos provenientes de la vista y el juego
	 * Atiende las excepciones generadas en el juego.
	 * Atiende las excepciones generadas por mal uso del textfield (ingresar letras y no  numeros)
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String comando = e.getActionCommand();
		
		if (comando.equalsIgnoreCase("NUEVO_JUEGO"))
		{
			this.juego = new Juego();
			this.inicializarJuego();
			this.juego.addObserver(this);
			this.vista.iniciarJuego();
			
		}
		
		if (comando.equalsIgnoreCase("REINICIAR"))
		{
			
			vista.enableIniciarJuego();
			this.fuerzaFinJuego(); // para permitir generar un nuevo numero aleatorio
			String str2 =  "Nº Iteraciones="+this.juego.traerIntentos();
			this.vista.updateLabel(str2);
		}
		
		if (comando.equalsIgnoreCase("ADIVINAR"))
		{
			int numero;
			String estado="";
			try
			{
				numero = Integer.parseInt(vista.getTextField());
				try
				{
					estado = probarNumero(numero);					
				}
				catch(numeroNoValidoException e2)
				{
					vista.showErrorMsg2();
					vista.setTextField("");
				}
			}
			catch(NumberFormatException e1)
			{
				vista.showErrorMsg1();
				vista.setTextField("");
			}
				
			String str2 =  "Nº Iteraciones="+this.juego.traerIntentos();
			this.vista.updateLabel(str2);
			this.juego.addObserver(this);
			this.vista.iniciarJuego();
			
		}
		
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
