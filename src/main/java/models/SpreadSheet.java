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

    private SpreadSheet(int rows, int columns) {
        try{
            columnsLength(columns); //Controlar que el numero de columnas es menor que la longitud del alfabeto
            cellList = new ArrayList<>();
            for (int rowCount = 0 ; rowCount < rows ; rowCount++){
                for (int columnCount = 0 ; columnCount < columns ; columnCount++){
                    char columnAsChar = AlphabetToNumber.numberToChar(columnCount+1);
                    cellList.add(new Cell(new Coordinate(rowCount+1,columnAsChar)));
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
        return "SpreadSheet{" +
                "cellList=" + cellList +
                ", lastCell=" + lastCell +
                '}';
    }
}
