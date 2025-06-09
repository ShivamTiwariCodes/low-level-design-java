package problems.movieticketbookingsystem.service;

import java.text.Collator;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import problems.movieticketbookingsystem.controller.ThreaterController;
import problems.movieticketbookingsystem.models.Movie;
import problems.movieticketbookingsystem.models.Screen;
import problems.movieticketbookingsystem.models.Show;
import problems.movieticketbookingsystem.models.Threater;

public class ShowService {

    private static ShowService showService;

    private ShowService() {};

    public static ShowService getInstance() {
        if(showService == null) {
            synchronized (ShowService.class) {
                if(showService == null) {
                    showService = new ShowService();
                }
            }
        }
        return showService;
    }

    public void addShow(Show show) {
        Screen screen = show.getScreen();
        screen.addShow(show);
    }

    public void removeShow(Show show) {
        Screen screen = show.getScreen();
        screen.removeShow(show);
    }

    public List<Show> getAllShowsByCity(String city) {
        ThreaterController threaterController = ThreaterController.getInstance();
        return threaterController.getThreatersByCity(city).stream()
        .flatMap(threater -> threater.getScreens().stream())
        .flatMap(screen -> screen.getShows().stream())
        .filter(show -> (show.getStarTime().isAfter(Instant.EPOCH)))
        .sorted(Comparator.comparing(Show::getStarTime))
        .collect(Collectors.toList());
    }

    public boolean bookShow(Show show) {
        return true;
    }




}