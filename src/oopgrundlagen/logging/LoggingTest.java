package oopgrundlagen.logging;

import global.Workable;
import oopgrundlagen.exceptions.Person;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingTest implements Workable {

    private Logger logger;

    public LoggingTest() {
        logger = Logger.getLogger(LoggingTest.class.getSimpleName());
        try {
            FileHandler f =new FileHandler("test.log",true);
            f.setFormatter(new SimpleFormatter());
            logger.addHandler(f);
        } catch (Exception e) {
            System.out.println("Error creating log-File");
        }
        logger.setLevel(Level.SEVERE); // Welche Fehler sollen geloggt werden
        logger.log(Level.INFO,"Logger initialisiert");
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void doWork() {
            logger.log(Level.INFO,"doWork gestartet");
            try {
                testPerson();
            } catch (Exception e) {
                // Exception an log übergeben
                logger.log(Level.SEVERE, e.getMessage(), e);
            } finally {
                logger.log(Level.INFO,"doWork beendet");
            }
    }
    public void testPerson() {
        logger.log(Level.INFO,"testPerson gestartet");
        Person p1 = new Person();
        p1.setAlter(121);
        System.out.println(p1.getAlter());
    }
}
