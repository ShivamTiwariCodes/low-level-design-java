package designpatterns.commandDesignPattern;

import designpatterns.commandDesignPattern.command.AddTextCommand;
import designpatterns.commandDesignPattern.command.Command;
import designpatterns.commandDesignPattern.command.CommandManager;
import designpatterns.commandDesignPattern.command.RemoveTextCommand;

public class CommandDesignPatternDemo {

    public void run() {

        CommandManager commandManager= new CommandManager();

        Document document = new Document();

        Command command1 = new AddTextCommand(document, "Text 1 ", document.getText().length());
        Command command2 = new AddTextCommand(document, "Text 2 ", document.getText().length());
        Command command3 = new RemoveTextCommand(document, 0, 4);

        commandManager.executeCommand(command1);
        System.out.println("After command 1 : " + document.getText());

        commandManager.executeCommand(command2);
        System.out.println("After command 2 : " + document.getText());

        commandManager.undo();
        System.out.println("After first undo : " + document.getText());

        commandManager.redo();
        System.out.println("After first redo : " + document.getText());

        commandManager.executeCommand(command3);
        System.out.println("After command 3 : " + document.getText());

        commandManager.undo();
        System.out.println("After undo 3 : " + document.getText());
    }
}
