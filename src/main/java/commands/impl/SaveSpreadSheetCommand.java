package commands.impl;

import commands.Command;
import models.SpreadSheet;

import java.io.*;

public class SaveSpreadSheetCommand implements Command {

    SpreadSheet spreadSheet;


    public SaveSpreadSheetCommand(SpreadSheet spreadSheet) {
        this.spreadSheet = spreadSheet;
    }

    @Override
    public void readArguments() {

    }

    @Override
    public void execute() throws IOException {
        File file = new File("src/main/resources/spreadsheet");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(spreadSheet);
    }
}
