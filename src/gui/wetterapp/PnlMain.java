package gui.wetterapp;

import db.WetterDb;
import db.Wetterdaten;
import db.WetterdatenIO;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

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
       // model.fireTableDataChanged();
        btnLoadDb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Nachrichten von WetterDB in MessageBox anzeigen
                // WetterDb.setMessager( (x)->JOptionPane.showMessageDialog(pnlMain.getRootPane(),x));
                try(WetterDb db = new WetterDb()) {
                    Collection<Wetterdaten> wdliste = db.getWetterdaten();
                    model.setDaten(wdliste);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(pnlMain.getRootPane(),"Error " + ex.getMessage());
                }

            }
        });
        btnSpeichernCSV.addActionListener((e)->{
            JFileChooser fileDialog = new JFileChooser();
            fileDialog.setDialogType(JFileChooser.SAVE_DIALOG);
            fileDialog.setCurrentDirectory(new File("c:\\temp"));

            fileDialog.setFileFilter(
                    new FileNameExtensionFilter("CSV-Dateien (*.csv)", "csv")
            );
            fileDialog.addChoosableFileFilter(new FileNameExtensionFilter("Textdateien (*.txt)","txt"));

            // Auswahl „Alle Dateien“ deaktivieren
            fileDialog.setAcceptAllFileFilterUsed(false);

            if(fileDialog.showDialog(pnlMain.getRootPane(),"Speichern") ==
                    JFileChooser.APPROVE_OPTION) {
                String filename = fileDialog.getSelectedFile().getPath();
                try {
                    WetterdatenIO.getInstance().saveWetterdaten(model.getDaten(), filename);
                    JOptionPane.showMessageDialog(pnlMain.getRootPane(),"Daten gespeichert");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(pnlMain.getRootPane(),"Error: " + ex.getMessage());
                }
            }
        });
        btnLoadCSV.addActionListener((e)->{
            JFileChooser fileDialog = new JFileChooser();
            fileDialog.setDialogType(JFileChooser.OPEN_DIALOG);
            fileDialog.setCurrentDirectory(new File("c:\\temp"));

            fileDialog.setFileFilter(
                    new FileNameExtensionFilter("CSV-Dateien (*.csv)", "csv")
            );
            fileDialog.addChoosableFileFilter(new FileNameExtensionFilter("Textdateien (*.txt)","txt"));

            // Auswahl „Alle Dateien“ deaktivieren
            fileDialog.setAcceptAllFileFilterUsed(false);

            if(fileDialog.showDialog(pnlMain.getRootPane(),"Laden") ==
                    JFileChooser.APPROVE_OPTION) {
                String filename = fileDialog.getSelectedFile().getPath();
                try {
                    WetterdatenIO.getInstance().loadWetterdaten(model.getDaten(), filename);
                    JOptionPane.showMessageDialog(pnlMain.getRootPane(),"Daten geladen");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(pnlMain.getRootPane(),"Error: " + ex.getMessage());
                }
            }


        });
    }

    public JPanel getPnlMain() {
        return pnlMain;
    }

}
