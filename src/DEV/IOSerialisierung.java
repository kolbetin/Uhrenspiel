package DEV;

import java.io.*;
import java.util.List;


public class IOSerialisierung {

 //implements IOInterface

        public void save(File file, List<String> spielstand) throws IOException {
            try (OutputStream outStream = new FileOutputStream(file);
                 ObjectOutputStream outObject = new ObjectOutputStream(outStream)) {

                outObject.writeObject(spielstand);
                System.out.println("IO Serialisierung hat gespeichert");

            } catch (IOException e) {
                throw new IOException("Das Spiel kann nicht in der Datei " + file + " gespeichert werden!");
            }
        }
       @SuppressWarnings("unchecked")
        public List<String> load(File file) throws IOException, ClassNotFoundException    {
            try (InputStream inStream = new FileInputStream(file);
                 ObjectInputStream inObject = new ObjectInputStream(inStream)) {
                System.out.println("IO Serialisierung hat geladen");
                return (List<String>) inObject.readObject();


            } catch (ClassNotFoundException | IOException e) {
                throw new IOException("Das Spiel konnte nicht von der Datei " + file + " gelesen werden");
            }
        }

}

