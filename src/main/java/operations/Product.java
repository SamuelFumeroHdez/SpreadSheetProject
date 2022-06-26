package operations;

import models.Operand;

public class Product extends Operation{
    public Product(Operand firstOp, Operand secondOp) {
        super(firstOp, secondOp);
        this.priority = 1;
    }

    @Override
    public String toString() {
        return "Product{" +
                "firstOp=" + firstOp +
                ", secondOp=" + secondOp +
                ", priority=" + priority +
                '}';
    }

    @Override
    public Integer getResult() {
        return firstOp.getFinalValue() * secondOp.getFinalValue();
    }
}
