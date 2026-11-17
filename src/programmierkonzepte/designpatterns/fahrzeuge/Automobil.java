package programmierkonzepte.designpatterns.fahrzeuge;

public class Automobil extends Fahrzeug {

    private int sitzplaetze;
    protected Automobil(String hersteller, String typ, int sitzplaetze) {
        super(hersteller, typ);
        this.sitzplaetze = sitzplaetze;
    }
}
