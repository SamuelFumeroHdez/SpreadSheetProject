package commands.impl;

import commands.Command;
import models.SpreadSheet;

public class CreateNewSpreadSheetCommand implements Command {

    private final int rows;
    private final int columns;


    public CreateNewSpreadSheetCommand(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    @Override
    public void readArguments() {

    }

    @Override
    public void execute() {
        SpreadSheet spreadSheet = SpreadSheet.getSpreadsheet(rows, columns);
        System.out.println(spreadSheet);
    }
}
