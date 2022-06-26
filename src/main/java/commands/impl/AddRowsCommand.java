package commands.impl;

import commands.Command;
import models.SpreadSheet;

import java.io.IOException;

public class AddRowsCommand implements Command {

    private final int rowsNumber;

    public AddRowsCommand(int rowsNumber) {
        this.rowsNumber = rowsNumber;
    }

    @Override
    public void readArguments() {

    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        SpreadSheet spreadSheet = SpreadSheet.getSpreadSheet();
        spreadSheet.addRows(rowsNumber);
    }
}
