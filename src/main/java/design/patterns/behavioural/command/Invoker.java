package design.patterns.behavioural.command;

import java.util.ArrayList;
import java.util.List;

public class Invoker {

    List<Command> commands = new ArrayList<>();

    void execute() {
        commands.forEach(command -> command.execute());
    }

    void undo() {
        commands.forEach(command -> command.undo());
    }

    void addCommands(List<Command> commandsToRun) {
        this.commands = commandsToRun;
    }
}
