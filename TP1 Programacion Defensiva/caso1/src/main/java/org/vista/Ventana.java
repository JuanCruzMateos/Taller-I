package org.vista;

import org.controlador.Controlador;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Interfaz de usuario de la aplicacion.<br>
 */
public class Ventana extends JFrame implements IVista {
    private JTextField textField_cantMesas;
    private JButton abrirButton;
    private JButton ocuparButton;
    private JButton cerrarButton;
    private JTextField textField_nroMesaOcupar;
    private JTextField textField_nroMesaCerrar;
    private JPanel rootPanel;

    public Ventana() {
        this.add(this.rootPanel);
        this.setTitle("Beer House");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.abrirButton.setActionCommand("Abrir");
        this.ocuparButton.setActionCommand("Ocupar");
        this.cerrarButton.setActionCommand("Cerrar");
        this.abrirButton.addActionListener(Controlador.getInstance());
        this.cerrarButton.addActionListener(Controlador.getInstance());
        this.ocuparButton.addActionListener(Controlador.getInstance());
        this.setBounds(400, 250, 500, 150);
        this.setVisible(true);
    }

    /**
     * Lee el dato ingresado por el usuario y retorna la cantidad de mesas a abrir.<br>
     *
     * @return la cantidad de mesas a abrir.<br>
     */
    @Override
    public int abrirLocal() {
        return Integer.parseInt(this.textField_cantMesas.getText());
    }

    /**
     * Lee el dato ingresado por el usuario y retorna la mesa a cerrar.<br>
     *
     * @return nro de mesa a cerrar.<br>
     */
    @Override
    public int cerrarMesa() {
        return Integer.parseInt(this.textField_nroMesaCerrar.getText());
    }

    /**
     * Lee el dato ingresado por el usuario y retorna la mesa a ocupar.<br>
     *
     * @return nro de mesa a ocupar.<br>
     */
    @Override
    public int ocuparMesa() {
        return Integer.parseInt(this.textField_nroMesaOcupar.getText());
    }

    @Override
    public void resetTextFieldAbrir() {
        this.textField_cantMesas.setText(null);
    }

    @Override
    public void resetTextFieldOcupar() {
        this.textField_nroMesaOcupar.setText(null);
    }

    @Override
    public void resetTextFieldCerrar() {
        this.textField_nroMesaCerrar.setText(null);
    }
}
