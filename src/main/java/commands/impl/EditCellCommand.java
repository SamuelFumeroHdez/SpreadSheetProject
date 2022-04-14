package commands.impl;

import commands.Command;
import models.Cell;
import models.Coordinate;
import models.SpreadSheet;

public class EditCellCommand implements Command {

    Coordinate coordinate;
    String newValue;

    public EditCellCommand(Coordinate coordinate, String newValue) {
        this.coordinate = coordinate;
        this.newValue = newValue;
    }

    @Override
    public void readArguments() {

    }

    @Override
    public void execute() {

        Cell cell = SpreadSheet.getCellByCoordinate(coordinate);
        cell.setValue(Double.parseDouble(newValue));

    }
}
