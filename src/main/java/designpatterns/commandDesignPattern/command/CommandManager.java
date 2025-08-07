package designpatterns.commandDesignPattern.command;

import java.util.Stack;

public class CommandManager {

    private Stack<Command> commandHistory = new Stack<>();
    private Stack<Command> redoStack = new Stack();

    public void executeCommand(Command command) {
        redoStack.empty();
        command.execute();
        commandHistory.push(command);
    }

    public void undo() {
        if(commandHistory.isEmpty()) return;
        Command command = commandHistory.pop();
        command.undo();
        redoStack.push(command);
    }

    public void redo() {
        if(redoStack.isEmpty()) return;
        Command command = redoStack.pop();
        command.execute();
        commandHistory.push(command);
    }
}
