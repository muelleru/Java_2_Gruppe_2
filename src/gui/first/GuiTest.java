package gui.first;

import global.Workable;

import javax.swing.*;
import java.awt.*;

public class GuiTest implements Workable {

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void doWork() {
        // AWT/Swing
        // Asynchroner Start über invokeLater ...
        // Lambda-Ausdruck mit dem Startup-Code
        SwingUtilities.invokeLater(() -> {
            // JFrame => Ein Fenster
            JFrame frame = new JFrame("Fenstertitel");
            JPanel mainPanel = new JPanel();
            frame.setContentPane(mainPanel);
            frame.setBounds(100, 100, 640, 400); // Fenstergröße
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // FlowLayout
            // GridLayout     Tabelle
            // GridBagLayout  Tabelle mit mehr Funktionen
            // BorderLayout   5 Bereiche: Nord,Ost,West,Süd,Center
            // null           Feste Positionen

            mainPanel.setLayout(new GridLayout(3,2));
            mainPanel.add(new JLabel("Vorname"));
            JTextField txtVorname = new JTextField();
            mainPanel.add(txtVorname);
            mainPanel.add(new JLabel("Nachname"));
            JTextField txtNachname = new JTextField();
            mainPanel.add(txtNachname);


            frame.pack(); // auf min. Größe setzen ...

        });

    }


}
