package designpatterns.commandDesignPattern;


// Reciever class for actions, which know how to perform the action
public class Document {

    private StringBuilder text = new StringBuilder();

    public void addText(String text, int position) {
        this.text.insert(position, text);
        System.out.println("Text after adding : " + this.text.toString());
    }

    public void deleteText(int position, int length) {
        this.text.delete(position, position+length);
        System.out.println("Text after deletion : " + this.text.toString());
    }

    public String getText() {
        return this.text.toString();
    }

    public String getText(int position, int length) {
        return this.text.substring(position, position+length);
    }
}
