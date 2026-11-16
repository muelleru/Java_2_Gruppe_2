package oopgrundlagen.logging;

import global.Workable;

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
        logger.setLevel(Level.ALL); // Welche Fehler sollen geloggt werden
        logger.log(Level.INFO,"Logger initialisiert");
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void doWork() {
            logger.log(Level.INFO,"doWork gestartet");


            logger.log(Level.INFO,"doWork beendet");
    }

}
