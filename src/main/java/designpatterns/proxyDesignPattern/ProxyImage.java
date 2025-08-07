package designpatterns.proxyDesignPattern;

public class ProxyImage implements Image{

    private Image realImage;
    private String path;

    public ProxyImage(String path) {
        this.path = path;
    }

    @Override
    public void display() {
        if(realImage == null) {
            realImage = new RealImage(path);
        }
        realImage.display();
    }
}
