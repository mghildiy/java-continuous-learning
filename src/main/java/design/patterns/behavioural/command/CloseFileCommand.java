package design.patterns.behavioural.command;

public class CloseFileCommand implements  Command {
    private FileReceiver fileReceiver;

    CloseFileCommand(FileReceiver fileReceiver) {
        this.fileReceiver = fileReceiver;
    }

    @Override
    public void execute() {
        this.fileReceiver.close();
    }
}
