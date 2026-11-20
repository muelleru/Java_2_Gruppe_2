package gui.wetterapp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PnlMain {


    private JPanel pnlMain;
    private JTable tblWetterdaten;
    private JButton btnLoadDb;
    private JButton btnSpeichernCSV;
    private JButton btnLoadCSV;
    private WetterdatenTableModel model;
    public PnlMain() {
        // Einfache
        // tblWetterdaten.setModel( new DefaultTableModel(new String[]{"Vorname","Nachname"},10));
        model = new WetterdatenTableModel();
        tblWetterdaten.setModel(model);
        model.fireTableDataChanged();
    }

    public JPanel getPnlMain() {
        return pnlMain;
    }



}
