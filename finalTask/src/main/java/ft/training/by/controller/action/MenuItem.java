package ft.training.by.controller.action;

import java.io.Serializable;

public class MenuItem implements Serializable {
    private String name;
    private String url;

    public MenuItem(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
