package programmierkonzepte.garbagecollector;

import global.Workable;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GarbageCollector implements Workable {
    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void doWork() {
       // testGC();
    }

    public void testAutoClosable() {

        // Try_With_Resources
        // AutoClosable
        try(Connector c = new Connector("jdbc://")) {


        } // c.close() wird hier ausgeführt
        catch(Exception ex) {

        }
//        try(BufferedReader reader = Files.newBufferedReader(Path.of("C:","test","temp"))){
//
//        } catch(IOException ex) {
//
//        }

    }

    public void testGC() {

        // Garbage Collector
        System.gc(); // Collecting anstoßen

        Runtime rt = Runtime.getRuntime();
        System.out.println("Free: " + rt.freeMemory());
        System.out.println("Max: " + rt.maxMemory());
        System.out.println("Total: " + rt.totalMemory());
        System.out.println("#Proc: " + rt.availableProcessors());

        System.gc();
        rt.gc();
    }
}
