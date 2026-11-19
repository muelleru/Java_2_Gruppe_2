package db;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class WetterDb implements AutoCloseable {

    @FunctionalInterface
    public interface Messager {
        void send(String text);
    }

    private static Messager message;

    public static void setMessager(Messager m) {
        message = m;
    }

    private static void sendMessage(String m) {
        if (message != null) {
            message.send(m);
        }
    }

    public WetterDb() throws SQLException {
        user = "root";
        pw = "";
        cs = "jdbc:mariadb://localhost:3306/wetter?sslMode=disabled";
        try {
            connection = DriverManager.getConnection(cs, user, pw);
            sendMessage("OK");
            // Zeiger auf eine Funktion
        } catch (SQLException ex) {
            throw new SQLException("Verbindung zur WetterDB nicht möglich");
        }
    }


    private Connection connection;
    private String user;
    private String pw;
    private String cs;

    // Get (select), Put (update), Post (insert), Delete

    public Collection<Wetterdaten> getWetterdaten() throws SQLException {
        String sql = "select yyyy,mm,rain,sun,tmax,tmin,af from wetterdaten";
        ArrayList<Wetterdaten> wdliste = new ArrayList<>();
        if (connection != null && !connection.isClosed()) {

            try (Statement statement = connection.createStatement()) {
                try (ResultSet rs = statement.executeQuery(sql)) {
                    while (rs.next()) {
                        Wetterdaten wd;
                        int yyyy = rs.getInt("yyyy");
                        int mm = rs.getInt("mm");
                        wd = new Wetterdaten(yyyy, mm);
                        wd.setRain(rs.getObject("rain", Double.class));
                        wd.setSun(rs.getObject("sun", Double.class));
                        wd.setTmax(rs.getObject("tmax", Double.class));
                        wd.setTmin(rs.getObject("tmin", Double.class));
                        wd.setAf(rs.getObject("af", Integer.class));
                        wdliste.add(wd);
                    } //while
                } //try
            } //try
        } // if
        return wdliste;
    }

    public Wetterdaten getWetterdaten(int yyyy, int mm) throws SQLException {
        String sql = "select yyyy,mm,rain,sun,tmax,tmin,af from wetterdaten where yyyy = %d and mm = %d".formatted(yyyy, mm);
        Wetterdaten wd = null;
        if (connection != null && !connection.isClosed()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet rs = statement.executeQuery(sql)) {
                    if (rs.next()) {
                        if (yyyy == rs.getInt("yyyy") && mm == rs.getInt("mm")) {
                            wd = new Wetterdaten(yyyy, mm);
                            wd.setRain(rs.getObject("rain", Double.class));
                            wd.setSun(rs.getObject("sun", Double.class));
                            wd.setTmax(rs.getObject("tmax", Double.class));
                            wd.setTmin(rs.getObject("tmin", Double.class));
                            wd.setAf(rs.getObject("af", Integer.class));
                        }
                    } //while
                } //try
            } //try
        } // if
        return wd;
    }

    public void insertWetterdaten(Wetterdaten wetterdaten) throws SQLException {
        String sql = """
                insert into wetterdaten(yyyy,mm,rain,af,tmin,tmax,sun) 
                values(?,?,?,?,?,?,?)
                """;
        if (connection != null && !connection.isClosed()) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, wetterdaten.getYyyy());
                statement.setInt(2, wetterdaten.getMm());
                statement.setObject(3, wetterdaten.getRain(), Types.DOUBLE);
                statement.setObject(4, wetterdaten.getAf(), Types.INTEGER);
                statement.setObject(5, wetterdaten.getTmin(), Types.DOUBLE);
                statement.setObject(6, wetterdaten.getTmax(), Types.DOUBLE);
                statement.setObject(7, wetterdaten.getSun()/*, Types.DOUBLE*/);
                int count = statement.executeUpdate();
                sendMessage(count + " Daten geändert");
            }
        }
    }


    @Override
    public void close() throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
