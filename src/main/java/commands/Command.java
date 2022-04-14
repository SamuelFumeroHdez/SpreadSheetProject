package commands;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Command {
    void readArguments();
    void execute() throws IOException, ClassNotFoundException;
}
