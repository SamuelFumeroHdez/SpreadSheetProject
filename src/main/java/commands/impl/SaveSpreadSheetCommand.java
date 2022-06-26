package commands.impl;

import commands.Command;
import models.Parser;
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
        Parser parser = new Parser(filePath);
        parser.saveSpreadSheetS2V();
    }
}
