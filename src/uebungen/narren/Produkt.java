package uebungen.narren;

public class Produkt {

    private String name;
    private int preis;

    public Produkt(String name, int preis) {
        this.name = name;
        this.preis = preis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Produkt{");
        sb.append("name='").append(name).append('\'');
        sb.append(", preis=").append(preis);
        sb.append('}');
        return sb.toString();
    }
}
