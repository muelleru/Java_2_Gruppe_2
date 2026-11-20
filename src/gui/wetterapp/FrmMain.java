package gui.wetterapp;

import javax.swing.*;

public class FrmMain extends JFrame {

    private PnlMain pnlMain;

    public FrmMain() {
        setBounds(10,10,1024,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public PnlMain getPnlMain() {
        return pnlMain;
    }
    public FrmMain setPnlMain(PnlMain pnlMain) {
        this.pnlMain = pnlMain;
        setContentPane(pnlMain.getPnlMain());
        return this;
    }

}
