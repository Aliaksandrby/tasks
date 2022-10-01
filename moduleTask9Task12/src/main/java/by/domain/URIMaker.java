package by.domain;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class URIMaker {
    private URI pathToFile;
    public URIMaker(URL pathToFile) {
        this.makeURI(pathToFile);
    }

    private void makeURI(URL pathToFile) {
        try {
            this.pathToFile = pathToFile.toURI();
        } catch (URISyntaxException e) {
            System.out.println("Check transform URL to URI!!!");
        }
    }

    public URI getPathToFile() {
        return pathToFile;
    }
}
