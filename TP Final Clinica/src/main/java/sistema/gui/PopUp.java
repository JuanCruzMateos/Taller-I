package sistema.gui;

import javax.swing.*;
import java.awt.*;

public class PopUp implements InterfazOptionPane {

    @Override
    public void showMessageDialog(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message);
    }

}
