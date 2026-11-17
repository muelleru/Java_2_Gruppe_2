package programmierkonzepte.designpatterns.fahrzeuge;
public class Lastwagen extends Fahrzeug {
    private int lademenge;
    protected Lastwagen(String hersteller, String typ, int lademenge) {
        super(hersteller, typ);
        this.lademenge = lademenge;
    }
}
