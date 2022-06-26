package commands.impl;

import commands.Command;
import models.SpreadSheet;

import java.io.IOException;

public class AddColumnsCommand implements Command {

    private final int columnsNumber;

    public AddColumnsCommand(int columnsNumber) {
        this.columnsNumber = columnsNumber;
    }

    @Override
    public void readArguments() {

    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        SpreadSheet spreadSheet = SpreadSheet.getSpreadSheet();
        spreadSheet.addColumns(columnsNumber);
    }
}
