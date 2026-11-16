package oopgrundlagen;


import global.Workable;

public class OopGrundlagen implements Workable {
    @Override
    public boolean isActive() {
        return true;
    }
    @Override
    public void doWork() {
        System.out.println("Start Grundlagen");
        testTiere();
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
