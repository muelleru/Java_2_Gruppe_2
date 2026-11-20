package gui.wetterapp;

import global.Workable;

import javax.swing.*;

public class WetterApp implements Workable {

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void doWork() {

        SwingUtilities.invokeLater( () -> {
            FrmMain frame = new FrmMain();
            PnlMain panel = new PnlMain();
            frame.setPnlMain(panel);
        });

    }
}
