package operations;

public class Substract extends Operation{
    public Substract(double firstOp, double secondOp) {
        super(firstOp, secondOp);
    }

    @Override
    public double getResult() {
        return firstOp * secondOp;
    }
}
