package commands.impl;

import commands.Command;
import models.SpreadSheet;

import java.io.*;

public class SaveSpreadSheetCommand implements Command {

    private final String filePath;
    public SaveSpreadSheetCommand(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void readArguments() {

    }

    @Override
    public void execute() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        objectOutputStream.writeObject(SpreadSheet.getSpreadSheet());
    }
}
