package Test.Persistenz;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public interface IOInterface {

    void save(File file, HashMap<String, String> antwortenmap) throws IOException;

    HashMap<String, String> load(File file) throws IOException, ClassNotFoundException;
}
