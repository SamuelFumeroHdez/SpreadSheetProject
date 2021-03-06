package models;

import exceptions.ColumnsNumberOutOfAlphabetLengthException;
import utils.AlphabetToNumber;

import java.io.Serializable;
import java.security.AlgorithmParameterGenerator;
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
        if(spreadSheet == null){
            spreadSheet = new SpreadSheet(1, 1);
            return spreadSheet;
        }
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
                    currentCell.setValue(0);
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

    public void addRows(int rowsNumber){

        int baseRow = lastCell.getCoordinate().getRow();
        Cell currentCell = null;
        for(int rows = 0 ; rows<rowsNumber ; rows++){
            for (int columns = 0 ; columns < AlphabetToNumber.charToNumber(lastCell.getCoordinate().getColumn()) ; columns++){
                currentCell = new Cell(new Coordinate(AlphabetToNumber.numberToChar((columns+1)),baseRow+rows+1));
                currentCell.setValue(0);
                cellList.add(currentCell);
            }
        }
        lastCell = cellList.get(cellList.size()-1);
    }


    public void addColumns(int columnsNumber){
        int baseColumn = AlphabetToNumber.charToNumber(lastCell.getCoordinate().getColumn());
        Cell currentCell = null;
        for(int rows = 0 ; rows<lastCell.getCoordinate().getRow() ; rows++){
            for (int columns = 0 ; columns < columnsNumber  ; columns++){
                currentCell = new Cell(new Coordinate(AlphabetToNumber.numberToChar((baseColumn+columns+1)),rows+1));
                currentCell.setValue(0);
                cellList.add(currentCell);
            }

        }
        lastCell = cellList.get(cellList.size()-1);

    }



    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("");

        for (int i = 1; i < AlphabetToNumber.charToNumber(lastCell.getCoordinate().getColumn())+1 ; i++) {
            result.append("  " + AlphabetToNumber.numberToChar(i) + "   ");

        }

        result.append("\n");
        for (int row = 1; row <= lastCell.getCoordinate().getRow() ; row++) {
            result.append(row);
            result.append("");

            for(int i=0 ; i<5*AlphabetToNumber.charToNumber(lastCell.getCoordinate().getColumn()) ; i++){
                result.append("-");
            }
            result.append("\n");
            for (int column = 0; column < AlphabetToNumber.charToNumber(lastCell.getCoordinate().getColumn()) ; column++) {

                Cell celda = getCellByCoordinate(new Coordinate(AlphabetToNumber.numberToChar(column+1), row));

                result.append("| " + " " + getCellByCoordinate(new Coordinate(AlphabetToNumber.numberToChar(column+1), row)).getValue() + " ");
            }
            result.append("|\n");
        }
        result.append("");


        return String.valueOf(result);
    }
}
