package designpatterns.templateMethodPattern;

public class TemplateMethodPatternDemo {

    public void run() {

        CreateDocument createHTML = new CreateHTML();
        createHTML.createDocument();

        CreateDocument createPDF = new CreatePDF();
        createPDF.createDocument();

        CreateDocument createWordFile = new CreateWord();
        createWordFile.createDocument();
    }
}
