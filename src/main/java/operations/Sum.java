package operations;

public class Sum extends Operation{


    public Sum(double firstOp, double secondOp) {
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
    public double getResult() {
        return firstOp + secondOp;
    }
}
