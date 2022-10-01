package by.domain;

import java.io.Serializable;

public class BrowserBean implements Serializable {
    private String info;
    public BrowserBean() {}

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
