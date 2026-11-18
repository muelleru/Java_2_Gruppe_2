package algodat.iteratoren;

import global.Workable;
import oopgrundlagen.tiere.Hund;
import oopgrundlagen.tiere.Katze;
import oopgrundlagen.tiere.Tier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iteratoren implements Workable {
    @Override
    public boolean isActive() {
        return true;
    }


    public void testIterator() {

        // Iterator<T> ist eine Schnittstelle ...
        // Iterable<T> oberste Schnittstelle aller Collections
        // iterator() Funktion, die einen Iterator liefert
        ArrayList<String> liste = new ArrayList<>(List.of("Mannheim","Kaiserslautern","Freiburg",
                "Karlsruhe","Baden-Baden"));
        //for-each
        Iterator<String> it = liste.iterator();
        while(it.hasNext()) {
            String elem = it.next();
            if(elem.startsWith("Kais")) {
                it.remove();
            }
            System.out.println(elem);
        }
        System.out.println(liste);

        // Remove mit for-each
        ArrayList<String> removeListe = new ArrayList<>();
        for(String elem : liste) {
            if(elem.startsWith("Ma")) {
                removeListe.add(elem);
            }
        }
        for (String elem : removeListe)
        {
            liste.remove(elem);
        }
        System.out.println(liste);

        liste.removeIf( x-> x.startsWith("Ka") );
        System.out.println(liste);

    }

    public void testZoo() {
        Zoo wilhelma = new Zoo();
        wilhelma.addTier(new Katze(1,"grau",5,false).setName("Minka"));
        wilhelma.addTier(new Katze(2,"gelb",10,false).setName("Leo"));
        wilhelma.addTier(new Hund(3,"braun","Bernhardiner",true).setName("Bernhard"));

        for(Tier tier : wilhelma.getTiere()) {
            System.out.println(tier);
        }
        wilhelma.removeTier("Albert");
        Tier leo = wilhelma.removeTier("Leo");
        if(leo != null) {
            System.out.println("LEO IST FREI");
            leo.fressen(80000);
            System.out.println("LEO FRISST EINEN BESUCHER");
        } else {
            System.out.println("LEO ist nicht im Zoo?!");
        }
        wilhelma.forEach(System.out::println);
    }

    @Override
    public void doWork() {
        testZoo();
        //testIterator();
    }
}
