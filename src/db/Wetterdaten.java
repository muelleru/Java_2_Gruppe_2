package db;

public class Wetterdaten {

    private Integer yyyy;
    private Integer mm;
    private Double rain;
    private Double sun;
    private Double tmin;
    private Double tmax; // null
    private Integer af;


    public Wetterdaten(Integer yyyy, Integer mm) {
        this(yyyy,mm,null,null,null,null,null);
    }

    public Wetterdaten(Integer yyyy, Integer mm, Double rain, Double sun, Double tmin, Double tmax, Integer af) {
        this.yyyy = yyyy;
        this.mm = mm;
        this.rain = rain;
        this.sun = sun;
        this.tmin = tmin;
        this.tmax = tmax;
        this.af = af;
    }


    public Integer getYyyy() {
        return yyyy;
    }

    public Wetterdaten setYyyy(Integer yyyy) {
        this.yyyy = yyyy;
        return this;
    }

    public Integer getMm() {
        return mm;
    }

    public Wetterdaten setMm(Integer mm) {
        this.mm = mm;
        return this;
    }

    public Double getRain() {
        return rain;
    }

    public Wetterdaten setRain(Double rain) {
        this.rain = rain;
        return this;
    }

    public Double getSun() {
        return sun;
    }

    public Wetterdaten setSun(Double sun) {
        this.sun = sun;
        return this;
    }

    public Double getTmin() {
        return tmin;
    }

    public Wetterdaten setTmin(Double tmin) {
        this.tmin = tmin;
        return this;
    }

    public Double getTmax() {
        return tmax;
    }

    public Wetterdaten setTmax(Double tmax) {
        this.tmax = tmax;
        return this;
    }

    public Integer getAf() {
        return af;
    }

    public Wetterdaten setAf(Integer af) {
        this.af = af;
        return this;
    }

    public String toString() {
        // "| %4d | %2d | %6.2f | %6.2f | %6.2f | %6.2f | %6d |".formatted( getYyyy(),getMm(),getRain(),getSun(),getTmax(),getTmin(),getAf())
        return String.format("| %6d | %6d | %6.2f | %6.2f | %6.2f | %6.2f | %6d |",
                getYyyy(),getMm(),getRain(),getSun(),getTmax(),getTmin(),getAf());
    }
    public String toCSV() {
        return String.format("%d;%d;%.2f;%.2f;%.2f;%.2f;%d",
                getYyyy(),getMm(),getRain(),getSun(),getTmax(),getTmin(),getAf());
    }

    public static String toCSVHeader() {
        return "YYYY;MM;Rain;Sun;TMax;TMin;Af";
    }

    public static Wetterdaten fromCSV(String csv) {
        // Dummy
        Wetterdaten wd = new Wetterdaten(0,0);
        return wd;
    }

}
