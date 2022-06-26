package commands.impl;

import commands.Command;
import models.Calculadora;
import models.Cell;
import models.Coordinate;
import models.SpreadSheet;

public class EditCellCommand implements Command {

    private final Coordinate coordinate;
    private final String newValue;

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
        Calculadora calculadora = new Calculadora(newValue);
        calculadora.processExpression();
        calculadora.sortOperatos();
        cell.setValue(Double.parseDouble(calculadora.execute()));

    }
}
