package designpatterns.templateMethodPattern;

public abstract class CreateDocument {

    public final void createDocument() {
        openDocument();
        writeDocument();
        closeDocument();
    }

    abstract void openDocument();
    abstract void writeDocument();
    abstract void closeDocument();

}
