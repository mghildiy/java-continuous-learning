package design.patterns.behavioural.command;

public interface Command {

    void execute();

    default void undo() {
        System.out.println("Not supported");
    }
}
