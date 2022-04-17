package operations;

public class Division extends Operation{

    public Division(double firstOp, double secondOp) {
        super(firstOp, secondOp);
    }

    @Override
    public double getResult() {
        assert(super.secondOp != 0.0);
        return firstOp / secondOp;
    }
}
