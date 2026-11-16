package oopgrundlagen.tiere;

public abstract class Tier {
    // Kein Objekt vom Typ Tier
    private int nummer;
    private String farbe;
    protected int energie;
    private String name;



    public Tier(int nummer, String farbe) {
        this.nummer = nummer; // setNummer
        this.farbe = farbe;   // setFarbe
        this.energie = 10;
        this.name = "";
    }

    public int getNummer() {
        return nummer;
    }
    public String getFarbe() {
        return farbe;
    }
    public int getEnergie() {
        return energie;
    }
    public String getName() {
        return name;
    }
    public Tier setFarbe(String farbe) {
        this.farbe = farbe;
        return this;
    }
    public Tier setName(String name) {
        this.name = name;
        return this;
    }

    public abstract void laufen(int distanz);
    public abstract void fressen(int menge);
    public abstract void schreien();

    @Override
    public String toString(){
        return "Nummer=" + nummer + ","+
                "Farbe=" + farbe + "," +
                "Energie=" + energie + ",";
    }
}
