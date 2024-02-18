package design.patterns.behavioural.command;

public class UpdateFileCommand implements  Command {

    private FileReceiver fileReceiver;

    String toAdd;

    UpdateFileCommand(FileReceiver fileReceiver) {
        this.fileReceiver = fileReceiver;
    }

    UpdateFileCommand(FileReceiver fileReceiver ,String input) {
        this.fileReceiver = fileReceiver;
        this.toAdd = input;
    }
    @Override
    public void execute() {
        this.fileReceiver.update(this.toAdd);
    }

    @Override
    public void undo() {
        this.fileReceiver.undo();
    }
}
