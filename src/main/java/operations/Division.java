package operations;

import models.Operand;

public class Division extends Operation{

    public Division(Operand firstOp, Operand secondOp) {
        super(firstOp, secondOp);
        this.priority = 1;
    }

    @Override
    public String toString() {
        return "Division{" +
                "firstOp=" + firstOp +
                ", secondOp=" + secondOp +
                ", priority=" + priority +
                '}';
    }

    @Override
    public Integer getResult() {
        assert(super.secondOp.getFinalValue() != 0.0);
        return firstOp.getFinalValue() / secondOp.getFinalValue();
    }
}
