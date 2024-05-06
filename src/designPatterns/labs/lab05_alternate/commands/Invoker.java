package designPatterns.labs.lab05_alternate.commands;

public interface Invoker {
    abstract void setCommand(Command cmd);
    abstract void execute(double amount, String description);
    abstract void redo();
    abstract void undo();
}
