package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import controlador.Monitor;
import exceptions.OperacionInvalidaException;
import exceptions.OperandoInvalidoException;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class Vista extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JEditorPane editorPane;
	private JButton b7;
	private JButton b4;
	private JButton b1;
	private JButton bZero;
	private JButton b8;
	private JButton b5;
	private JButton b2;
	private JButton b0;
	private JButton b9;
	private JButton b6;
	private JButton b3;
	private JButton bEqual;
	private JButton bPlus;
	private JButton bMinus;
	private JButton bTimes;
	private JButton bDiv;
	private JTextField value;
	private Monitor monitor = new Monitor();
	private String operacion;
	private int primerOperando;
	private String segundoOperandoS;
	private int segundoOperando;
	private JTextField subvalue;
	private JTextField errorText;
	private String mensajeError;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 288, 307);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(Color.DARK_GRAY);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.editorPane = new JEditorPane();
		this.editorPane.setBackground(Color.LIGHT_GRAY);
		this.editorPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.editorPane.setBounds(10, 5, 254, 67);
		this.contentPane.add(this.editorPane);
		
		this.b7 = new JButton("7");
		this.b7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value.setText(value.getText()+7);
			}	
		});
		this.b7.setBounds(10, 76, 56, 39);
		this.contentPane.add(this.b7);
		
		this.b4 = new JButton("4");
		this.b4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value.setText(value.getText()+4);
			}	
		});
		this.b4.setBounds(10, 126, 56, 39);
		this.contentPane.add(this.b4);
		
		this.b1 = new JButton("1");
		this.b1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value.setText(value.getText()+1);
			}	
		});
		this.b1.setBounds(10, 176, 56, 39);
		this.contentPane.add(this.b1);
		
		this.bZero = new JButton("AC");
		this.bZero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.bZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value.setText("");
				subvalue.setText("");
				errorText.setText("");
			}	
		});
		this.bZero.setBounds(10, 222, 56, 39);
		this.contentPane.add(this.bZero);
		
		this.b8 = new JButton("8");
		this.b8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value.setText(value.getText()+8);
			}	
		});
		this.b8.setBounds(76, 76, 56, 39);
		this.contentPane.add(this.b8);
		
		this.b5 = new JButton("5");
		this.b5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value.setText(value.getText()+5);
			}	
		});
		this.b5.setBounds(76, 126, 56, 39);
		this.contentPane.add(this.b5);
		
		this.b2 = new JButton("2");
		this.b2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value.setText(value.getText()+2);
			}	
		});
		this.b2.setBounds(76, 176, 56, 39);
		this.contentPane.add(this.b2);
		
		this.b0 = new JButton("0");
		this.b0.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.b0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value.setText(value.getText()+0);
			}	
		});
		this.b0.setBounds(76, 222, 56, 39);
		this.contentPane.add(this.b0);
		
		this.b9 = new JButton("9");
		this.b9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value.setText(value.getText()+9);
			}	
		});
		this.b9.setBounds(142, 76, 56, 39);
		this.contentPane.add(this.b9);
		
		this.b6 = new JButton("6");
		this.b6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value.setText(value.getText()+6);
			}	
		});
		this.b6.setBounds(142, 126, 56, 39);
		this.contentPane.add(this.b6);
		
		this.b3 = new JButton("3");
		this.b3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value.setText(value.getText()+3);
			}	
		});
		this.b3.setBounds(142, 176, 56, 39);
		this.contentPane.add(this.b3);
		
		this.bEqual = new JButton("=");
		this.bEqual.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.bEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean x = true ;
				subvalue.setText(subvalue.getText()+value.getText()+" = ");
				segundoOperando=Integer.parseInt(value.getText());
				try {
					monitor.Calcular(primerOperando,segundoOperando,operacion);
				} catch (NumberFormatException e1) {
					mensajeError=e1.getMessage();
					errorText.setText(mensajeError);
					x=false;
				} catch (OperacionInvalidaException e1) {
					mensajeError=e1.getMessage();
					errorText.setText(mensajeError);
					x=false;
				} catch (OperandoInvalidoException e1) {
					mensajeError=e1.getMessage();
					errorText.setText(mensajeError);
					x=false;
				}
				if(x)
					value.setText(Integer.toString(mostrarResultado()));
				else
					value.setText("Error");
			}	
		});
		this.bEqual.setBounds(142, 222, 56, 39);
		this.contentPane.add(this.bEqual);
		
		this.bPlus = new JButton("+");
		this.bPlus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.bPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				primerOperando = Integer.parseInt(value.getText());
				subvalue.setText(value.getText()+" + ");
				value.setText("");
				operacion = "+";
			}	
		});
		this.bPlus.setBounds(208, 76, 56, 39);
		this.contentPane.add(this.bPlus);
		
		this.bMinus = new JButton("-");
		this.bMinus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.bMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				primerOperando = Integer.parseInt(value.getText());
				subvalue.setText(value.getText()+" - ");
				value.setText("");
				operacion = "-";
			}	
		});
		this.bMinus.setBounds(208, 126, 56, 39);
		this.contentPane.add(this.bMinus);
		
		this.bTimes = new JButton("x");
		this.bTimes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.bTimes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				primerOperando = Integer.parseInt(value.getText());
				subvalue.setText(value.getText()+" x ");
				value.setText("");
				operacion = "*";
			}	
		});
		this.bTimes.setBounds(208, 176, 56, 39);
		this.contentPane.add(this.bTimes);
		
		this.bDiv = new JButton("/");
		this.bDiv.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.bDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				primerOperando = Integer.parseInt(value.getText());
				subvalue.setText(value.getText()+" / ");
				value.setText("");
				operacion = "/";
			}	
		});
		this.bDiv.setBounds(208, 222, 56, 39);
		this.contentPane.add(this.bDiv);
		
		this.value = new JTextField();
		this.value.setBackground(Color.LIGHT_GRAY);
		this.value.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.value.setBorder(null);
		this.value.setBounds(142, 34, 107, 31);
		this.contentPane.add(this.value);
		this.value.setColumns(10);
		
		this.subvalue = new JTextField();
		this.subvalue.setBackground(Color.LIGHT_GRAY);
		this.subvalue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.subvalue.setColumns(10);
		this.subvalue.setBorder(null);
		this.subvalue.setBounds(25, 34, 107, 31);
		this.contentPane.add(this.subvalue);
		
		this.errorText = new JTextField();
		this.errorText.setBackground(Color.LIGHT_GRAY);
		this.errorText.setBorder(null);
		this.errorText.setForeground(Color.RED);
		this.errorText.setBounds(25, 11, 224, 20);
		this.contentPane.add(this.errorText);
		this.errorText.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
	/**
	 * Devuelve el resultado de la ultima operacion exitosa
	 * @return
	 */
	public int mostrarResultado() {
		return monitor.traerResultado();
	}
	/**
	 * Muestra el mensaje de error en el caso de haber ocurrrido.
	 * @return
	 */
	public String mostrarEstado() {
		return mensajeError;
	}
	
	
	
}
