package oopgrundlagen;

public class Katze extends Tier {

    private int klauen;
    private boolean istFreigaenger;

    public Katze(int nummer, String farbe, int klauen, boolean istFreigaenger) {
        super(nummer, farbe);
        this.klauen = klauen;
        this.istFreigaenger = istFreigaenger;
    }

    @Override
    public void laufen(int distanz) {
        if(distanz > 0 && energie > distanz) {
            energie -= distanz;
            System.out.println("Katze " +  getName() + " läuft " + distanz + " Meter"  );
        } else {
            System.out.println("Katze %s ist erschöpft".formatted(getName()));
        }
    }

    @Override
    public void fressen(int menge) {
        if(menge > 0) {
            energie += menge; // Feld energie in Tier auf protected setzen
            // protected setEnergie(...) in Tier einfügen
            System.out.printf("Katze %s frisst %d Gramm\n",getName(),menge);
        }
    }

    @Override
    public void schreien() {
        System.out.println("Miau Miau");
    }

    @Override
    public String toString() {
        return "Katze{" +
                super.toString()+
                "klauen='" + klauen  + '\'' +
                "istFreigaenger, =" + istFreigaenger +
                '}';
    }
}
