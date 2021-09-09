package org.vista;

import org.controlador.Controlador;

import javax.swing.*;

/**
 * Ventana principal.<br>
 */
public class Ventana extends JFrame implements IVistaMain {
    private JTextField cant_litros_txt;
    private JTextField cargar_litros_txt;
    private JButton cargar_btn;
    private JButton btn_activarM1;
    private JButton btn_detenerM1;
    //    private ObservadorManguera txt_acumuladoM1;
    private JTextField txt_acumuladoM1;
    private JButton btn_activarM2;
    private JButton btn_detenerM2;
    private JTextField txt_acumuladoM2;
    //    private ObservadorManguera txt_acumuladoM2;
    private JTextField txt_ultimaM1;
    private JTextField txt_ultimaM2;
    private JPanel root_jpane;

    public Ventana() {
        this.add(this.root_jpane);
        this.setTitle("Surtidor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.txt_acumuladoM1 = new ObservadorManguera(m1);
//        this.txt_acumuladoM2 = new ObservadorManguera(m2);
        this.cargar_btn.setActionCommand("cargar");
        this.btn_activarM1.setActionCommand("activarM1");
        this.btn_activarM2.setActionCommand("activarM2");
        this.btn_detenerM1.setActionCommand("detenerM1");
        this.btn_detenerM2.setActionCommand("detenerM2");
        this.btn_activarM1.addActionListener(Controlador.getInstance());
        this.btn_activarM2.addActionListener(Controlador.getInstance());
        this.btn_detenerM1.addActionListener(Controlador.getInstance());
        this.btn_detenerM2.addActionListener(Controlador.getInstance());
        this.cargar_btn.addActionListener(Controlador.getInstance());
        this.setBounds(375, 200, 400, 400);
        this.setVisible(true);
    }

    @Override
    public double cargarSurtidor() {
        return Double.parseDouble(this.cargar_litros_txt.getText());
    }

    @Override
    public void activaManguera1() {
        // Accion resuelta con el boton correspondiente.
    }

    @Override
    public void activaManguera2() {
        // Accion resuelta con el boton correspondiente.
    }

    @Override
    public void desactivaManguera1() {
        // Accion resuelta con el boton correspondiente.
    }

    @Override
    public void desactivaManguera2() {
        // Accion resuelta con el boton correspondiente.
    }

    @Override
    public void setCombustible(double cantidad) {
        this.cant_litros_txt.setText(String.valueOf(cantidad));
    }

    @Override
    public void setAcumuladoM1(double cantidad) {
        this.txt_acumuladoM1.setText(String.valueOf(cantidad));
    }

    @Override
    public void setAcumuladoM2(double cantidad) {
        this.txt_acumuladoM2.setText(String.valueOf(cantidad));
    }


    @Override
    public void visible(boolean b) {
        this.setVisible(b);
    }

    @Override
    public void refresh() {
        this.cargar_litros_txt.setText(null);
    }

    @Override
    public void setUltimaVentaM2(double ultimaVentaMG2) {
        this.txt_ultimaM2.setText(String.valueOf(ultimaVentaMG2));
    }

    @Override
    public void setUltimaVentaM1(double ultimaVentaMG1) {
        this.txt_ultimaM1.setText(String.valueOf(ultimaVentaMG1));
    }
}
