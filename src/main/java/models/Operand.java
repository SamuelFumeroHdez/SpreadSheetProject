package models;

public class Operand {

    private double finalValue;

    private final OperandType type;

    public Operand(OperandType type) {
        this.type = type;
    }

    public OperandType getType() {
        return type;
    }

}
