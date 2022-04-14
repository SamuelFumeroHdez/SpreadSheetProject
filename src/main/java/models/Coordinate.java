package models;

/**
 * Represents the coordinate of each cell
 */
public class Coordinate {

    /**
     * Row of the cell
     */
    private int row;

    /**
     * Column of the cell
     */
    private char column;

    /**
     * Constructor of the class Coordinate
     * @param row
     * @param column
     */
    public Coordinate(int row, char column) {
        this.row = row;
        this.column = column;
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
