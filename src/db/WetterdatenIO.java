package db;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Collection;

public class WetterdatenIO {

    private WetterdatenIO() {

    }
    private static WetterdatenIO instance = null;
    public static WetterdatenIO getInstance() {

        if(instance == null) {
            instance = new WetterdatenIO();
        }
        return instance;
    }

    public void saveWetterdaten(Collection<Wetterdaten> wdliste, String filename) throws IOException {
        Path path = Path.of(filename);

        // ALT: BufferedWriter w2 = new BufferedWriter(new FileWriter(filename));

        try(BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            writer.write(Wetterdaten.toCSVHeader());
            writer.newLine();
            for(Wetterdaten wd : wdliste) {
                writer.write(wd.toCSV());
                writer.newLine();
            }
        }/* catch (Exception ex) {
           throw new RuntimeException(ex.getMessage());
        }*/

    }

    public void loadWetterdaten(Collection<Wetterdaten> wdliste, String filename) {

    }

}
