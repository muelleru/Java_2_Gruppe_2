package global;

import oopgrundlagen.OopGrundlagen;
import oopgrundlagen.logging.LoggingTest;
import programmierkonzepte.garbagecollector.GarbageCollector;

import java.util.ArrayList;

public class Main {
    static void main(String[] args) {

        ArrayList<Workable> workables = new ArrayList<>();
        workables.add(new OopGrundlagen());
        workables.add(new LoggingTest());
        workables.add(new GarbageCollector());
        for(Workable w : workables) {
            if(w.isActive()) {
                w.doWork();
            }
        }
    }
}
