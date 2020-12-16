package Test.Persistenz;

import java.io.IOException;
import java.util.List;

public interface BufferInterface {


    void save(String file, List<String> progress ) throws IOException;

    List<String> load(String file) throws IOException, ClassNotFoundException;
}
