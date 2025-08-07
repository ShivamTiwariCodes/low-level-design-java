package designpatterns.momentoDesignPattern;

public class MomentoDesignPatternDemo {

    public void run() {
        TextEditor textEditor = new TextEditor();
        TextEditorCareTaker textEditorCareTaker = new TextEditorCareTaker();

        textEditor.append("Hello ");
        textEditor.append("World !");
        textEditorCareTaker.save(textEditor.saveToMomento());
        System.out.println("State at level 1 : " + textEditor.getText());

        textEditor.append("Thik h na!");
        System.out.println("State at level 2 : " + textEditor.getText());

        textEditor.restore(textEditorCareTaker.undo());
        System.out.println("State at level 3 : " + textEditor.getText());
    }

}
