package operations;

import models.Operand;

public abstract class Operation {

    protected Operand firstOp;
    protected Operand secondOp;
    protected Integer priority;

    public Operation(Operand firstOp, Operand secondOp) {
        this.firstOp = firstOp;
        this.secondOp = secondOp;
    }

    @Override
    public abstract String toString();

    public abstract Integer getResult();

}
