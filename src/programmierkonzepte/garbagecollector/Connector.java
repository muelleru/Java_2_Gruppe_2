package programmierkonzepte.garbagecollector;

public class Connector implements AutoCloseable{

    private String constr;
    public Connector(String constr) {
        // Verbindung zu einer DB herstellen
        connect(constr);
    }
    private void  connect(String constr) {
        // .....
    }

    @Override
    public void close() throws Exception {
        // Hier Verbindung zur DB schliessen
    }

    // Destructor
    // ist VERALTET!!!!
    // @Override
    //protected void finalize() throws Throwable {
    //    close();
    //    // Verbindung beenden
    //}


}
