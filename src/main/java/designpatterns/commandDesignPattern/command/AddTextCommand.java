package designpatterns.commandDesignPattern.command;

import designpatterns.commandDesignPattern.Document;

// command should be stand-alone object contains all the information, so we can undo also
public class AddTextCommand implements Command{

    private Document document;
    private String text;
    private int position;

    public AddTextCommand(Document document, String text, int position) {
        this.document = document;
        this.text = text;
        this.position = position;
    }

    @Override
    public void execute() {
        this.document.addText(text, position);
    }

    @Override
    public void undo() {
        this.document.deleteText(position, text.length());
    }
}
