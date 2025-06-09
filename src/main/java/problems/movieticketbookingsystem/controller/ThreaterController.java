package problems.movieticketbookingsystem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import problems.movieticketbookingsystem.models.Threater;

public class ThreaterController {

    private List<Threater> threaters;

    private static ThreaterController threaterControllerInstance;
    private ThreaterController() { 
        this.threaters = new ArrayList<>();
    }

    public static ThreaterController getInstance() {
        if(threaterControllerInstance == null) {
            synchronized (ThreaterController.class) {
                if(threaterControllerInstance == null) {
                    threaterControllerInstance = new ThreaterController();
                }
            }
        }
        return threaterControllerInstance;
    }

    public boolean addThreater(Threater threater) {
        if(isThreaterExist(threater)) {
            return false;
        }
        threaters.add(threater);
        return true;
    }

    private boolean isThreaterExist(Threater threater) {
        boolean isFound = threaters.stream().anyMatch(t -> t.getId() == threater.getId());
        return isFound;
    }

    public List<Threater> getThreaters() {
        return threaters;
    }

    public List<Threater> getThreatersByCity(String city) {
        return this.threaters.stream().filter(t -> t.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
    }
}