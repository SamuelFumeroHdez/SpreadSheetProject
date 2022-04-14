package models;

/**
 * Represents a cell into the Spreadsheet
 */
public class Cell {

    /**
     * Coordinate where the cell is
     */
    private Coordinate coordinate;

    /**
     * Value of the cell
     */
    private Double value;

    /**
     * Formula that the cell have
     */
    private String formula;

    /**
     * Constructor of the Cell class
     * @param coordinate
     */
    public Cell(Coordinate coordinate) {
        this.coordinate = coordinate;
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
    public Double getValue() {
        return value;
    }

    /**
     * Setter of the value
     * @param value
     */
    public void setValue(Double value) {
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
