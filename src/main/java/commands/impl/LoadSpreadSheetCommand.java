package commands.impl;

import commands.Command;
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

        File file = new File(filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
        SpreadSheet spreadSheet = (SpreadSheet) objectInputStream.readObject();
        System.out.println("Spreadsheet desde fichero: " + spreadSheet.toString());
    }
}
