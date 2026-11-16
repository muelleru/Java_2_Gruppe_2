package oopgrundlagen;

import global.Workable;
import oopgrundlagen.exceptions.AlterOutOfBoundException;
import oopgrundlagen.exceptions.Person;
import oopgrundlagen.exceptions.PersonException;
import oopgrundlagen.tiere.Hund;
import oopgrundlagen.tiere.Tier;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OopGrundlagen implements Workable {
    @Override
    public boolean isActive() {
        return true;
    }
    @Override
    public void doWork() {


        System.out.println("Start Grundlagen");
        // testTiere();
        try {
            testException();
            testException2();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void testException2() /*throws PersonException*/{
        Person p1 = new Person();
        p1.setAlter(66);
        try {
            p1.setAlterV2(167);
        } catch (PersonException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Person erstellen abgebrochen");
            //throw e;
        } finally {
            System.out.println("Wird immer ausgeführt");
        }
    }

    public void testException() {

        Person p1 = new Person();
        try {
            p1.setAlter(130);
        }
        catch(AlterOutOfBoundException e) {
            System.out.println(e.getMessage());
            p1.setAlter(e.getAlter()/10);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Alter: " + p1.getAlter());

    }
    public void testTiere() {
        Tier t1 = new Hund(1,"Rot","Dackel",true).setName("Larsi");
        /*Tier*/ // t1 = new Katze(2,"Schwarz",5,true).setName("Minka");



        System.out.println(t1);
        t1.fressen(20);
        t1.laufen(25);
        System.out.println(t1);
        t1.schreien();
        t1.fressen(20);
        t1.laufen(15);
        System.out.println(t1);
        t1.schreien();
    }
}
