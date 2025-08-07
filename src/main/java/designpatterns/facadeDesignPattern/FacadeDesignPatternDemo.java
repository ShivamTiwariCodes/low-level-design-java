package designpatterns.facadeDesignPattern;

public class FacadeDesignPatternDemo {

    public void run() {

        Amplifier amplifier = new Amplifier();
        DvdPlayer dvdPlayer = new DvdPlayer();
        Projector projector = new Projector();
        Screen screen = new Screen();

        HomeThreaterFacade homeThreaterFacade = new HomeThreaterFacade(amplifier, dvdPlayer, projector, screen);

        homeThreaterFacade.playMovie("Suryavansham");
        homeThreaterFacade.end();
    }
}
