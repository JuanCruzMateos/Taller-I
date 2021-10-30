package sistema.gui;

import javax.swing.*;
import java.awt.*;

public class PopUp implements InterfazOptionPane {
    @Override
    public void showMessageDialog(Component parentComponent, Object message, String title, int messageType) {
        JOptionPane.showMessageDialog(parentComponent, message, title, messageType);
    }
}
