package design.patterns.behavioural.command;

public class OpenFileCommand implements  Command {
    private FileReceiver fileReceiver;

    OpenFileCommand(FileReceiver fileReceiver) {
        this.fileReceiver = fileReceiver;
    }
    @Override
    public void execute() {
        this.fileReceiver.open();
    }
}
