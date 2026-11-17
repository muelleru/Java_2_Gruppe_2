package algodat;

import global.Workable;
import oopgrundlagen.tiere.Hund;
import oopgrundlagen.tiere.Katze;
import oopgrundlagen.tiere.Tier;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
import java.util.function.Consumer;

 @FunctionalInterface
 interface Operation<T> {
     T operator(T a, T b);
 }

public class AlgoDat implements Workable {
    @Override
    public boolean isActive() {
        return true;
    }

    public void testArray() {
        int array[] = new int[10];
        String namen[] = new String[] {"Anton","Berta","Cäsar"};
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + "=>" + array[i]);
        }
        // Wrapper: Arrays
        // System.arraycopy();
    }

    public static void MyPrint(Integer x) {
        System.out.println("**" +  x + "**");
    }

    public static void MyForEach(List<Integer> liste, Consumer<Integer> funcobj) {
        for(Integer elem : liste) {
            funcobj.accept(elem);
        }
    }

    public void testArrayList2() {
        // Vector
        // Iterable => Collection => List
        List<Tier> x; // List ist ein Interface
                      // List ist ein Satz von Listen-Funktionen wie add, remove, usw.
        x = new ArrayList<>();
        x = new Vector<>();
        x = new Stack<>();
        List.of(1,2,3,4,5);  // nicht veränderbare Liste

        ArrayList<Tier> tiere = new ArrayList<>();
        tiere.add(new Hund(1,"blau","Ottifant",false).setName("Bello"));
        tiere.add(new Katze(2,"gelb",20,true).setName("Tiger"));

        // tiere.add(new Tier(2,"grün"));
        for(var tier : tiere) {
            System.out.println(tier.getName());
        }

        tiere.removeIf( t -> t.getNummer() == 1); // Tier mit Nummer 1 rauswerfen

        System.out.println(tiere);

    }

    // Collections
    public void testArrayList() {
        ArrayList<Integer> list1 = new ArrayList<>(List.of(30,40,50));
        list1.add(1);
        list1.add(5);
        list1.add(10);
        System.out.println(list1); // Standard-Ausgabe => ArrayList.toString()
        // [30, 40, 50, 1, 5, 10]

        // Consumer<Integer> ???
        // Funktions-Typ => void F(Integer x);
        // print ist eine Methode mit einem Parameter vom Typ <Integer>
        //list1.forEach(System.out::print);//3040501510
        //list1.forEach(System.out::println);
        //list1.forEach(AlgoDat::MyPrint);
        // Lambda-Ausdruck => Funktion/Methode ohne Namen
        // x ->  x ist der Parameter, Typ ergibt sich aus dem Consumer
        //   -> Anweisung oder Anweisungs-Block
        list1.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.println(x + ", ");
            }
        });

        list1.forEach( x-> System.out.print( x + ", ") ); //30, 40, 50, 1, 5, 10,
        System.out.println();

        for(Integer x : list1) {
            System.out.print(x + ", ");
        }
        System.out.println();

        // Alle löschen >=30
// GEHT NICHT!!! remove zerstört die Iteration
//        for(var elem : list1) {
//            if(elem >= 30) {
//                list1.remove(elem);
//            }
//            // Index oder Element
//        }

        for(int i = list1.size()-1; i>=0; i--) {
            int elem = list1.get(i);
            if(elem >= 30)
            {
                list1.remove(i);
            }
        }
        System.out.println(list1); // [1, 5, 10]

        list1.addAll(List.of(30,40,50));
        System.out.println(list1); // [1, 5, 10, 30, 40, 50]
    // Predicate(T) => boolean, bei true => rauswerfen
        list1.removeIf( x ->  x >=30 );
        System.out.println(list1); // [1, 5, 10]

        list1.add(2, 42); // An Index 2 die 42 einfügen
        System.out.println(list1); // [1, 5, 42, 10]

        System.out.println("# " + list1.size());

        int pos = list1.indexOf(42); // Position von 42
                                     // -1 falls nicht gefunden

        System.out.println("Die 42 ist an Index "+ pos);

        if(list1.contains(42)) {
            System.out.println("42 ist in der Liste vorhanden");
        }

        list1.clear(); // Alle Elemente rauswerfen
        System.out.println(list1); // []
    }


    @Override
    public void doWork() {

        testArrayList2();
    }

}
