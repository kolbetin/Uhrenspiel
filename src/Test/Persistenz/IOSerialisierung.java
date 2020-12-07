package Test.Persistenz;



import java.io.*;
import java.util.HashMap;


public class IOSerialisierung implements IOInterface {


        public void save(File file, HashMap<Integer, String> antwortenmap) throws IOException {
            try (OutputStream outStream = new FileOutputStream(file);
                 ObjectOutputStream outObject = new ObjectOutputStream(outStream)) {

                outObject.writeObject(antwortenmap);
                System.out.println("Daten in der Datei " + file + " gespeichert!");
            } catch (IOException e) {
                throw new IOException("Daten können nicht in der Datei " + file + " gespeichert werden!");
            }
        }

        public HashMap<Integer, String> load(File file) throws IOException, ClassNotFoundException    {
            try (InputStream inStream = new FileInputStream(file);
                 ObjectInputStream inObject = new ObjectInputStream(inStream)) {
                return (HashMap<Integer, String>) inObject.readObject();

            } catch (ClassNotFoundException | IOException e) {
                throw new IOException("Die Daten können nicht von der Datei " + file + " gelesen werden");
            }
        }


}

