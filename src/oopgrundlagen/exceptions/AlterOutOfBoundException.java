package oopgrundlagen.exceptions;

public class AlterOutOfBoundException extends RuntimeException {

    private int alter;
    private int minAlter;
    private int maxAlter;

    public AlterOutOfBoundException(int alter) {
        this(alter,0,120);
        //        super();
//        this.alter = alter;
    }
    public AlterOutOfBoundException(int alter,int minAlter, int maxAlter) {
        super();
        this.alter = alter;
        this.maxAlter = maxAlter;
        this.minAlter = minAlter;
    }
    public int getAlter() {
        return alter;
    }

    @Override
    public String getMessage() {
        return "Alter %d ist nicht im Bereich %d .. %d".formatted(alter,minAlter,maxAlter);
    }

}
