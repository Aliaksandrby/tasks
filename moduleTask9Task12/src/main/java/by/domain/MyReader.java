package by.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Properties;

public class MyReader {
    public static int readFromFile(URI pathToFile) {
        int count = 0;
        try (InputStream input = new FileInputStream(new File(pathToFile))) {
            Properties prop = new Properties();
            prop.load(input);
            count = Integer.parseInt(prop.getProperty("counter"));
        } catch (IOException ex) {
            System.out.println("something went wrong with the file!!!(readFromFile)");
        }
        return count;
    }
}