package designpatterns.proxyDesignPattern;

public class ProxyPatternDemo {

    public void run() {

        String image1Path = "Image 1 path";
        String image2Path = "Image 2 path";
        Image proxyImage = new ProxyImage(image1Path);

        proxyImage.display();
        proxyImage.display();
        proxyImage.display();
        proxyImage.display();

        Image image2 = new ProxyImage(image2Path);
        image2.display();
        image2.display();
        image2.display();
    }
}
