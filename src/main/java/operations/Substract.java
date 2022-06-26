package operations;

import models.Operand;

public class Substract extends Operation{
    public Substract(Operand firstOp, Operand secondOp) {
        super(firstOp, secondOp);
        this.priority = 2;
    }

    @Override
    public String toString() {
        return "Substract{" +
                "firstOp=" + firstOp +
                ", secondOp=" + secondOp +
                ", priority=" + priority +
                '}';
    }

    @Override
    public Integer getResult() {
        return firstOp.getFinalValue() - secondOp.getFinalValue();
    }
}
