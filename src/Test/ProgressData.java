package Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class ProgressData {

    private IOInterface ioInterface;
    private HashMap<Integer, String> antwortenMap;
    private Random random;

    public ProgressData() {
        antwortenMap = new HashMap<Integer, String>();
        random = new Random();
        ioInterface = new IOSerialisierung();
    }

    private void setProgress(HashMap<Integer,String> key) {
        this.antwortenMap.clear();
        this.antwortenMap.putAll(key);
    }

    public void saveProgress(File file) throws IOException {
        ioInterface.save(file, antwortenMap);
    }

    public void loadProgress(File file) throws ClassNotFoundException, IOException {
        setProgress(ioInterface.load(file));
    }

    public void setIoInterface(IOInterface ioInterface) {
        this.ioInterface = ioInterface;
    }

    public IOInterface getIOInterface() {
        return ioInterface;
    }
    public int getCount() {
        return this.antwortenMap.size();
    }

}
