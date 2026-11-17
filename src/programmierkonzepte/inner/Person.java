package programmierkonzepte.inner;

public class Person {

    public enum Geschlecht {
        Weiblich, Maennlich, Divers;
    }
    public enum Farbe {
        Rot, Grün, Blau;
    }

    // Innere Klasse
    private static class Adresse implements AdressView {
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

        public String getPlz() {
            return plz;
        }

        public Adresse setPlz(String plz) {
            this.plz = plz;
            return this;
        }

        public String getOrt() {
            return ort;
        }

        public Adresse setOrt(String ort) {
            this.ort = ort;
            return this;
        }

        public String getStrasse() {
            return strasse;
        }

        public Adresse setStrasse(String strasse) {
            this.strasse = strasse;
            return this;
        }

        public String getHausnummer() {
            return hausnummer;
        }

        public Adresse setHausnummer(String hausnummer) {
            this.hausnummer = hausnummer;
            return this;
        }
    }

    private String vorname;
    private String nachname;
    // Adresse
    private Adresse adresse;
    private Geschlecht geschlecht;

    //public Person(String vorname, String nachname, Adresse adresse) {
    public Person(String vorname, String nachname,
                  String plz, String ort, String strasse, String hausnummer) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = new Adresse(plz, ort, strasse, hausnummer);
    }

    public String getVorname() {
        return vorname;
    }

    public Person setVorname(String vorname) {
        this.vorname = vorname;
        return this;
    }

    public String getNachname() {
        return nachname;
    }

    public Person setNachname(String nachname) {
        this.nachname = nachname;
        return this;
    }

    public AdressView getAdresse() {
        return adresse;
    }

//    public Person setAdresse(Adresse adresse) {
//        this.adresse = adresse;
//        return this;
//    }

}
