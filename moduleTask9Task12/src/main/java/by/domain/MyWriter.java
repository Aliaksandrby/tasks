package by.domain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.Properties;

public class MyWriter {
    public static void writeToFile(URI pathToFile, int countVisit) {
        try (OutputStream output = new FileOutputStream(new File(pathToFile))) {
            Properties prop = new Properties();
            prop.setProperty("counter", Integer.toString(countVisit));
            prop.store(output,null);
        } catch (IOException e) {
            System.out.println("something went wrong with the file!!!(writeToFile)");
        }
    }
}

