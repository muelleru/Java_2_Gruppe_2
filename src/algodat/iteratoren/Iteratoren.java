package algodat.iteratoren;

import global.Workable;

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
    }

    @Override
    public void doWork() {
        testIterator();
    }
}
