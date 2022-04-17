package operations;

public class Sum extends Operation{


    public Sum(double firstOp, double secondOp) {
        super(firstOp, secondOp);
    }

    @Override
    public double getResult() {
        return firstOp + secondOp;
    }
}
