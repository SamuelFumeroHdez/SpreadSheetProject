package operations;

public abstract class Operation {

    protected double firstOp;
    protected double secondOp;
    protected double priority;

    public Operation(double firstOp, double secondOp) {
        this.firstOp = firstOp;
        this.secondOp = secondOp;
    }

    @Override
    public abstract String toString();

    public abstract double getResult();

}
