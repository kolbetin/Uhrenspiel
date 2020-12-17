package Test.Persistenz;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IOInterface {


    void save(File file, List<String> progress ) throws IOException;

    List<String> load(File file) throws IOException, ClassNotFoundException;
}
