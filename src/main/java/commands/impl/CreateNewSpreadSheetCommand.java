package commands.impl;

import commands.Command;
import models.SpreadSheet;

public class CreateNewSpreadSheetCommand implements Command {

    int rows;
    int columns;


    public CreateNewSpreadSheetCommand(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    @Override
    public void readArguments() {

    }

    @Override
    public void execute() {
        SpreadSheet spreadSheet = new SpreadSheet(rows, columns);
        System.out.println(spreadSheet);
    }
}
