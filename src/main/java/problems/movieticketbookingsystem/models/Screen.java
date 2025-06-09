package problems.movieticketbookingsystem.models;

import java.util.ArrayList;
import java.util.List;

public class Screen {

    private String id;
    private String name;
    private int capacity;
    private Threater threater;
    private List<Seat> seats;
    private List<Show> shows;

    public Screen(String id, String name, int capacity, List<Seat> seats) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.seats = seats;
        this.capacity = seats.size();
        this.shows = new ArrayList<>();
    }

    public boolean addShow(Show show) {
        shows.add(show);
        return true;
    }

    public boolean removeShow(Show show) {
        shows.add(show);
        return true;
    }

    public String getId() {
        return id;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public Threater getThreater() {
        return threater;
    }

    public void setThreater(Threater threater) {
        this.threater = threater;
    }

    public List<Show> getShows() {
        return shows;
    }


    @Override
    public String toString() {
        return "Screen{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                // ", threater=" + (threater != null ? threater.getId() : "null") + 
                // ", seats=" + (seats != null ? seats.toString() + " seats" : "null") +
                // ", shows=" + (shows != null ? shows.toString() + " shows" : "null") +
                '}';
    }

}