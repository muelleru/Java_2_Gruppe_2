package uebungen.narren;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class NaerrischeWirtschaft {

    private ArrayList<Produkt> shop;
    private ArrayList<Produkt> besitz;
    private ArrayList<Produkt> reihenfolge;

    public NaerrischeWirtschaft() {
        shop = new ArrayList<>(List.of(
                new Produkt("A", 340),
                new Produkt("B", 670),
                new Produkt("C", 790),
                new Produkt("D", 1320),
                new Produkt("E", 2100),
                new Produkt("F", 5500)
        ));
        reihenfolge = new ArrayList<>(shop);
        reihenfolge.sort((x,y)->y.getPreis()-x.getPreis());

        besitz = new ArrayList<>();
    }

    public int allesVerkaufen() {
        int wert = 0;
        besitz.sort((x,y)->y.getPreis()-x.getPreis());
        ArrayList<Produkt> loeschen = new ArrayList<>();
        for (var p : besitz) {
            // teuerste Artikel nicht verkaufen
            // wenn wir schon den teuersten und zweitteursten haben, dann die nicht verkaufen ...
            // usw ..
            if(besitz.indexOf(p) != reihenfolge.indexOf(p)) {
                wert += p.getPreis();
                shop.add(p);
                System.out.println("Verkaufe " + p);
                loeschen.add(p);
            }
        }
        besitz.removeAll(loeschen);
        return wert;
    }

    public int kaufen(int etat) {
        int kaufpreis=0;
        shop.sort((x,y)->y.getPreis()-x.getPreis());
        for(Produkt p : shop) {
            if(etat >= p.getPreis()) {
                besitz.add(p);
                kaufpreis+=p.getPreis();
                etat-=p.getPreis();
                System.out.println("Kaufe " + p);
            }
        }
        for(Produkt p : besitz) {
            shop.remove(p);
        }
return kaufpreis;
    }


    public static void main() {

        NaerrischeWirtschaft    nw = new NaerrischeWirtschaft();
        nw.run();

    }
    public void run() {
        int etat =0;
        int runde = 1;
        while(shop.size() > 0) {
            System.out.println("Runde " + runde++);
            System.out.println("Besitz: " + besitz);
            etat+=1000;
            etat+=allesVerkaufen();
            System.out.println("Meine Etat: " + etat);
            etat-=kaufen(etat);
            System.out.println("Kaufe Eis für "  + etat);
            etat = 0;
        }
        System.out.println("**** FERTIG ****");
        System.out.println("Besitz: " + besitz);
    }


}
