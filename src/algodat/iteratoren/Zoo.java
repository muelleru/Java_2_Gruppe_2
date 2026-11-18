package algodat.iteratoren;

import oopgrundlagen.tiere.Tier;

import java.util.ArrayList;

// Decorator-Pattern (Entwurfsmuster)

public class Zoo {

    private ArrayList<Tier> tiere;

    public Zoo() {
        tiere = new ArrayList<>();
    }

    public boolean removeTier(Tier t) {
        return tiere.remove(t);
    }

    public void addTier(Tier t) {
        // Delegation an ArrayList::add
        tiere.add(t);
    }
}
