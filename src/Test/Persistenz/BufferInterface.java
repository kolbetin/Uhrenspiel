package Test.Persistenz;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface BufferInterface {


    void save(File file, List progress ) throws IOException;

    List load(File file) throws IOException, ClassNotFoundException;
}
