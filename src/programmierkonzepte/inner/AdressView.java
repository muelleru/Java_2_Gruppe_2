package programmierkonzepte.inner;

public interface AdressView {
    String getPlz();
    AdressView setPlz(String plz);
    String getOrt() ;
    AdressView setOrt(String ort) ;
    String getStrasse();
    AdressView setStrasse(String strasse);
    String getHausnummer();
    AdressView setHausnummer(String hausnummer);
}
