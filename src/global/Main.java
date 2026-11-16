package global;

import oopgrundlagen.OopGrundlagen;

import java.util.ArrayList;

public class Main {
    static void main(String[] args) {
        ArrayList<Workable> workables = new ArrayList<>();
        workables.add(new OopGrundlagen());
        for(Workable w : workables) {
            if(w.isActive()) {
                w.doWork();
            }
        }
    }
}
