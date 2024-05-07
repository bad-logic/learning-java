package designPatterns.labs.lab05.commands;

public interface Command {
    abstract void execute();
    abstract void redo();
    abstract void undo();
}
