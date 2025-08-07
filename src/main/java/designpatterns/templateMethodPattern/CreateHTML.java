package designpatterns.templateMethodPattern;

public class CreateHTML extends CreateDocument {

    @Override
    void openDocument() {
        System.out.println("Opening HTML document ... ");
    }

    @Override
    void writeDocument() {
        System.out.println("Writing in HTML document ... ");
    }

    @Override
    void closeDocument() {
        System.out.println("Closing in HTML document ... ");
    }
}
