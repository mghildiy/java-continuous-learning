package design.patterns.behavioural.command;

public class FileReceiver {

    String file;

    FileReceiver(String file) {
        this.file = file;
    }

    void open() {
        System.out.println("Opening file: "+ this.file);
    }

    void update(String toAdd) {
        System.out.println("Updating file: "+ this.file + " with:"+ toAdd);
    }

    void undo() {
        System.out.println("Undoing last operation");
    }

    void close() {
        System.out.println("Closing file: "+ this.file);
    }
}
