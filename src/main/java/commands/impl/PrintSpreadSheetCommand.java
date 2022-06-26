package commands.impl;

import commands.Command;
import models.SpreadSheet;

import java.io.IOException;

public class PrintSpreadSheetCommand implements Command {
    @Override
    public void readArguments() {

    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        SpreadSheet spreadSheet = SpreadSheet.getSpreadSheet();
        System.out.println(spreadSheet);
    }
}
