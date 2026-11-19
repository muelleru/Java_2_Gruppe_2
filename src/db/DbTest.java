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

    void testSelect(String sql) {
        String connectionString = "jdbc:mariadb://localhost:3306/wetter?sslMode=disable";
        String user = "root";
        String pw = "";
        try (Connection con = DriverManager.getConnection(connectionString, user, pw)) {
            // Beim Erzeugen von Con wird sofort eine Verbindung hergestellt (open)
            System.out.println("Verbindung OK");
            try (Statement statement = con.createStatement()) {
                // Statement Objekt erzeugen
                try (ResultSet resultset = statement.executeQuery(sql)) {
                    // ResultSet => Zugriff auf die Tabellendaten
                    // Vergleichbar mit dem Iterator aus den Collections
                    // next() springt zum nächsten Datensatz, falls vorhanden
                    //
                    while (resultset.next()) {
                        // Zugriff auf einen einzelnen Datensatz
                        // System.out.print("Feld 1 : " + resultset.getObject(1));
                        // System.out.print(", Feld 2 : " + resultset.getInt("mm"));
                        int jahr = resultset.getInt("yyyy");
                        int monat = resultset.getInt("mm");
                        double rain = resultset.getDouble("rain");
                        System.out.printf("| %4d | %2d | %6.2f |\n", jahr, monat, rain);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Keine Verbindung zum Server");
            ex.printStackTrace();
        }
    }


    @Override
    public void doWork() {
        testSelect("select * from wetterdaten where yyyy >= 2026");
        //testConnection();
    }
}
