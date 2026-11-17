package programmierkonzepte.designpatterns;

import global.Workable;
import programmierkonzepte.designpatterns.fahrzeuge.Automobil;
import programmierkonzepte.designpatterns.fahrzeuge.Fahrzeug;

import java.time.LocalDate;
import java.util.List;

public class DesignPatterns implements Workable {
    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void doWork() {
        //Singleton s = new Singleton();
        System.out.println(Singleton.getInstance().getName());
        Singleton.getInstance().setAlter(81);

       // Fahrzeug f = new Automobil("Audi","A3",4);
        Fahrzeug f = Fahrzeug.createFahrzeug("Automobil","Audi","A3");
      //  LocalDate datum = new LocalDate(); // Konstruktor ist privat!!!
        LocalDate datum = LocalDate.of(2000,4,15);
        List<Integer> x = List.of(1,2,3,4,5); // erzeugt konstante Listen (immutable)


    }
}
