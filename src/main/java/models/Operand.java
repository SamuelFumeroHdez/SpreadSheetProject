package models;

public class Operand {

    private double finalValue;

    private Double value;

    private final OperandType type;

    private int originalPosition;

    public Operand(OperandType type, Double value, int originalPosition) {
        this.type = type;
        this.value = value;
        this.originalPosition = originalPosition;
    }

    public OperandType getType() {
        return type;
    }

    public double getFinalValue() {
        return finalValue;
    }

    public void setFinalValue(double finalValue) {
        this.finalValue = finalValue;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public int getOriginalPosition() {
        return originalPosition;
    }

    public void setOriginalPosition(int originalPosition) {
        this.originalPosition = originalPosition;
    }
}
