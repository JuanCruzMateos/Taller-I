package org.vista;

import org.modelo.Manguera;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * No usado.<br>
 */
@SuppressWarnings("deprecation")
public class ObservadorManguera extends JTextField implements Observer {
    private JTextField jTextField;
    private Manguera manguera;

    public ObservadorManguera() {
        // Necesario -> xq?
    }

    public ObservadorManguera(Manguera manguera) {
        this.jTextField = new JTextField();
        this.manguera = manguera;
        this.manguera.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o == this.manguera) {
            this.jTextField.setText(String.valueOf(this.manguera.getAcumulado()));
        } else {
            throw new IllegalArgumentException();
        }
    }
}
