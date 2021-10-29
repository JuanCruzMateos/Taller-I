package sistema.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import sistema.Util.Mensaje;
import sistema.habitaciones.Habitacion;
import sistema.personas.medicos.IMedico;
import sistema.personas.pacientes.Paciente;

/**
 * Ventana del modelo MVC.<br>
 */
public class Ventana extends JFrame implements ListSelectionListener, IVista, KeyListener {
	private JPanel contentPane;
	private JPanel panelLista;
	private JPanel panelMuestra;
	private JPanel panelFactura;
	private JPanel panelTresColumnas;

	private JTextField numeroConsultas;
	private JTextField diasInternacion;
	private JTextPane textoFactura;
	private JComboBox<IMedico> medico;
	private JComboBox<Habitacion> tipoHabitacion;
	private JList<Paciente> listaPacientesFacturacion;
	private DefaultListModel<Paciente> modeloListaPacientesFacturacion;
	private JButton botonAñadirConsulta;
	private JButton botonAñadirInternacion;
	private JButton botonFinalizarFactura;

	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1034, 591);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		panelFactura = new JPanel();
		tabbedPane.addTab("Facturacion", null, panelFactura, null);
		panelFactura.setLayout(new GridLayout(1, 0, 0, 0));

		panelTresColumnas = new JPanel();
		panelFactura.add(panelTresColumnas);
		panelTresColumnas.setLayout(new GridLayout(0, 3, 0, 0));

		JPanel PanelListaPacientes = new JPanel();
		panelTresColumnas.add(PanelListaPacientes);
		PanelListaPacientes.setLayout(new BorderLayout(0, 0));

		JPanel PanelBotonInicioFactura = new JPanel();
		PanelBotonInicioFactura.setPreferredSize(new Dimension(10, 60));
		PanelListaPacientes.add(PanelBotonInicioFactura, BorderLayout.SOUTH);
		PanelBotonInicioFactura.setLayout(null);

		JButton BotonComenzarFactura = new JButton(Mensaje.COMENZARFACTURA.getValor());
		BotonComenzarFactura.setActionCommand("ComenzarFactura"); // cambiar action command desde avan
		BotonComenzarFactura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		BotonComenzarFactura.setBounds(160, 10, 137, 40);
		BotonComenzarFactura.addActionListener(Controlador.getInstance()); // agregar al boton
		PanelBotonInicioFactura.add(BotonComenzarFactura);

		panelLista = new JPanel();
		PanelListaPacientes.add(panelLista, BorderLayout.CENTER);
		panelLista.setLayout(new BorderLayout(0, 0));

		// LISTA PACIENTES FACTURACION
		this.listaPacientesFacturacion = new JList<>();
		listaPacientesFacturacion.setBorder(new TitledBorder(null, Mensaje.PACIENTESATENCION.getValor(),
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelLista.add(listaPacientesFacturacion);
		listaPacientesFacturacion.addListSelectionListener(this);
		this.modeloListaPacientesFacturacion = new DefaultListModel<>(); // agrego el modelo
		this.listaPacientesFacturacion.setModel(modeloListaPacientesFacturacion);

		JPanel PanelIngreso = new JPanel();
		panelTresColumnas.add(PanelIngreso);
		PanelIngreso.setLayout(new BorderLayout(0, 0));

		JPanel PanelBotonFinFactura = new JPanel();
		PanelBotonFinFactura.setPreferredSize(new Dimension(10, 60));
		PanelIngreso.add(PanelBotonFinFactura, BorderLayout.SOUTH);
		PanelBotonFinFactura.setLayout(null);

		botonFinalizarFactura = new JButton(Mensaje.FINALIZARFACTURA.getValor());
		botonFinalizarFactura.setActionCommand("FinalizarFactura"); // cambiar action command desde avan
		botonFinalizarFactura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonFinalizarFactura.setBounds(167, 10, 137, 40);
		botonFinalizarFactura.addActionListener(Controlador.getInstance()); // agregar al boton
		botonFinalizarFactura.setEnabled(false);
		PanelBotonFinFactura.add(botonFinalizarFactura);

		JPanel PanelAgregarSubFactura = new JPanel();
		PanelIngreso.add(PanelAgregarSubFactura, BorderLayout.CENTER);
		PanelAgregarSubFactura.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel PanelConsultas = new JPanel();
		PanelAgregarSubFactura.add(PanelConsultas);
		PanelConsultas.setLayout(null);

		numeroConsultas = new JTextField();
		numeroConsultas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		numeroConsultas.setBounds(155, 101, 135, 23);
		PanelConsultas.add(numeroConsultas);
		numeroConsultas.setColumns(10);

		JLabel LabelMedico = new JLabel(Mensaje.MEDICO.getValor());
		LabelMedico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelMedico.setBounds(28, 46, 69, 28);
		PanelConsultas.add(LabelMedico);

		medico = new JComboBox<>();
		medico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		medico.setBounds(93, 49, 217, 23);
		PanelConsultas.add(medico);

		JLabel LabelNumeroConsultas = new JLabel(Mensaje.NUMEROCONSULTAS.getValor());
		LabelNumeroConsultas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelNumeroConsultas.setBounds(28, 96, 122, 28);
		PanelConsultas.add(LabelNumeroConsultas);

		botonAñadirConsulta = new JButton(Mensaje.ACEPTARCONSULTA.getValor());
		botonAñadirConsulta.setActionCommand("AñadirConsulta"); // cambiar action command desde avan
		botonAñadirConsulta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonAñadirConsulta.setBounds(174, 163, 130, 33);
		botonAñadirConsulta.addActionListener(Controlador.getInstance()); // agregar al boton
		botonAñadirConsulta.setEnabled(false);
		PanelConsultas.add(botonAñadirConsulta);

		JPanel PanelInternaciones = new JPanel();
		PanelInternaciones.setLayout(null);
		PanelAgregarSubFactura.add(PanelInternaciones);

		diasInternacion = new JTextField();
		diasInternacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		diasInternacion.setColumns(10);
		diasInternacion.setBounds(155, 101, 135, 23);
		PanelInternaciones.add(diasInternacion);

		JLabel LabelHabitacion = new JLabel(Mensaje.HABITACION.getValor());
		LabelHabitacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelHabitacion.setBounds(28, 46, 69, 28);
		PanelInternaciones.add(LabelHabitacion);

		tipoHabitacion = new JComboBox<>();
		tipoHabitacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tipoHabitacion.setBounds(155, 49, 135, 23);
		PanelInternaciones.add(tipoHabitacion);

		JLabel LabelDiasInternacion = new JLabel(Mensaje.DIASINTERNACION.getValor());
		LabelDiasInternacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelDiasInternacion.setBounds(28, 96, 122, 28);
		PanelInternaciones.add(LabelDiasInternacion);

		botonAñadirInternacion = new JButton(Mensaje.ACEPTARINTERNACION.getValor());
		botonAñadirInternacion.setActionCommand("AñadirInternacion"); // cambiar action command desde avan
		botonAñadirInternacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonAñadirInternacion.setBounds(174, 163, 130, 33);
		botonAñadirInternacion.addActionListener(Controlador.getInstance()); // agregar al boton
		botonAñadirInternacion.setEnabled(false);
		PanelInternaciones.add(botonAñadirInternacion);

		panelMuestra = new JPanel();
		panelTresColumnas.add(panelMuestra);
		panelMuestra.setLayout(new BorderLayout(0, 0));

		textoFactura = new JTextPane();
		panelMuestra.add(textoFactura, BorderLayout.CENTER);

		numeroConsultas.setName("numeroConsultas");
		diasInternacion.setName("diasInternacion");
		textoFactura.setName("textoFactura");
		medico.setName("medico");
		tipoHabitacion.setName("tipoHabitacion");
		listaPacientesFacturacion.setName("listaPacientesFacturacion");
		botonAñadirConsulta.setName("botonAñadirConsulta");
		botonAñadirInternacion.setName("botonAñadirInternacion");
		botonFinalizarFactura.setName("botonFinalizarFactura");

		numeroConsultas.addKeyListener(this);
		diasInternacion.addKeyListener(this);

		this.setMinimumSize(new Dimension(900, 600));
		this.setVisible(true);
	}

	@Override
	public Paciente getPacienteFacturacion() {
		return this.listaPacientesFacturacion.getSelectedValue();
	}
	
	 
	@Override
	public IMedico getMedicoFacturacion() {
		return (IMedico) this.medico.getSelectedItem();
	}

	@Override
	public int getCantidadConsultasFacturacion() throws NumberFormatException {
		return Integer.parseInt(this.numeroConsultas.getText());
	}

	@Override
	public Habitacion getHabitacionFacturacion() {
		return (Habitacion) this.tipoHabitacion.getSelectedItem();
	}

	@Override
	public int getCantidadDiasInternacionFacturacion() throws NumberFormatException {
		return Integer.parseInt(this.diasInternacion.getText());
	}

	@Override
	public void actualizarListaPacientesAtencion(Iterator<Paciente> iterator) {
		this.modeloListaPacientesFacturacion.clear();
		while (iterator.hasNext()) {
			this.modeloListaPacientesFacturacion.addElement(iterator.next());
		}
		this.repaint();
	}

	@Override
	public void actualizarComboMedicosFacturacion(Iterator<IMedico> iterator) {
		while (iterator.hasNext()) {
			this.medico.addItem(iterator.next());
		}
	}

	@Override
	public void actualizarComboHabitacionesFacturacion(Iterator<Habitacion> iterator) {
		while (iterator.hasNext()) {
			this.tipoHabitacion.addItem(iterator.next());
		}
	}

	@Override
	public void mostrarFactura(String detalle) {
		this.textoFactura.setText("");
		this.textoFactura.setText(detalle);
	}

	@Override
	public void addActionListener(ActionListener actionListener) {

	}

	@Override
	public void habilitarBotonesFactura(boolean habilitar) {

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		try {

			this.botonAñadirConsulta.setEnabled(this.getPacienteFacturacion() != null
					&& this.getMedicoFacturacion() != null && this.getCantidadConsultasFacturacion() != 0);

		} catch (NumberFormatException ex) {
			this.botonAñadirConsulta.setEnabled(false);
		}
		try {
			this.botonAñadirInternacion.setEnabled(this.getPacienteFacturacion() != null
					&& this.getHabitacionFacturacion() != null && this.getCantidadDiasInternacionFacturacion() != 0);
		} catch (NumberFormatException ex) {
			this.botonAñadirInternacion.setEnabled(false);
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
