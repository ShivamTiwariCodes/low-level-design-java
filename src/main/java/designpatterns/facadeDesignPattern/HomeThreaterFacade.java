package designpatterns.facadeDesignPattern;

public class HomeThreaterFacade {

//    Screen, amplifier, projector, dvdplayer

    private Amplifier amplifier;
    private DvdPlayer dvdPlayer;
    private Projector projector;
    private Screen screen;

    public HomeThreaterFacade(Amplifier ampifier, DvdPlayer dvdPlayer, Projector projector, Screen screen) {
        this.amplifier = ampifier;
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.screen = screen;
    }

    public void playMovie(String movieName) {
        System.out.println("Starting the movie ...");
        amplifier.turnOn();
        screen.down();
        projector.turnOn();
        projector.setInput("DVD");
        dvdPlayer.turnOn();
        dvdPlayer.playMovie(movieName);
    }

    public void end() {
        amplifier.turnOff();
        dvdPlayer.turnOff();
        screen.up();
        projector.turnOff();
        System.out.println("Movie has ended.");
    }
}
