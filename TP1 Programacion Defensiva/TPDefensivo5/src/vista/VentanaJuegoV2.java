package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.ComponentOrientation;

/**
 * 
 * @author Noelia
 * No se realizan validaciones de datos en la ventana (se realizan en el controlador)
 */
public class VentanaJuegoV2 extends JFrame implements IVista, MouseListener{

	private JPanel contentPane;
	private JTextField textFieldNumero;
	private ActionListener actionListener;
	private JPanel panel_sur = new JPanel();
	private JButton btnNuevoJuego = new JButton("Nuevo Juego");
	private JPanel panel_norte = new JPanel();
	private JLabel lblWelcome = new JLabel("Bienvenidos al juego de adivinar el n\u00FAmero");
	private JPanel panel_central = new JPanel();
	private JPanel panel_central_central = new JPanel();
	private JPanel panel = new JPanel();
	private FlowLayout flowLayout = (FlowLayout) panel.getLayout();
	private JLabel lblNumero = new JLabel("Numero Propuesto");
	private JPanel panel_central_sur = new JPanel();
	private JButton btnAdivinarNumero = new JButton("Adivinar");
	private final JButton btnReiniciar = new JButton("Reiniciar");
	private final JLabel lblIntentos = new JLabel("N\u00BA de iteraciones = -1");
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaJuegoV2 frame = new VentanaJuegoV2();
//					//frame.setUndecorated(true);					
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public VentanaJuegoV2() {
		this.setVisible(true);
		setTitle("Adivina el numero");
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setFont(new Font("Gentium Book Basic", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		panel_sur.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		
		panel_sur.setBackground(Color.DARK_GRAY);
		contentPane.add(panel_sur, BorderLayout.SOUTH);
		btnNuevoJuego.setActionCommand("NUEVO_JUEGO");
		
		
		btnNuevoJuego.addMouseListener(this);
		btnNuevoJuego.setForeground(Color.WHITE);
		btnNuevoJuego.setBackground(Color.DARK_GRAY);
		panel_sur.add(btnNuevoJuego);
		btnNuevoJuego.setFocusPainted(false);
		btnReiniciar.setBackground(Color.DARK_GRAY);
		btnReiniciar.setForeground(Color.WHITE);
		btnReiniciar.setActionCommand("REINICIAR");
		btnReiniciar.setHorizontalAlignment(SwingConstants.RIGHT);
		btnReiniciar.setFocusPainted(false);
		
		panel_sur.add(btnReiniciar);
		lblIntentos.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblIntentos.setAlignmentX(6.0f);
		lblIntentos.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblIntentos.setForeground(Color.WHITE);
		lblIntentos.setBackground(Color.DARK_GRAY);
		
		panel_sur.add(lblIntentos);
		
		
		panel_norte.setBackground(Color.DARK_GRAY);
		contentPane.add(panel_norte, BorderLayout.NORTH);
		
		
		lblWelcome.setForeground(Color.WHITE);
		panel_norte.add(lblWelcome);
		
		
		panel_central.setBackground(Color.DARK_GRAY);
		contentPane.add(panel_central, BorderLayout.CENTER);
		panel_central.setVisible(false);
		panel_central.setLayout(new BorderLayout(0, 0));
		
		
		panel_central_central.setBackground(Color.DARK_GRAY);
		panel_central.add(panel_central_central, BorderLayout.CENTER);
		panel_central_central.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		panel.setBackground(Color.DARK_GRAY);
		
		flowLayout.setVgap(60);
		panel_central_central.add(panel);
		
		
		lblNumero.setForeground(Color.WHITE);
		panel.add(lblNumero);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBackground(Color.LIGHT_GRAY);
		panel.add(textFieldNumero);
		textFieldNumero.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNumero.setColumns(10);
		
		
		panel_central_sur.setBackground(Color.DARK_GRAY);
		panel_central.add(panel_central_sur, BorderLayout.SOUTH);
		btnAdivinarNumero.setActionCommand("ADIVINAR");
		
		
		btnAdivinarNumero.setForeground(Color.WHITE);
		btnAdivinarNumero.setBackground(Color.DARK_GRAY);
		btnAdivinarNumero.setFocusPainted(false);
		panel_central_sur.add(btnAdivinarNumero);
	}

	@Override
	public void setActionListener(ActionListener actionListener) 
	{
		this.btnNuevoJuego.addActionListener(actionListener);
		this.btnAdivinarNumero.addActionListener(actionListener);
		this.btnReiniciar.addActionListener(actionListener);
		this.actionListener = actionListener;
		
	}

	@Override
	public void iniciarJuego() 
	{
		panel_central.setVisible(true);
		btnNuevoJuego.setEnabled(false);
		
	}

	public void mouseClicked(MouseEvent e) {
       ActionEvent event;
       String command="";
       JButton buttonx = (JButton) e.getSource();
       String labelx = buttonx.getText();
       if (labelx.equalsIgnoreCase("adivinar"))
    	   command = "ADIVINAR";
       else 
    	   command = "NUEVO_JUEGO";
       event = new ActionEvent(buttonx, 0, command);       
       this.actionListener.actionPerformed(event);      
       
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	
	public String getTextField()
	{
		return textFieldNumero.getText();
	}
	
	public void setTextField(String str)
	{
		this.textFieldNumero.setText(str);
	}
	
	public void showErrorMsg1()
	{
		JOptionPane.showMessageDialog(contentPane, "Debe Ingresar un numero");
	}
	
	public void showErrorMsg2()
	{
		JOptionPane.showMessageDialog(contentPane, "Debe Ingresar un numero entre 1 y 100");
	}

	@Override
	public void showHint(String msg) {
		JOptionPane.showMessageDialog(contentPane, "El numero ingresado es "+msg+", intente otra vez.");
		
	}

	@Override
	public void showFinalizadoMsg() {
		JOptionPane.showMessageDialog(contentPane, "El juego ha finalizado. Por favor, inicie uno nuevo");
		enableIniciarJuego();
	}

	@Override
	public void showPerdioMsg(int numero) {
		JOptionPane.showMessageDialog(contentPane, "Que lastima! ha perdido. El número misterioso era el "+numero);
		enableIniciarJuego();
	}

	@Override
	public void showGanoMsg(int numero) {
		JOptionPane.showMessageDialog(contentPane, "Felicitaciones, ha ganado!!! El número misterioso era el "+numero);
		
	}

	@Override
	public void enableIniciarJuego() {
		btnNuevoJuego.setEnabled(true);
		panel_central.setVisible(false);
		
	}

	@Override
	public void updateLabel(String str) {
		lblIntentos.setText(str);		
	}
}
