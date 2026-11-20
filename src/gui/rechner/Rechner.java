package gui.rechner;

import global.Workable;

import javax.swing.*;

public class Rechner extends JFrame    {

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
        setBounds(0,0,240,230);
        setContentPane(panel);
        setResizable(false);

        panel.setLayout(null); // Feste Positionen

        lblZahl1 = new JLabel("Zahl 1");
        lblZahl1.setBounds(10,10,100,25);
        panel.add(lblZahl1);

        lblZahl2 = new JLabel("Zahl 2");
        lblZahl2.setBounds(10,40,100,25);
        panel.add(lblZahl2);

        lblErgebnis = new JLabel("Ergebnis");
        lblErgebnis.setBounds(10,70,100,25);
        panel.add(lblErgebnis);

        txtZahl1 = new JTextField();
        txtZahl1.setBounds(120,10,100,25);
        panel.add(txtZahl1);

        txtZahl2 = new JTextField();
        txtZahl2.setBounds(120,40,100,25);
        panel.add(txtZahl2);

        txtErgebnis = new JTextField();
        txtErgebnis.setEditable(false);
        txtErgebnis.setBounds(120,70,100,25);
        panel.add(txtErgebnis);

        btnAdd = new JButton("+");
        btnAdd.setBounds(10,100,100,25);
        panel.add(btnAdd);

        btnSub = new JButton("-");
        btnSub.setBounds(120,100,100,25);
        panel.add(btnSub);

        btnMul = new JButton("x");
        btnMul.setBounds(10,130,100,25);
        panel.add(btnMul);

        btnDiv = new JButton("/");
        btnDiv.setBounds(120,130,100,25);
        panel.add(btnDiv);

        btnClose = new JButton("Close");
        btnClose.setBounds(10,160,210,25);
        panel.add(btnClose);


    }

    public static void main() {
        SwingUtilities.invokeLater( () -> {
            Rechner rechner = new Rechner();
        });
    }

}
