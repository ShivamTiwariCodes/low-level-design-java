package problems.movieticketbookingsystem.models;

public class Movie {

    private String id;
    private String name;
    private String duration;
    
    public Movie(String id, String name, String duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }
}