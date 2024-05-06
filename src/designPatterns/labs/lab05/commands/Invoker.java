package designPatterns.labs.lab05.commands;

public interface Invoker {
    abstract void setCommand(Command cmd);
    abstract void execute(double amount, String description);
    abstract void redo();
    abstract void undo();
}
