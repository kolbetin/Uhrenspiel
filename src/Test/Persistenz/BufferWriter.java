package Test.Persistenz;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class BufferWriter implements BufferInterface{

    public void save(File file, List progress) throws IOException {
        try (OutputStream outStream = new FileOutputStream(file);
             ObjectOutputStream outObject = new ObjectOutputStream(outStream)) {

            outObject.writeObject(progress);
            System.out.println("Daten in der Datei " + file + " gespeichert!");
        } catch (IOException e) {
            throw new IOException("Daten können nicht in der Datei " + file + " gespeichert werden!");
        }
    }

    public List  load(File file) throws IOException, ClassNotFoundException    {
        try (InputStream inStream = new FileInputStream(file);
             ObjectInputStream inObject = new ObjectInputStream(inStream)) {
            return (List) inObject.readObject();

        } catch (ClassNotFoundException | IOException e) {
            throw new IOException("Die Daten können nicht von der Datei " + file + " gelesen werden");
        }
    }
}
