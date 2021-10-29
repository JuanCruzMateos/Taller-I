//package sistema.gui;
//
//import java.awt.BorderLayout;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;
//
////import controlador.Controlador;
//import sistema.habitaciones.Habitacion;
//import sistema.personas.medicos.IMedico;
////import sistema.personas.pacientes.Asociado;
//import sistema.personas.pacientes.Paciente;
//
//import javax.swing.JTabbedPane;
//import java.awt.GridLayout;
//import java.awt.event.ActionListener;
//import java.util.Iterator;
//
//import javax.swing.JList;
//import javax.swing.JOptionPane;
//
//import javax.swing.DefaultListModel;
//import javax.swing.JButton;
//import java.awt.Dimension;
//import java.awt.Font;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//import javax.swing.JComboBox;
//import javax.swing.JTextPane;
//import javax.swing.SwingConstants;
//import javax.swing.border.TitledBorder;
//import javax.swing.border.EtchedBorder;
//import java.awt.Color;
//import javax.swing.JScrollPane;
//
///**
// * Ventana del modelo MVC.<br>
// */
//public class VentanaAnterior extends JFrame implements ListSelectionListener, IVistaAnterior {
//
//    private JPanel contentPane;
//    private JPanel PanelLista;
//    private JPanel PanelMuestra;
//    private JPanel PanelFactura;
//    private JPanel PanelTresColumnas;
//
//
//    //FACTURACION
//
//    private JTextField NumeroConsultas;
//    private JTextField DiasInternacion;
//    private JTextPane TextoFactura;
//    private JComboBox<IMedico> Medico;
//    private JComboBox<Habitacion> TipoHabitacion;
//    private JList<Paciente> ListaPacientesFacturacion;
//    private DefaultListModel<Paciente> ModeloListaPacientesFacturacion;
//    private JButton BotonAñadirConsulta;
//    private JButton BotonAñadirInternacion;
//    private JButton BotonFinalizarFactura;
//
//    //ALTA/BAJA
//    private JTextField NombreAsociado;
//    private JTextField ApellidoAsociado;
//    private JTextField DNIAsociado;
//    private JTextField DomicilioAsociado;
//    private JTextField TelefonoAsociado;
//    private JTextField DNIAsociadoAEliminar;
////    private JList<Asociado> ListaAsociados;
////    private DefaultListModel<Asociado> ModeloListaAsociados;
//
//
//    //Simulacion
////    private JList<Asociado> ListaAsociadosSimulacion;
//    private JTextField CantidadSolicitudesAsociado;
//    private JTextField CantidadSolicitudesOperario;
//    private JTextPane textPane;
//
//
//    /**
//     * Create the frame.
//     */
//    public VentanaAnterior() {
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(100, 100, 1034, 591);
//        contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        contentPane.setLayout(new BorderLayout(0, 0));
//        setContentPane(contentPane);
//
//        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
//        contentPane.add(tabbedPane, BorderLayout.CENTER);
//
//        PanelFactura = new JPanel();
//        tabbedPane.addTab("Facturacion", null, PanelFactura, null);
//        PanelFactura.setLayout(new GridLayout(1, 0, 0, 0));
//
//        PanelTresColumnas = new JPanel();
//        PanelFactura.add(PanelTresColumnas);
//        PanelTresColumnas.setLayout(new GridLayout(0, 3, 0, 0));
//
//        JPanel PanelListaPacientes = new JPanel();
//        PanelTresColumnas.add(PanelListaPacientes);
//        PanelListaPacientes.setLayout(new BorderLayout(0, 0));
//
//        JPanel PanelBotonInicioFactura = new JPanel();
//        PanelBotonInicioFactura.setPreferredSize(new Dimension(10, 60));
//        PanelListaPacientes.add(PanelBotonInicioFactura, BorderLayout.SOUTH);
//        PanelBotonInicioFactura.setLayout(null);
//
//        JButton BotonComenzarFactura = new JButton("Comenzar Factura");
//        BotonComenzarFactura.setActionCommand("ComenzarFactura");            //cambiar action command  desde avan
//        BotonComenzarFactura.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        BotonComenzarFactura.setBounds(160, 10, 137, 40);
//        BotonComenzarFactura.addActionListener(ControladorAnterior.getInstance());   //agregar al boton
//        PanelBotonInicioFactura.add(BotonComenzarFactura);
//
//        PanelLista = new JPanel();
//        PanelListaPacientes.add(PanelLista, BorderLayout.CENTER);
//        PanelLista.setLayout(new BorderLayout(0, 0));
//
//        //LISTA PACIENTES FACTURACION
//        this.ListaPacientesFacturacion = new JList<Paciente>();
//        ListaPacientesFacturacion.setBorder(new TitledBorder(null, "Pacientes en Atencion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
//        PanelLista.add(ListaPacientesFacturacion);
//        ListaPacientesFacturacion.addListSelectionListener(this);
//        this.ModeloListaPacientesFacturacion = new DefaultListModel<Paciente>();   //agrego el modelo
//        this.ListaPacientesFacturacion.setModel(ModeloListaPacientesFacturacion);
//
//        JPanel PanelIngreso = new JPanel();
//        PanelTresColumnas.add(PanelIngreso);
//        PanelIngreso.setLayout(new BorderLayout(0, 0));
//
//        JPanel PanelBotonFinFactura = new JPanel();
//        PanelBotonFinFactura.setPreferredSize(new Dimension(10, 60));
//        PanelIngreso.add(PanelBotonFinFactura, BorderLayout.SOUTH);
//        PanelBotonFinFactura.setLayout(null);
//
//        BotonFinalizarFactura = new JButton("Finalizar Factura");
//        BotonFinalizarFactura.setActionCommand("FinalizarFactura");           //cambiar action command desde avan
//        BotonFinalizarFactura.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        BotonFinalizarFactura.setBounds(167, 10, 137, 40);
//        BotonFinalizarFactura.addActionListener(ControladorAnterior.getInstance());   //agregar al boton
//        BotonFinalizarFactura.setEnabled(false);
//        PanelBotonFinFactura.add(BotonFinalizarFactura);
//
//        JPanel PanelAgregarSubFactura = new JPanel();
//        PanelIngreso.add(PanelAgregarSubFactura, BorderLayout.CENTER);
//        PanelAgregarSubFactura.setLayout(new GridLayout(2, 0, 0, 0));
//
//        JPanel PanelConsultas = new JPanel();
//        PanelAgregarSubFactura.add(PanelConsultas);
//        PanelConsultas.setLayout(null);
//
//        NumeroConsultas = new JTextField();
//        NumeroConsultas.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        NumeroConsultas.setBounds(155, 101, 135, 23);
//        PanelConsultas.add(NumeroConsultas);
//        NumeroConsultas.setColumns(10);
//
//        JLabel LabelMedico = new JLabel("Medico");
//        LabelMedico.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        LabelMedico.setBounds(28, 46, 69, 28);
//        PanelConsultas.add(LabelMedico);
//
//        Medico = new JComboBox<IMedico>();
//        Medico.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        Medico.setBounds(93, 49, 217, 23);
//        PanelConsultas.add(Medico);
//
//        JLabel LabelNumeroConsultas = new JLabel("Numero Consultas");
//        LabelNumeroConsultas.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        LabelNumeroConsultas.setBounds(28, 96, 122, 28);
//        PanelConsultas.add(LabelNumeroConsultas);
//
//        BotonAñadirConsulta = new JButton("Añadir Consulta");
//        BotonAñadirConsulta.setActionCommand("AñadirConsulta");           //cambiar action command desde avan
//        BotonAñadirConsulta.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        BotonAñadirConsulta.setBounds(174, 163, 130, 33);
//        BotonAñadirConsulta.addActionListener(ControladorAnterior.getInstance());   //agregar al boton
//        BotonAñadirConsulta.setEnabled(false);
//        PanelConsultas.add(BotonAñadirConsulta);
//
//        JPanel PanelInternaciones = new JPanel();
//        PanelInternaciones.setLayout(null);
//        PanelAgregarSubFactura.add(PanelInternaciones);
//
//        DiasInternacion = new JTextField();
//        DiasInternacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        DiasInternacion.setColumns(10);
//        DiasInternacion.setBounds(155, 101, 135, 23);
//        PanelInternaciones.add(DiasInternacion);
//
//        JLabel LabelHabitacion = new JLabel("Habitacion");
//        LabelHabitacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        LabelHabitacion.setBounds(28, 46, 69, 28);
//        PanelInternaciones.add(LabelHabitacion);
//
//        TipoHabitacion = new JComboBox<Habitacion>();
//        TipoHabitacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        TipoHabitacion.setBounds(155, 49, 135, 23);
//        PanelInternaciones.add(TipoHabitacion);
//
//        JLabel LabelDiasInternacion = new JLabel("Dias Internacion");
//        LabelDiasInternacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        LabelDiasInternacion.setBounds(28, 96, 122, 28);
//        PanelInternaciones.add(LabelDiasInternacion);
//
//        BotonAñadirInternacion = new JButton("Añadir Internacion");
//        BotonAñadirInternacion.setActionCommand("AñadirInternacion");             //cambiar action command  desde avan
//        BotonAñadirInternacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        BotonAñadirInternacion.setBounds(174, 163, 130, 33);
//        BotonAñadirInternacion.addActionListener(ControladorAnterior.getInstance()); //agregar al boton
//        BotonAñadirInternacion.setEnabled(false);
//        PanelInternaciones.add(BotonAñadirInternacion);
//
//        PanelMuestra = new JPanel();
//        PanelTresColumnas.add(PanelMuestra);
//        PanelMuestra.setLayout(new BorderLayout(0, 0));
//
//        TextoFactura = new JTextPane();
//        PanelMuestra.add(TextoFactura, BorderLayout.CENTER);
//
//        JPanel PanelAsociados = new JPanel();
//        tabbedPane.addTab("Asociados", null, PanelAsociados, null);
//        PanelAsociados.setLayout(new GridLayout(0, 2, 0, 0));
//
//        JPanel PanelDatosAlta = new JPanel();
//        PanelAsociados.add(PanelDatosAlta);
//        PanelDatosAlta.setLayout(new GridLayout(2, 0, 0, 0));
//
//        JPanel panel_1 = new JPanel();
//        PanelDatosAlta.add(panel_1);
//        panel_1.setLayout(null);
//
//        JLabel LabelAlta = new JLabel("Alta");
//        LabelAlta.setFont(new Font("Tahoma", Font.PLAIN, 30));
//        LabelAlta.setBounds(10, 10, 83, 37);
//        panel_1.add(LabelAlta);
//
//        NombreAsociado = new JTextField();
//        NombreAsociado.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        NombreAsociado.setBounds(214, 50, 182, 21);
//        panel_1.add(NombreAsociado);
//        NombreAsociado.setColumns(10);
//
//        ApellidoAsociado = new JTextField();
//        ApellidoAsociado.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        ApellidoAsociado.setColumns(10);
//        ApellidoAsociado.setBounds(214, 81, 182, 21);
//        panel_1.add(ApellidoAsociado);
//
//        DNIAsociado = new JTextField();
//        DNIAsociado.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        DNIAsociado.setColumns(10);
//        DNIAsociado.setBounds(214, 112, 182, 21);
//        panel_1.add(DNIAsociado);
//
//        DomicilioAsociado = new JTextField();
//        DomicilioAsociado.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        DomicilioAsociado.setColumns(10);
//        DomicilioAsociado.setBounds(214, 143, 182, 21);
//        panel_1.add(DomicilioAsociado);
//
//        TelefonoAsociado = new JTextField();
//        TelefonoAsociado.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        TelefonoAsociado.setColumns(10);
//        TelefonoAsociado.setBounds(214, 174, 182, 21);
//        panel_1.add(TelefonoAsociado);
//
//        JLabel LabelNombre = new JLabel("Nombre");
//        LabelNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        LabelNombre.setHorizontalAlignment(SwingConstants.LEFT);
//        LabelNombre.setBounds(112, 51, 83, 19);
//        panel_1.add(LabelNombre);
//
//        JLabel lblApellido = new JLabel("Apellido");
//        lblApellido.setHorizontalAlignment(SwingConstants.LEFT);
//        lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        lblApellido.setBounds(112, 82, 83, 19);
//        panel_1.add(lblApellido);
//
//        JLabel lblDni = new JLabel("DNI");
//        lblDni.setHorizontalAlignment(SwingConstants.LEFT);
//        lblDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        lblDni.setBounds(112, 113, 83, 19);
//        panel_1.add(lblDni);
//
//        JLabel lblDomicilio = new JLabel("Domicilio");
//        lblDomicilio.setHorizontalAlignment(SwingConstants.LEFT);
//        lblDomicilio.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        lblDomicilio.setBounds(112, 144, 83, 19);
//        panel_1.add(lblDomicilio);
//
//        JLabel lblTelefono = new JLabel("Telefono");
//        lblTelefono.setHorizontalAlignment(SwingConstants.LEFT);
//        lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        lblTelefono.setBounds(112, 176, 83, 19);
//        panel_1.add(lblTelefono);
//
//        JButton BotonAgregarAsociado = new JButton("Agregar");
//        BotonAgregarAsociado.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        BotonAgregarAsociado.setActionCommand("AgregarAsociado");
//        BotonAgregarAsociado.setBounds(330, 218, 115, 35);
//        BotonAgregarAsociado.addActionListener(ControladorAnterior.getInstance());
//        panel_1.add(BotonAgregarAsociado);
//
//        JPanel panel = new JPanel();
//        PanelDatosAlta.add(panel);
//        panel.setLayout(null);
//
//        JLabel LabelBaja = new JLabel("Baja");
//        LabelBaja.setFont(new Font("Tahoma", Font.PLAIN, 30));
//        LabelBaja.setBounds(10, 10, 83, 37);
//        panel.add(LabelBaja);
//
//        DNIAsociadoAEliminar = new JTextField();
//        DNIAsociadoAEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        DNIAsociadoAEliminar.setColumns(10);
//        DNIAsociadoAEliminar.setBounds(206, 90, 182, 21);
//        panel.add(DNIAsociadoAEliminar);
//
//        JLabel lblDni_1 = new JLabel("DNI");
//        lblDni_1.setHorizontalAlignment(SwingConstants.LEFT);
//        lblDni_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        lblDni_1.setBounds(113, 91, 83, 19);
//        panel.add(lblDni_1);
//
//        JButton BotonEliminarAsociado = new JButton("Eliminar");
//        BotonEliminarAsociado.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        BotonEliminarAsociado.setActionCommand("EliminarAsociado");
//        BotonEliminarAsociado.setBounds(328, 162, 115, 35);
//        BotonEliminarAsociado.addActionListener(ControladorAnterior.getInstance());
//        panel.add(BotonEliminarAsociado);
//
//        JPanel PanelListaAsociados = new JPanel();
//        PanelAsociados.add(PanelListaAsociados);
//        PanelListaAsociados.setLayout(new BorderLayout(0, 0));
//
//        //LISTA ASOCIADOS
////        ListaAsociados = new JList<Asociado>();
////        ListaAsociados.setBorder(new TitledBorder(null, "Asociados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
////        this.ModeloListaAsociados = new DefaultListModel<Asociado>();
////        this.ListaAsociados.setModel(ModeloListaAsociados);
////        PanelListaAsociados.add(ListaAsociados, BorderLayout.CENTER);
//
//        JPanel PanelSimulacion = new JPanel();
//        tabbedPane.addTab("Simulacion", null, PanelSimulacion, null);
//        PanelSimulacion.setLayout(new GridLayout(0, 3, 0, 0));
//
//        JPanel PanelListaAsociadosSimulacion = new JPanel();
//        PanelSimulacion.add(PanelListaAsociadosSimulacion);
//        PanelListaAsociadosSimulacion.setLayout(new BorderLayout(0, 0));
//
////        ListaAsociadosSimulacion = new JList<Asociado>();
////        ListaAsociadosSimulacion.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Asociados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
////        this.ListaAsociadosSimulacion.setModel(ModeloListaAsociados);
////        PanelListaAsociadosSimulacion.add(ListaAsociadosSimulacion);
//
//        JPanel panel_4 = new JPanel();
//        panel_4.setPreferredSize(new Dimension(10, 70));
//        PanelListaAsociadosSimulacion.add(panel_4, BorderLayout.SOUTH);
//        panel_4.setLayout(null);
//
//        JButton btnNuevaSimulacion = new JButton("Nueva Simulacion");
//        btnNuevaSimulacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        btnNuevaSimulacion.setActionCommand("NuevaSimulacion");
//        btnNuevaSimulacion.addActionListener(ControladorAnterior.getInstance());
//        btnNuevaSimulacion.setBounds(76, 10, 172, 39);
//        panel_4.add(btnNuevaSimulacion);
//
//        JPanel PanelDatosSimulacion = new JPanel();
//        PanelSimulacion.add(PanelDatosSimulacion);
//        PanelDatosSimulacion.setLayout(new BorderLayout(0, 0));
//
//        JPanel PanelBotonIniciar = new JPanel();
//        PanelBotonIniciar.setPreferredSize(new Dimension(10, 70));
//        PanelDatosSimulacion.add(PanelBotonIniciar, BorderLayout.SOUTH);
//        PanelBotonIniciar.setLayout(null);
//
//        JButton btnComenzarSimulacion = new JButton("Comenzar Simulacion");
//        btnComenzarSimulacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        btnComenzarSimulacion.setActionCommand("ComenzarSimulacion");
//        btnComenzarSimulacion.addActionListener(ControladorAnterior.getInstance());
//        btnComenzarSimulacion.setBounds(79, 10, 172, 39);
//        PanelBotonIniciar.add(btnComenzarSimulacion);
//
//        JPanel PanelDatosSep = new JPanel();
//        PanelDatosSimulacion.add(PanelDatosSep, BorderLayout.CENTER);
//        PanelDatosSep.setLayout(new GridLayout(2, 0, 0, 0));
//
//        JPanel panel_3 = new JPanel();
//        PanelDatosSep.add(panel_3);
//        panel_3.setLayout(null);
//
//        JLabel lblNewLabel = new JLabel("Asociado");
//        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        lblNewLabel.setBounds(10, 10, 90, 29);
//        panel_3.add(lblNewLabel);
//
//        CantidadSolicitudesAsociado = new JTextField();
//        CantidadSolicitudesAsociado.setBounds(200, 78, 110, 29);
//        panel_3.add(CantidadSolicitudesAsociado);
//        CantidadSolicitudesAsociado.setColumns(10);
//
//        JLabel lblNewLabel_1 = new JLabel("Cantidad de solicitudes");
//        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lblNewLabel_1.setBounds(26, 76, 164, 29);
//        panel_3.add(lblNewLabel_1);
//
//        JButton btnAñadirSolicitud = new JButton("Añadir");
//        btnAñadirSolicitud.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        btnAñadirSolicitud.setActionCommand("AñadirSolicitud");
//        btnAñadirSolicitud.addActionListener(ControladorAnterior.getInstance());
//        btnAñadirSolicitud.setBounds(202, 167, 97, 29);
//        panel_3.add(btnAñadirSolicitud);
//
//        JPanel panel_2 = new JPanel();
//        PanelDatosSep.add(panel_2);
//        panel_2.setLayout(null);
//
//        JLabel lblOperario = new JLabel("Operario");
//        lblOperario.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        lblOperario.setBounds(10, 10, 90, 29);
//        panel_2.add(lblOperario);
//
//        CantidadSolicitudesOperario = new JTextField();
//        CantidadSolicitudesOperario.setColumns(10);
//        CantidadSolicitudesOperario.setBounds(200, 78, 110, 29);
//        panel_2.add(CantidadSolicitudesOperario);
//
//        JLabel lblNewLabel_1_1 = new JLabel("Cantidad de solicitudes");
//        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lblNewLabel_1_1.setBounds(26, 78, 164, 29);
//        panel_2.add(lblNewLabel_1_1);
//
//        JPanel PanelMuestraSimulacion = new JPanel();
//        PanelSimulacion.add(PanelMuestraSimulacion);
//        PanelMuestraSimulacion.setLayout(new BorderLayout(0, 0));
//
//
//        textPane = new JTextPane();
//        textPane.setPreferredSize(new Dimension(330, 19));
//        //PanelMuestraSimulacion.add(textPane, BorderLayout.SOUTH);
//
//        JScrollPane scrollPane = new JScrollPane();
//        scrollPane.setViewportView(textPane);
//        PanelMuestraSimulacion.add(scrollPane, BorderLayout.EAST);
//
//        this.setMinimumSize(new Dimension(900, 600));
//        this.setVisible(true);
//    }
//
//    @Override
//    public Paciente getPacienteFacturacion() {
//        return this.ListaPacientesFacturacion.getSelectedValue();
//    }
//
//    @Override
//    public IMedico getMedicoFacturacion() {
//        return (IMedico) this.Medico.getSelectedItem();
//    }
//
//    @Override
//    public int getCantidadConsultasFacturacion() {
//        String aux = this.NumeroConsultas.getText();
//        if (checkValidityNumber(aux)) {
//            return Integer.parseInt(aux);
//        } else {
//            return 0;
//        }
//        //return Integer.parseInt(this.NumeroConsultas.getText());
//    }
//
//    @Override
//    public Habitacion getHabitacionFacturacion() {
//        return (Habitacion) this.TipoHabitacion.getSelectedItem();
//    }
//
//    @Override
//    public int getCantidadDiasInternacionFacturacion() {
//        String aux = this.DiasInternacion.getText();
//        if (checkValidityNumber(aux)) {
//            return Integer.parseInt(aux);
//        } else {
//            return 0;
//        }
//        //return Integer.parseInt(this.DiasInternacion.getText());
//    }
//
//    @Override
//    public void valueChanged(ListSelectionEvent e) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void actualizarListaPacientesFacturacion(Iterator<Paciente> iterator) {
//        this.ModeloListaPacientesFacturacion.clear();
//        while (iterator.hasNext()) {
//            this.ModeloListaPacientesFacturacion.addElement(iterator.next());
//        }
//        this.repaint();
//    }
//
//    @Override
//    public void actualizarComboMedicosFacturacion(Iterator<IMedico> iterator) {
//        while (iterator.hasNext()) {
//            this.Medico.addItem(iterator.next());
//        }
//    }
//
//    @Override
//    public void actualizarComboHabitacionesFacturacion(Iterator<Habitacion> iterator) {
//        while (iterator.hasNext()) {
//            this.TipoHabitacion.addItem(iterator.next());
//        }
//    }
//
//    @Override
//    public void MostrarFactura(String detalle) {
//        this.TextoFactura.setText("");
//        this.TextoFactura.setText(detalle);
//    }
//
////    @Override
////    public void actualizarListaAsociados(Iterator<Asociado> iterator) {
////        this.ModeloListaAsociados.clear();
////        while (iterator.hasNext()) {
////            this.ModeloListaAsociados.addElement(iterator.next());
////        }
////        this.repaint();
////    }
//
//    @Override
//    public String getNombreAsociado() {
//        String aux = this.NombreAsociado.getText();
//        if (checkValidityString(aux)) {
//            return aux;
//        } else {
//            return null;
//        }
//        //return this.NombreAsociado.getText();
//    }
//
//    @Override
//    public String getApellidoAsociado() {
//        String aux = this.ApellidoAsociado.getText();
//        if (checkValidityString(aux)) {
//            return aux;
//        } else {
//            return null;
//        }
//        //return this.ApellidoAsociado.getText();
//    }
//
//    @Override
//    public int getDNIAsociado() {
//        String aux = this.DNIAsociado.getText();
//        if (checkValidityNumber(aux)) {
//            return Integer.parseInt(aux);
//        } else {
//            return -1;
//        }
//        //return Integer.parseInt(this.DNIAsociado.getText());
//    }
//
//    @Override
//    public String getDireccionAsociado() {
//        String aux = this.DomicilioAsociado.getText();
//        if (checkValidityStringDomicilio(aux)) {
//            return aux;
//        } else {
//            return null;
//        }
//        //return this.DomicilioAsociado.getText();
//    }
//
//    @Override
//    public Long getTelefonoAsociado() {
//        String aux = this.TelefonoAsociado.getText();
//        if (checkValidityLongNumber(aux)) {
//            return Long.parseLong(aux);
//        } else {
//            return (long) 0;
//        }
//        //return Integer.parseInt(this.TelefonoAsociado.getText());
//    }
//
//    @Override
//    public int getDNIAsociadoAEliminar() {
//        String aux = this.DNIAsociadoAEliminar.getText();
//        if (checkValidityNumber(aux)) {
//            return Integer.parseInt(aux);
//        } else {
//            return 0;
//        }
//        //return Integer.parseInt(this.DNIAsociadoAEliminar.getText());
//    }
//
////    @Override
////    public Asociado getAsociadoSimulacion() {
////        return this.ListaAsociadosSimulacion.getSelectedValue();
////    }
//
//    @Override
//    public int getCantidadSolicitudesAsociado() {
//        String aux = this.CantidadSolicitudesAsociado.getText();
//        if (checkValidityNumber(aux)) {
//            return Integer.parseInt(aux);
//        } else {
//            return 0;
//        }
//    }
//
//    @Override
//    public int getCantidadSolicitudesOperario() {
//        String aux = this.CantidadSolicitudesOperario.getText();
//        if (checkValidityNumber(aux)) {
//            return Integer.parseInt(aux);
//        } else {
//            return 0;
//        }
//        //return Integer.parseInt(this.CantidadSolicitudesOperario.getText());
//    }
//
//    @Override
//    public JTextPane getTextPane() {
//        return this.textPane;
//    }
//
//    @Override
//    public void addActionListener(ActionListener actionListener) {
//        // TODO Auto-generated method stub
//
//    }
//
//    private boolean checkValidityNumber(String text) {
//        if (text.equals("")) {
//            JOptionPane.showMessageDialog(null, "Debe ingresar un valor");
//            return false;
//        }
//        try {
//            Integer.parseInt(text);
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(null, "Ingrese un numero");
//            return false;
//        }
//        return true;
//    }
//
//    private boolean checkValidityLongNumber(String text) {
//        if (text.equals("")) {
//            JOptionPane.showMessageDialog(null, "Debe ingresar un valor");
//            return false;
//        }
//        try {
//            Long.parseLong(text);
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(null, "Ingrese un numero");
//            return false;
//        }
//        return true;
//    }
//
//    private boolean checkValidityString(String text) {
//        if (text.equals("")) {
//            JOptionPane.showMessageDialog(null, "Debe ingresar un valor");
//            return false;
//        }
//        //if(text.matches("[a-zA-Z\s]+")) {     por un bug en InteliJ no funciona esta expresion regular
//        if (text.matches("[a-zA-Z]+")) {
//            return true;
//        } else {
//            JOptionPane.showMessageDialog(null, "Ingrese una cadena de texto");
//            return false;
//        }
//    }
//
//    private boolean checkValidityStringDomicilio(String text) {
//        if (text.equals("")) {
//            JOptionPane.showMessageDialog(null, "Debe ingresar un valor");
//            return false;
//        }
//        //if(text.matches("[a-zA-Z0-9\s]+")) {     por un bug en InteliJ no funciona esta expresion regular
//        if (text.matches("[a-zA-Z0-9]+")) {
//            return true;
//        } else {
//            JOptionPane.showMessageDialog(null, "Ingrese una cadena de texto");
//            return false;
//        }
//    }
//
//    public void habilitarBotonesFactura(boolean habilita) {
//        this.BotonAñadirConsulta.setEnabled(habilita);
//        this.BotonAñadirInternacion.setEnabled(habilita);
//        this.BotonFinalizarFactura.setEnabled(habilita);
//    }
//
//
//}
