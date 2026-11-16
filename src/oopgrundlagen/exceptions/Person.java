package oopgrundlagen.exceptions;

public class Person {

    private int alter;

    public int getAlter() {return alter;}
    public void setAlter(int alter) {
        if(alter >= 0 && alter <=120) {
            this.alter = alter;
        } else {
            // RuntimeException() kann man abfangen
            // Exception()        muss man abfangen!
            throw new AlterOutOfBoundException(alter, 0, 120);
        }
    }


}
