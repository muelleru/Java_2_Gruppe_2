package gui.first;

import global.Workable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

            mainPanel.setLayout(new GridLayout(3, 2, 10, 10));
            mainPanel.add(new JLabel("Vorname"));
            JTextField txtVorname = new JTextField();
            // txtVorname.setMinimumSize(new Dimension(100,50));
            mainPanel.add(txtVorname);
            mainPanel.add(new JLabel("Nachname"));
            JTextField txtNachname = new JTextField();
            mainPanel.add(txtNachname);
            JButton btnClear = new JButton("CLEAR");
            JButton btnOk = new JButton("OK");
            mainPanel.add(btnClear);
            mainPanel.add(btnOk);
            btnClear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int result = JOptionPane.showConfirmDialog(frame, "Alles löschen?",
                            "Daten löschen", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        // Textboxen löschen
                        txtNachname.setText("");
                        txtVorname.setText("");
                    }
                }
            });
            btnOk.addActionListener((e) -> {

                JOptionPane.showMessageDialog(frame,
                        "Vorname: " + txtVorname.getText() + "\n" +
                                "Nachname: " + txtNachname.getText());
            });
            frame.pack(); // auf min. Größe setzen ...
        });
    }
}