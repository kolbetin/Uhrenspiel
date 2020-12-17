package Test.Persistenz;

import Test.Domain.SavedData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class BufferWriter implements IOInterface {



    public void save(File file, List<String> progress) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

            for (String string : progress) {
                writer.write(string);
                writer.newLine();
            }
            System.out.println("Daten in der Datei " + file + " gespeichert!");
            System.out.println(progress);
        } catch (IOException e) {
            throw new IOException("Daten können nicht in der Datei " + file + " gespeichert werden!");
        }
    }

    public List<String> load(File file) throws IOException,
            ClassNotFoundException {
             try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                List<String> spielstand = new ArrayList<>();

                String progress = reader.readLine();
                while (progress != null) {
                    spielstand.add(progress);
                    progress = reader.readLine();

                }
                 System.out.println(spielstand);
                return spielstand;
            }
        }

}
