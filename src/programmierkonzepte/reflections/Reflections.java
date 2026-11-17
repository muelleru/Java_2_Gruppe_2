package programmierkonzepte.reflections;

import global.Workable;
import oopgrundlagen.tiere.Hund;
import oopgrundlagen.tiere.Katze;
import oopgrundlagen.tiere.Tier;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

public class Reflections implements Workable {
    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void doWork() {
        testRefl2();
    }

    public void testRefl2() {
        Tier h = new Hund(1,"grün","Dackel",true).setName("Hansi");
        Class meta2 = h.getClass();

        // Felder von Tier
        for(Field field : meta2.getSuperclass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                System.out.println(
                        field.getName() + " : " +
                                field.getType().getSimpleName() + " => " +
                                field.get(h)
                );
            } catch(IllegalAccessException ex) {
                System.out.println(ex.getMessage());
            }
        }
        // nummer : int
        // farbe : String
        // energie : int
        // name : String
        // Felder von Hund
        for(Field field : meta2.getDeclaredFields()) {
            System.out.println(field.getName() + " : " + field.getType().getSimpleName());
        }
        // rasse : String
        // apportiertGerne : boolean



    }
    public void testRefl() {

        Tier h = new Hund(1,"grün","Dackel",true);

        // Meta-Klasse
        Class meta = Hund.class;
        System.out.println("Name: " + meta.getName());
        System.out.println("SimpleName: " + meta.getSimpleName());

        Class meta2 = h.getClass();
        System.out.println("Name: " + meta2.getName());
        System.out.println("SimpleName: " + meta2.getSimpleName());

        System.out.println("h ein Hund? " + (h instanceof Hund));
        System.out.println("h ein Hund über class? " + (h.getClass() == Hund.class));
        System.out.println("h ein Tier? " + (h instanceof Tier));
        System.out.println("h eine Katze? " + (h instanceof Katze));

        // Casting
        if(h instanceof Hund) {
            Hund hund = (Hund)h; // Zweiter Zeiger auf das Tier(Hund)
            // Sicherstellen, dass h ein Hund ist!
            ((Hund) h).setRasse("Schäferhund");
            hund.setRasse("Schäferhund");
        }

        // Spezieller instance cast
        if(h instanceof Hund hund) {
            hund.setRasse("Schäferhund");
        }



        // h.setRasse("");
    }


}
