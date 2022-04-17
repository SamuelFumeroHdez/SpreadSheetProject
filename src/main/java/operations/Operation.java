package operations;

public abstract class Operation {

    protected double firstOp;
    protected double secondOp;

    public Operation(double firstOp, double secondOp) {
        this.firstOp = firstOp;
        this.secondOp = secondOp;
    }

    public abstract double getResult();

}
