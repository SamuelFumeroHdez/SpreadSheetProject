package commands.impl;

import commands.Command;
import models.Parser;
import models.SpreadSheet;

import java.io.*;

public class LoadSpreadSheetCommand implements Command {

    private final String filePath;


    public LoadSpreadSheetCommand(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void readArguments() {

    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {

        Parser parser = new Parser(filePath);
        parser.loadSpreadSheetS2V();
    }
}
