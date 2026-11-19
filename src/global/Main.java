package global;

import algodat.AlgoDat;
import algodat.iteratoren.Iteratoren;
import db.DbTest;
import oopgrundlagen.OopGrundlagen;
import oopgrundlagen.logging.LoggingTest;
import programmierkonzepte.garbagecollector.GarbageCollector;
import programmierkonzepte.module.Module;
import programmierkonzepte.reflections.Reflections;

import java.util.ArrayList;

public class Main {
    static void main(String[] args) {

        ArrayList<Workable> workables = new ArrayList<>();
        workables.add(new OopGrundlagen());
        workables.add(new LoggingTest());
        workables.add(new GarbageCollector());
        workables.add(new Reflections());
        workables.add(new Module());
        workables.add(new AlgoDat());
        workables.add(new Iteratoren());
        workables.add(new DbTest());
        for(Workable w : workables) {
            if(w.isActive()) {
                w.doWork();
            }
        }
    }
}
