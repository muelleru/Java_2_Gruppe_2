package oopgrundlagen;

import global.Workable;
import oopgrundlagen.exceptions.AlterOutOfBoundException;
import oopgrundlagen.exceptions.Person;
import oopgrundlagen.tiere.Hund;
import oopgrundlagen.tiere.Tier;

public class OopGrundlagen implements Workable {
    @Override
    public boolean isActive() {
        return true;
    }
    @Override
    public void doWork() {
        System.out.println("Start Grundlagen");
        // testTiere();
        testException();
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
