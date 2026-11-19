package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class WetterDb implements AutoCloseable {

    @FunctionalInterface
    public interface Messager {
        void send(String text);
    }

    private static Messager message;

    public static void setMessager(Messager m)
    {
        message = m;
    }

    private static void sendMessage(String m) {
        if(message!=null) {
            message.send(m);
        }
    }

    public WetterDb() throws SQLException{
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


    @Override
    public void close() throws Exception {
        if(connection!=null && !connection.isClosed()) {
            connection.close();
        }
    }
}
