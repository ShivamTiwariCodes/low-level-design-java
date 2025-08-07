package designpatterns.templateMethodPattern;

public class CreatePDF extends CreateDocument{

    @Override
    void openDocument() {
        System.out.println("Opening PDF document ... ");
    }

    @Override
    void writeDocument() {
        System.out.println("Writing in PDF document ... ");
    }

    @Override
    void closeDocument() {
        System.out.println("Closing in PDF document ... ");
    }
}
