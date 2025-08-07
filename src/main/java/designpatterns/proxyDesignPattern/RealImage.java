package designpatterns.proxyDesignPattern;

public class RealImage implements Image{

    private String path;

    public RealImage(String path) {
        this.path = path;
        loadImage(path);
    }

    private void loadImage(String path) {
        System.out.println("Loading image : " + path);
    }

    @Override
    public void display() {
        System.out.println("Display image : " + path);
    }
}
