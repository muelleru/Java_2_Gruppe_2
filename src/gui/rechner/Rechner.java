package gui.rechner;

import global.Workable;
import gui.wetterapp.FrmMain;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.EventHandler;
import java.util.EventListener;

public class Rechner extends JFrame {

    private JPanel panel;

    private JLabel lblZahl1;
    private JTextField txtZahl1;

    private JLabel lblZahl2;
    private JTextField txtZahl2;

    private JLabel lblErgebnis;
    private JTextField txtErgebnis;

    private JButton btnAdd;
    private JButton btnSub;
    private JButton btnMul;
    private JButton btnDiv;
    private JButton btnClose;

    public Rechner() {
        panel = new JPanel();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0, 0, 240, 230);
        setContentPane(panel);
        setResizable(false);

        ActionListener listener = (e) -> {
            double z1 = 0;
            double z2 = 0;
            //JButton tmp = (JButton)e.getSource();
            if (e.getSource() instanceof JButton tmp) {
                // e.getSource() == btnAdd
                try {
                    z1 = Double.parseDouble(txtZahl1.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Fehler in Zahl 1", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                     z2 = Double.parseDouble(txtZahl2.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Fehler in Zahl 2", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                double ergebnis = 0.0;
                switch (tmp.getText()) {
                    case "+":
                        ergebnis = z1 + z2;
                        break;
                    case "/":
                        ergebnis = z1 / z2;
                        break;
                    case "-":
                        ergebnis = z1 - z2;
                        break;
                    case "x":
                        ergebnis = z1 * z2;
                        break;
                }
                txtErgebnis.setText(Double.toString(ergebnis));
            }
        };

        panel.setLayout(null); // Feste Positionen

        lblZahl1 = new JLabel("Zahl 1");
        lblZahl1.setBounds(10, 10, 100, 25);
        panel.add(lblZahl1);

        lblZahl2 = new JLabel("Zahl 2");
        lblZahl2.setBounds(10, 40, 100, 25);
        panel.add(lblZahl2);

        lblErgebnis = new JLabel("Ergebnis");
        lblErgebnis.setBounds(10, 70, 100, 25);
        panel.add(lblErgebnis);

        txtZahl1 = new JTextField();
        txtZahl1.setBounds(120, 10, 100, 25);
        panel.add(txtZahl1);

        txtZahl2 = new JTextField();
        txtZahl2.setBounds(120, 40, 100, 25);
        panel.add(txtZahl2);

        txtErgebnis = new JTextField();
        txtErgebnis.setEditable(false);
        txtErgebnis.setBounds(120, 70, 100, 25);
        panel.add(txtErgebnis);

        btnAdd = new JButton("+");
        btnAdd.setBounds(10, 100, 100, 25);
        btnAdd.addActionListener(listener);
        panel.add(btnAdd);

        btnSub = new JButton("-");
        btnSub.setBounds(120, 100, 100, 25);
        btnSub.addActionListener(listener);
        panel.add(btnSub);

        btnMul = new JButton("x");
        btnMul.setBounds(10, 130, 100, 25);
        btnMul.addActionListener(listener);
        panel.add(btnMul);

        btnDiv = new JButton("/");
        btnDiv.setBounds(120, 130, 100, 25);
        btnDiv.addActionListener(listener);
        panel.add(btnDiv);

        btnClose = new JButton("Close");
        btnClose.setBounds(10, 160, 210, 25);
        btnClose.addActionListener( (e) -> {
           // Zugriff auf Frame:  Rechner.this
            JOptionPane.showMessageDialog(Rechner.this,this.getClass().getName());
           dispatchEvent(new WindowEvent(Rechner.this, WindowEvent.WINDOW_CLOSING));
        });
        panel.add(btnClose);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(Rechner.this,"BYE BYE ...");
            }
        });
    }

    public static void main() {

        SwingUtilities.invokeLater(() -> {
            Rechner rechner = new Rechner();
        });
    }

}
