package programmierkonzepte.designpatterns.fahrzeuge;

public class Fahrzeug {

    private String hersteller;
    private String typ;

    public static Fahrzeug createFahrzeug(String art,
                                          String hersteller,
                                          String typ) {
        Fahrzeug neu = null;
        switch (art) {
            case "Automobil":
                neu = new Automobil(hersteller,typ,4);
                break;
            case "Automobil_5_Sitze":
                neu = new Automobil(hersteller,typ,5);
                break;
            case "Automobil_7_Sitze":
                neu = new Automobil(hersteller,typ,5);
                break;
            case "Lastwagen":
                neu = new Lastwagen(hersteller,typ,20_000);
                break;
        }
        return neu;
    }

    protected Fahrzeug(String hersteller, String typ) {
        this.hersteller = hersteller;
        this.typ = typ;
    }
}
