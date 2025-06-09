package problems.movieticketbookingsystem.controller;

import java.util.ArrayList;
import java.util.List;

import problems.movieticketbookingsystem.models.Show;

public class ShowController {

    private List<Show> shows;

    private static ShowController showControllerInstance;
    private ShowController() {
        this.shows = new ArrayList<>();
    }

    public static ShowController getInstance() {
        if(showControllerInstance == null) {
            synchronized (ShowController.class) {
                if(showControllerInstance == null) {
                    showControllerInstance = new ShowController();
                }
            }
        }
        return showControllerInstance;
    }

    public void addShow(Show show) {
        shows.add(show);
    }

    
}