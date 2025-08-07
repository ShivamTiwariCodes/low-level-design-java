package designpatterns.templateMethodPattern;

public class CreateWord extends CreateDocument{
    @Override
    void openDocument() {
        System.out.println("Opening word document ... ");
    }

    @Override
    void writeDocument() {
        System.out.println("Writing in word document ... ");
    }

    @Override
    void closeDocument() {
        System.out.println("Closing in word document ... ");
    }
}
