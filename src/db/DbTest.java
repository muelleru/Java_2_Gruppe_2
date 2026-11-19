package db;

import global.Workable;

import java.sql.*;

public class DbTest implements Workable {

    @Override
    public boolean isActive() {
        return true;
    }

    public void testConnection() {
        String connectionString = "jdbc:mariadb://localhost:3306/wetter?sslMode=disable";
        String user = "root";
        String pw = "";

        // try_with_resources

        try (Connection con = DriverManager.getConnection(connectionString, user, pw)) {
            System.out.println("Schema: " + con.getSchema());
            System.out.println("Catalog: " + con.getCatalog());
            System.out.println("Verbindung OK");


        } catch (SQLException ex) {
            System.out.println("Keine Verbindung zum Server");
            ex.printStackTrace();
        }
    }

    void testSelectDyn(String sql) {
        String connectionString = "jdbc:mariadb://localhost:3306/wetter?sslMode=disable";
        String user = "root";
        String pw = "";
        try (Connection con = DriverManager.getConnection(connectionString, user, pw)) {
            DatabaseMetaData metaDb = con.getMetaData();
            System.out.println("User: " + metaDb.getUserName());
            System.out.println("Verbindung OK");
            try (Statement statement = con.createStatement()) {
                try (ResultSet resultset = statement.executeQuery(sql)) {
                    ResultSetMetaData metaRs = resultset.getMetaData();
                    // Überschrift drucken
                    for (int i = 1; i <= metaRs.getColumnCount(); i++) {
                        System.out.printf("| %-8s ", metaRs.getColumnName(i));
                    }
                    System.out.println("|");
                    while (resultset.next()) {
                        for (int i = 1; i <= metaRs.getColumnCount(); i++) {
//                            if (resultset.getObject(i) == null) {
//                                System.out.printf("| %8s ","NULL");
//                            } else {
                            switch (metaRs.getColumnTypeName(i).toLowerCase()) {
                                case "double":
                                    Double v = (Double)resultset.getObject(i,Double.class);
                                    System.out.printf( (v!=null ? "| %8.2f " : "|   NULL   "), v);
                                    break;
                                case "integer":
                                case "int":
                                    Integer x = (Integer)resultset.getObject(i,Integer.class);
                                    System.out.printf( (x!=null ? "| %8d " : "|          "), x);
                                    // System.out.printf("| %8d ", (Integer) resultset.getObject(i,Integer.class));
                                    break;
                            }
                            // }
                        }
                        System.out.println("|");
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Fehler beim Ausführen der Anweisung");
            ex.printStackTrace();
        }
    }

    void testSelect(String sql) {
        String connectionString = "jdbc:mariadb://localhost:3306/wetter?sslMode=disable";
        String user = "root";
        String pw = "";
        try (Connection con = DriverManager.getConnection(connectionString, user, pw)) {
            // Beim Erzeugen von Con wird sofort eine Verbindung hergestellt (open)
            System.out.println("Verbindung OK");
            try (Statement statement = con.createStatement()) {
                // Statement Objekt erzeugen
                // DatabaseMetaData meta = con.getMetaData();
                // ResultSet metaRs = meta.getColumns("wetter",null,"wetterdaten","%");

                try (ResultSet resultset = statement.executeQuery(sql)) {
                    // ResultSet => Zugriff auf die Tabellendaten
                    // Vergleichbar mit dem Iterator aus den Collections
                    // next() springt zum nächsten Datensatz, falls vorhanden
                    //
                    System.out.printf("| %4s | %2s | %6s | %6s | %6s | %6s | %6s |\n",
                            "yyyy", "mm",
                            "rain",
                            "sun",
                            "tmin",
                            "tmax",
                            "af"
                    );
                    while (resultset.next()) {
                        // Zugriff auf einen einzelnen Datensatz
                        // System.out.print("Feld 1 : " + resultset.getObject(1));
                        // System.out.print(", Feld 2 : " + resultset.getInt("mm"));
                        int jahr = resultset.getInt("yyyy");
                        int monat = resultset.getInt("mm");
                        double rain = resultset.getDouble("rain");
                        System.out.printf("| %4d | %2d | %6.2f | %6.2f | %6.2f | %6.2f | %6d |\n",
                                jahr, monat,
                                rain,
                                resultset.getDouble("sun"),
                                resultset.getDouble("tmin"),
                                resultset.getDouble("tmax"),
                                resultset.getInt("af")
                        );
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Keine Verbindung zum Server");
            ex.printStackTrace();
        }
    }
    // void testInsert(int yyyy, int mm, double rain ...);

    void testInsert(Wetterdaten wetterdaten) {
        String user = "root";
        String pw = "";
        String cs = "jdbc:mariadb://localhost:3306?sslMode=disabled";
        // cs ohne Datenbank
        String sql = """
                insert into wetterdaten(yyyy,mm,rain,af,tmin,tmax,sun) 
                values(?,?,?,?,?,?,?)
                """;
        // ? => Platzhalter
        try (Connection connection = DriverManager.getConnection(cs, user, pw)) {
            connection.setCatalog("wetter"); // use wetter;
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, wetterdaten.getYyyy());
                statement.setInt(2, wetterdaten.getMm());
                statement.setObject(3, wetterdaten.getRain(), Types.DOUBLE);
                statement.setObject(4, wetterdaten.getAf(), Types.INTEGER);
                statement.setObject(5, wetterdaten.getTmin(), Types.DOUBLE);
                statement.setObject(6, wetterdaten.getTmax(), Types.DOUBLE);
                statement.setObject(7, wetterdaten.getSun()/*, Types.DOUBLE*/);
                int count = statement.executeUpdate();
                System.out.println(count + " Daten geändert");
            }
        } catch (Exception e) {
            System.out.println("ERRROOOORRR");
            e.printStackTrace();
        }

    }

    @Override
    public void doWork() {
        testInsert(new Wetterdaten(2026, 11).setRain(10.0).setTmax(20.0).setTmin(10.0));
        //testSelectDyn("select yyyy, sum(rain) as r from wetterdaten group by yyyy");
        testSelectDyn("select yyyy, mm,  af, tmax, tmin, sun, rain from wetterdaten where yyyy >= 2026");
        //  testSelect("select yyyy, mm, rain, af, tmax, tmin, sun from wetterdaten where yyyy >= 2026");
        // testSelect("select * from wetterdaten where yyyy >= 2026");
        //testConnection();
    }
}
