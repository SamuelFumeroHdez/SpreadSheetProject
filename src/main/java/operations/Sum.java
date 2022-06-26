package operations;

import models.Operand;

public class Sum extends Operation{


    public Sum(Operand firstOp, Operand secondOp) {
        super(firstOp, secondOp);
        this.priority = 2;
    }

    @Override
    public String toString() {
        return "Sum{" +
                "firstOp=" + firstOp +
                ", secondOp=" + secondOp +
                ", priority=" + priority +
                '}';
    }

    @Override
    public Integer getResult() {
        return firstOp.getFinalValue() + secondOp.getFinalValue();
    }
}
