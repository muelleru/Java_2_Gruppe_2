package programmierkonzepte.designpatterns;

public class Singleton {

    static {
        // Statischer Initialisierungs-Block
    }

    //region SINGLETON-MUSTER
    // 1) Privater Konstruktor => Kein Objekt ausserhalb der Klasse erzeugen
    private Singleton() {
        name = "LEO";
        alter = 80;
        beruf = "Papst";
    }
    // Das einzige Objekt der Klasse Singleton wird innerhalb der Klasse verwaltet
    private static Singleton instance = null;
    // Getter für instance

    public static Singleton getInstance() {
        // Beim ersten Zugriff wird das instance-Objekt erzeugt ...
        // synchronized () => Thread-Safe
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    //endregion

    private String name;
    private int alter;
    private String beruf;

    public int getAlter() {
        return alter;
    }

    public Singleton setAlter(int alter) {
        this.alter = alter;
        return this;
    }

    public String getName() {
        return name;
    }

    public Singleton setName(String name) {
        this.name = name;
        return this;
    }

    public String getBeruf() {
        return beruf;
    }

}
