package gui.wetterapp;

import db.Wetterdaten;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class WetterdatenTableModel extends AbstractTableModel {

    private ArrayList<Wetterdaten> wetterdatenArrayList;

    public WetterdatenTableModel() {
        wetterdatenArrayList = new ArrayList<>();
    }

    public void setDaten(Collection<Wetterdaten> wdliste) {
        wetterdatenArrayList.clear();
        wetterdatenArrayList.addAll(wdliste);
        fireTableDataChanged();
    }
    public Collection<Wetterdaten> getDaten() {
        return wetterdatenArrayList;
    }



    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        // oder über Wetterdaten.class
       return switch(column) {
           case 0 -> "YYYY";
           case 1 -> "MM";
           case 2 -> "Rain";
           case 3 -> "Sun";
           case 4 -> "TMax";
           case 5 -> "TMin";
           case 6 -> "Af";
           default -> "";
       };
    }

    @Override
    public int getRowCount() {
        return wetterdatenArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Wetterdaten wd = wetterdatenArrayList.get(rowIndex);
        return switch(columnIndex) {
            case 0 -> wd.getYyyy();
            case 1 -> wd.getMm();
            case 2 -> wd.getRain();
            case 3 -> wd.getSun();
            case 4 -> wd.getTmax();
            case 5 -> wd.getTmin();
            case 6 -> wd.getAf();
            default -> "";
        };
    }
}
