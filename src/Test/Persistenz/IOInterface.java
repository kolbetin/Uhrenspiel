package Test.Persistenz;

import Test.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public interface IOInterface {

    void save(File file, HashMap<Integer,String> antwortenmap) throws IOException;

    HashMap<Integer,String> load(File file) throws IOException, ClassNotFoundException;
}
