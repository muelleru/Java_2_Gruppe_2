package oopgrundlagen;

public class Hund extends Tier{

    private String rasse;
    private boolean apportiertGerne;

    public Hund(int nummer, String farbe, String rasse, boolean apportiertGerne) {
        super(nummer, farbe); // Tier-Konstruktor
        this.rasse = rasse;
        this.apportiertGerne = apportiertGerne;
    }

    @Override
    public void laufen(int distanz) {
        if(distanz > 0 && energie > distanz*2) {
            energie -= 2*distanz;
            System.out.println("Hund " +  getName() + " läuft " + distanz + " Meter"  );
        } else {
            System.out.println("Hund %s ist erschöpft".formatted(getName()));
        }
    }

    @Override
    public void fressen(int menge) {
        if(menge > 0) {
            energie += menge; // Feld energie in Tier auf protected setzen
                              // protected setEnergie(...) in Tier einfügen
            System.out.printf("Hund %s frisst %d Gramm\n",getName(),menge);
        }
    }

    @Override
    public void schreien() {
        System.out.println("Wuff Wuff");
    }

    @Override
    public String toString() {
        return "Hund{" +
                super.toString()+
                "rasse='" + rasse + '\'' +
                ", apportiertGerne=" + apportiertGerne +
                '}';
    }
}
