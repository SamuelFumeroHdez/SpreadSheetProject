package models;

public class Operand {

    private OperandType type;

    public Operand(OperandType type) {
        this.type = type;
    }

    public OperandType getType() {
        return type;
    }

    public void setType(OperandType type) {
        this.type = type;
    }
}
