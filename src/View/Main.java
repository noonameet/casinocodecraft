package View;

import Controller.Controllering;
import View.ingredientes;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ingredientes view = new ingredientes();
            Controllering controller = new Controllering(view);
            view.setVisible(true);
        });
    }
}


