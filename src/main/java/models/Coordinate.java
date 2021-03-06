package models;

import java.io.Serializable;

/**
 * Represents the coordinate of each cell
 *
 */
public class Coordinate implements Serializable {

    /**
     * Column of the cell
     */
    private char column;

    /**
     * Row of the cell
     */
    private int row;

    /**
     * Constructor of the class Coordinate
     * @param row
     * @param column
     */
    public Coordinate(char column, int row) {
        this.column = column;
        this.row = row;
    }


    /**
     * Getter of the row
     * @return row
     */
    public int getRow() {
        return row;
    }

    /**
     * Setter of the row
     * @param row
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Getter of the column
     * @return column
     */
    public char getColumn() {
        return column;
    }

    /**
     * Setter of the column
     * @param column
     */
    public void setColumn(char column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
