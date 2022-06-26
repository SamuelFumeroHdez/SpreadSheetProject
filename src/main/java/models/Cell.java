package models;

import java.io.Serializable;

/**
 * Represents a cell into the Spreadsheet
 */
public class Cell /*extends Operand*/{

    /**
     * Coordinate where the cell is
     */
    private Coordinate coordinate;

    /**
     * Value of the cell
     */
    private Integer value;

    /**
     * Formula that the cell have
     */
    private String formula;

    /**
     * Constructor of the Cell class
     * @param coordinate
     */
    public Cell(Coordinate coordinate) {
        //super(OperandType.CELL);
        this.coordinate = coordinate;
    }

    public Cell() {
        //super(OperandType.CELL);
    }

    /**
     * Getter of the coordinate
     * @return
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Setter of the coordinate
     * @param coordinate
     */
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    /**
     * Getter of the value
     * @return
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Setter of the value
     * @param value
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * Getter of the formula
     * @return
     */
    public String getFormula() {
        return formula;
    }

    /**
     * Setter of the formula
     * @param formula
     */
    public void setFormula(String formula) {
        this.formula = formula;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "coordinate=" + coordinate +
                '}';
    }
}
