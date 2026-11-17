package programmierkonzepte.inner;

import global.Workable;

public class Inner implements Workable {

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void doWork() {

    }
    public void testInner() {

        Person p = new Person("Karl","Maier", "70567","Stuttgart","Königstr.","1" );
        p.setNachname("Müller");
        String nn = p.getNachname();
        p.getAdresse().setOrt("Karlsruhe").setPlz("76000");
        String ort = p.getAdresse().getOrt();
        // Person.Adresse a= new Person.Adresse("","","","");

    }

}
