package org.vista;

import org.controlador.Controlador;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

public class InitVentana extends JFrame implements IVistaInit {
    private JTextField textField1;
    private JButton btn_inicializar;
    private JPanel root_jpanel;

    public InitVentana() {
        this.add(this.root_jpanel);
        this.setTitle("Inicializar Surtidor");
        this.btn_inicializar.setActionCommand("inicializar");
        this.btn_inicializar.addActionListener(Controlador.getInstance());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500, 300, 400, 120);
        this.setVisible(true);
    }

    @Override
    public double inicializaSurtidor() {
        return Double.parseDouble(this.textField1.getText());
    }

    @Override
    public void resetField() {
        this.textField1.setText(null);
    }

    @Override
    public void visible(boolean b) {
        this.setVisible(b);
    }
}
