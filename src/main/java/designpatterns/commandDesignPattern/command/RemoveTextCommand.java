package designpatterns.commandDesignPattern.command;

import designpatterns.commandDesignPattern.Document;

public class RemoveTextCommand implements Command{

    private Document document;
    private int position;
    private int length;
    private String removedText;

    public RemoveTextCommand(Document document, int position, int length) {
        this.document = document;
        this.position = position;
        this.length = length;
    }

    @Override
    public void execute() {
        removedText = this.document.getText(position, position+length);
        this.document.deleteText(position, length);
    }

    @Override
    public void undo() {
        this.document.addText(removedText ,position);
    }
}
