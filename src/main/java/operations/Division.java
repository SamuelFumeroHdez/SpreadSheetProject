package operations;

public class Division extends Operation{

    public Division(double firstOp, double secondOp) {
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
    public double getResult() {
        assert(super.secondOp != 0.0);
        return firstOp / secondOp;
    }
}
