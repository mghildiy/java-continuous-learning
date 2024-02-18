package design.patterns.behavioural.command;

import java.util.Arrays;

public class Client {

    public static void main(String[] args) {
        FileReceiver fs = new FileReceiver("path/to/file");
        Command openCommand = new OpenFileCommand(fs);
        Command updateCommand1 = new UpdateFileCommand(fs, "First line");
        Command updateCommand2 = new UpdateFileCommand(fs, "Second line");
        Command undoLastUpdate = new UpdateFileCommand(fs);
        Command closeCommand = new CloseFileCommand(fs);
        Invoker invoker = new Invoker();
        invoker.addCommands(Arrays.asList(openCommand, updateCommand1, updateCommand2));
        invoker.execute();
        invoker.addCommands(Arrays.asList(undoLastUpdate));
        invoker.undo();
        invoker.addCommands(Arrays.asList(closeCommand));
        invoker.execute();
    }
}
