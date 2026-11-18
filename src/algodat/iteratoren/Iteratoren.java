package algodat.iteratoren;

import global.Workable;
import oopgrundlagen.tiere.Hund;
import oopgrundlagen.tiere.Katze;
import oopgrundlagen.tiere.Tier;

import java.time.LocalDate;
import java.util.*;

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

    public void testMyArrayList() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Karlsruhe");
        myArrayList.add("Stuttgart");
        myArrayList.add("Pforzheim");
        myArrayList.add("Karlsbad");
        myArrayList.add("Leonberg");
        for (String ort : myArrayList) {
            System.out.println(ort);
        }
        System.out.println("********* Remove(2) ********* ");
        myArrayList.remove(2);
        for (String ort : myArrayList) {
            System.out.println(ort);
        }

        System.out.println("********* Iterator ******");
        Iterator<String> it = myArrayList.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("**************");
        myArrayList.remove("Stuttgart");
        myArrayList.forEach(System.out::println);

        System.out.println("**************");
        System.out.println(myArrayList);

        MyArrayList<Integer> test = new MyArrayList<>();

        System.out.println(myArrayList.getClass().getTypeName());
        System.out.println(myArrayList.getClass() == test.getClass());
        System.out.println(myArrayList.getClass().getTypeName() == test.getClass().getTypeName());
    }

    public void testMap() {
        // Schlüssel + Wert
        // Key + Value
        // Key-Value-Pair Listen
        // Dictionary, Assoziatives Array, Map

        Map<String,Integer> mapping = new HashMap<>();
        mapping.put("Eins",1);
        mapping.put("Zwei",2);
        mapping.put("Drei",3);
        System.out.println(mapping.get("Zwei"));

        mapping.putAll(Map.of("Vier",4,"Fünf",5,"Sechs",6));

        System.out.println(mapping.get("Vier") * mapping.get("Sechs"));

        Map<String, Object> person = new HashMap<>(Map.of(
                "Vorname","Max",
                "Nachname","Mustermann",
                "Geburt", LocalDate.of(2001,12,24),
                "Id",42
        ));
        System.out.println(person.get("Nachname"));
        person.put("Gehalt",10_000);
        System.out.println(person);

        /* JavaScriptObjectNotation JSON
           {
            "Vorname":  "Max",
            "Nachname": "Mustermann",
            "Geburt" :  "2001-12-24",
            "Id" : 42
           }
         */

        // Iteration über Keys
        System.out.println("**** Iteration über Keys ***");
        for(String attr : person.keySet()) {
            System.out.println(attr + " => " + person.get(attr));
        }

        // Iteration über Key-Value-Pairs
        System.out.println("**** Iteration über Key-Values ***");
        for(/* var */ Map.Entry<String, Object> kvp : person.entrySet()) {
            System.out.println(kvp.getKey() + " => " + kvp.getValue());
        }

    }

    // Verkettete Liste LinkedList
    // item -> item -> newitem -> item

    public void testLinkedList() {

        LinkedList<String> liste = new LinkedList<>();
        ListIterator<String> it;

        liste.add("Karlsruhe");
        liste.add(0,"Freiburg");
        liste.addFirst("Augsburg");
        liste.addLast("München");
        liste.add(2,"Stuttgart");
        liste.push("Berlin"); // Stack-Methode !!! fügt vorne an
        liste.offerFirst("Heilbronn"); //Queue-Methode
        System.out.println("1: " + liste);

        it = liste.listIterator();

        System.out.println("NEXT: " + it.next());
        System.out.println("NEXT: " + it.next());
        System.out.println("NEXT: " + it.next());
        System.out.println("NEXT: " + it.next());

        it.add("Hamburg");

        System.out.println("2: " + liste);
        System.out.println("NEXT: " + it.next());
        System.out.println("NEXT: " + it.next());

        it.add("Bremen");

        it.previous();
        it.previous();

        it.set("New York");

        // System.out.println("Pop: " + liste.pop());
        System.out.println(liste);


//        Stack<String> stack = new Stack<>();
//        stack.push("A");
//        stack.push("B");
//        stack.push("C");
//        System.out.println("Stack :" + stack);
//        System.out.println("index 0 : " + stack.get(0));
//        while(stack.size()>0) {
//            System.out.println(stack.pop());
//        }

        // Deque<String> deque = new ArrayDeque<String>(liste);

    }

    public void testSet() {

        Set<String> set1 = new HashSet<>(Set.of("KA","S","M"));
        set1.add("LB");
        set1.add("KA");
        System.out.println(set1);

        Set<String> set2 = new TreeSet<>(Set.of("KA","S","M","A","HH"));
        set2.add("LB");
        set2.add("KA");
        System.out.println(set2);


        // TreeMap<String,String> hm = new TreeMap<>();

    }

    void testSort() {
        ArrayList<String> kennzeichen = new ArrayList<>(List.of("KA","S","M","A","HH"));


    }


    // Mengen Set    TreeSet HashSet ...
    // => keine doppelten Elemente!!!

    // Queue, Stack, ...


    @Override
    public void doWork() {
        testSet();
        //  testLinkedList();
        //testMap();
        //testMyArrayList();
        //testZoo();
        //testIterator();
    }
}
