package algodat.iteratoren;

import oopgrundlagen.tiere.Tier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// Decorator-Pattern (Entwurfsmuster)

public class Zoo implements Iterable<Tier>{

    private ArrayList<Tier> tiere;

    public Zoo() {
        tiere = new ArrayList<>();
    }

    public boolean removeTier(Tier t) {
        return tiere.remove(t);
    }


    public Tier removeTier(int  nummer) {
        Tier tmp = null;
        for(Tier t : tiere) {
            if(t.getNummer()==nummer) {
                tmp = t;
                break;
            }
        }
        tiere.remove(tmp);
        return tmp;
    }

    public Tier removeTier(String name) {
        Tier tmp = null;
        for(Tier t : tiere) {
            if(t.getName().equals(name)) {
                tmp = t;
                break;
            }
        }
        tiere.remove(tmp);
        return tmp;
    }

    public void addTier(Tier t) {
        // Delegation an ArrayList::add
        tiere.add(t);
    }




    // Alternative zu iterator()
    public Iterable<Tier> getTiere() {
        return tiere;
    }

    @Override
    public Iterator<Tier> iterator() {
        return tiere.iterator(); // Delegation
    }
}
