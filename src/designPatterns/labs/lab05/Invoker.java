package designPatterns.labs.lab05;

import designPatterns.labs.lab05.commands.Command;

public interface Invoker {
    abstract void setCommand(Command cmd);
    abstract void execute();
    abstract void redo();
    abstract void undo();
}
