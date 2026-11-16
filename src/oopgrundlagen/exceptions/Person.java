package oopgrundlagen.exceptions;

public class Person {

    private int alter;

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        if (alter >= 0 && alter <= 120) {
            this.alter = alter;
        } else {
            // RuntimeException() kann man abfangen
            // Exception()        muss man abfangen!
            //                    Methode, die Exc. wirft, muss diese deklarieren!

            throw new AlterOutOfBoundException(alter, 0, 120); // RuntimeException
        }
    }

    public void setAlterV2(int alter) throws PersonException {
        if (alter >= 0 && alter <= 120) {
            this.alter = alter;
        } else {
            throw new PersonException("Alter nicht im Bereich 0 .. 120"); // Exception
        }
    }
}
