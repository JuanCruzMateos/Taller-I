package org.vista;

import javax.swing.*;

public class InitVentana extends JFrame implements IVistaInit {
    private JTextField textField1;
    private JButton btn_inicializar;
    private JPanel root_jpanel;

    public InitVentana() {
        this.add(this.root_jpanel);
        this.setTitle("Inicializar Surtidor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public double inicializaSurtidor() {
        return Double.parseDouble(this.textField1.getText());
    }
}
