package designPatterns.labs.lab05_alternate.commands;


public interface Command {
    abstract void execute();
    abstract void redo();
    abstract void undo();
}
