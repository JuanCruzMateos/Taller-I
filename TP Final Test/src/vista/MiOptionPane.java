package vista;

import javax.swing.*;
import java.awt.*;

public class MiOptionPane implements InterfazOptionPanel {

    public MiOptionPane() {
        super();
    }

    public void ShowMessage(Component parent, String mensaje) {
        JOptionPane.showMessageDialog(parent, mensaje);
    }
}
