package programmierkonzepte.inner;

public class Person {

    // Innere Klasse
    class Adresse {
        private String plz;
        private String ort;
        private String strasse;
        private String hausnummer;

        public Adresse(String plz, String ort, String strasse, String hausnummer) {
            this.plz = plz;
            this.ort = ort;
            this.strasse = strasse;
            this.hausnummer = hausnummer;
        }
    }

    private String vorname;
    private String nachname;
    // Adresse
    private Adresse adresse;

    public Person(String vorname, String nachname, Adresse adresse) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
    }

}
