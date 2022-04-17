package models;

import exceptions.ColumnsNumberOutOfAlphabetLengthException;
import utils.AlphabetToNumber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SpreadSheet implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final int COLUMNS_LIMIT = 26;
    private static List<Cell> cellList;
    private Cell lastCell;
    private static SpreadSheet spreadSheet;

    public static SpreadSheet getSpreadsheet(int rows, int columns){
        if(spreadSheet == null){
            spreadSheet = new SpreadSheet(rows, columns);
            return spreadSheet;
        }
        return spreadSheet;

    }

    public static SpreadSheet getSpreadSheet(){
        return spreadSheet;
    }

    private SpreadSheet(int rows, int columns) {
        try{
            columnsLength(columns); //Controlar que el numero de columnas es menor que la longitud del alfabeto
            cellList = new ArrayList<>();
            Cell currentCell = null;
            for (int rowCount = 0 ; rowCount < rows ; rowCount++){
                for (int columnCount = 0 ; columnCount < columns ; columnCount++){
                    char columnAsChar = AlphabetToNumber.numberToChar(columnCount+1);
                    currentCell = new Cell(new Coordinate(columnAsChar, rowCount+1));
                    currentCell.setValue(0.0);
                    cellList.add(currentCell);
                }
            }
            lastCell = cellList.get(cellList.size()-1);

        }catch (ColumnsNumberOutOfAlphabetLengthException exception){
            System.out.println(exception.getMessage());
        }

    }

    public List<Cell> getCellList() {
        return cellList;
    }

    public void setCellList(List<Cell> cellList) {
        this.cellList = cellList;
    }

    public Cell getLastCell() {
        return lastCell;
    }

    public void setLastCell(Cell lastCell) {
        this.lastCell = lastCell;
    }

    private void columnsLength(int columns) throws ColumnsNumberOutOfAlphabetLengthException {
        if (columns > COLUMNS_LIMIT){
            throw new ColumnsNumberOutOfAlphabetLengthException("Number of column out of latin alphabet.");
        }
    }

    public static Cell getCellByCoordinate(Coordinate coordinate){
        for(Cell cell : cellList){
            if(coordinate.getRow() == cell.getCoordinate().getRow() &&
                String.valueOf(coordinate.getColumn()).equalsIgnoreCase(String.valueOf(cell.getCoordinate().getColumn()))){
                return cell;
            }
        }

        // TODO excepcion no se ha encontrado la celda
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("");
        for (int i = 1; i <= AlphabetToNumber.charToNumber(lastCell.getCoordinate().getColumn()) ; i++) {
            result.append("   " + cellList.get(i).getCoordinate().getColumn() + " ");
        }
        result.append("\n");
        for (int row = 1; row <= lastCell.getCoordinate().getRow() ; row++) {
            result.append(row);
            result.append("");
            result.append("---------------------------------\n");

            for (int column = 1; column < AlphabetToNumber.charToNumber(lastCell.getCoordinate().getColumn()) ; column++) {

                Cell celda = getCellByCoordinate(new Coordinate(AlphabetToNumber.numberToChar(column), row));

                result.append("| " + " " + getCellByCoordinate(new Coordinate(AlphabetToNumber.numberToChar(column), row)).getValue() + " ");
            }
            result.append("|\n");
        }
        result.append("");
        result.append("---------------------------------\n");

        return String.valueOf(result);
    }
}
