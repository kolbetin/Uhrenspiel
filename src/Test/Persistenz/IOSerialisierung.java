package Test.Persistenz;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.List;


public class IOSerialisierung implements IOInterface {


        public void save(File file, List<String> spielstand) throws IOException {
            try (OutputStream outStream = new FileOutputStream(file);
                 ObjectOutputStream outObject = new ObjectOutputStream(outStream)) {

                outObject.writeObject(spielstand);
                System.out.println("Daten in der Datei " + file + " gespeichert!");
            } catch (IOException e) {
                throw new IOException("Daten können nicht in der Datei " + file + " gespeichert werden!");
            }
        }
       @SuppressWarnings("unchecked")
        public List<String> load(File file) throws IOException, ClassNotFoundException    {
            try (InputStream inStream = new FileInputStream(file);
                 ObjectInputStream inObject = new ObjectInputStream(inStream)) {
                return (List<String>) inObject.readObject();

            } catch (ClassNotFoundException | IOException e) {
                throw new IOException("Die Daten können nicht von der Datei " + file + " gelesen werden");
            }
        }





}

