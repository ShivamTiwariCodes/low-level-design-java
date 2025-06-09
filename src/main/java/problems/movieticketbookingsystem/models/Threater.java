package problems.movieticketbookingsystem.models;

import java.util.ArrayList;
import java.util.List;

public class Threater {

    private String id;
    private List<Screen> screens;
    private String city;

    public Threater(String id, String city, List<Screen> screens) {
        this.id = id;
        this.city = city;
        this.screens = screens;
    }

    public void addShow(Screen screen) {
        screens.add(screen);
    }

    public String getId() {
        return id;
    }

    public List<Screen> getScreens() {
        return screens;
    }   

    public String getCity() {
        return city;
    }
    
}