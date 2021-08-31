package org.vista;

import javax.swing.*;

public class Ventana extends JFrame implements IVistaMain {
    private JTextField cant_litros_txt;
    private JTextField cargar_litros_txt;
    private JButton cargar_btn;
    private JButton btn_activarM1;
    private JButton btn_detenerM1;
    private JTextField textField1;
    private JButton btn_activarM2;
    private JButton detenerButton;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JPanel root_jpane;

    public Ventana() {
        this.add(this.root_jpane);
        this.setTitle("Surtidor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 650, 400);
        this.setVisible(true);
    }

    @Override
    public void inicializarSurtidor(double carga) {

    }

    @Override
    public void cargarSurtidor(double carga) {

    }

    @Override
    public void desgargaManguera1() {

    }

    @Override
    public void desgargaManguera2() {

    }

    @Override
    public double getExistenciaDeposito() {
        return 0;
    }

    @Override
    public double getAcumuladoManguera1() {
        return 0;
    }

    @Override
    public double getAcumuladoManguera2() {
        return 0;
    }

    @Override
    public double getUltimaVentaManguera1() {
        return 0;
    }

    @Override
    public double getUltimaVentaManguera2() {
        return 0;
    }
}
