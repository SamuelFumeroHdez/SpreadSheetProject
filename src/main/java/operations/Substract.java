package operations;

public class Substract extends Operation{
    public Substract(double firstOp, double secondOp) {
        super(firstOp, secondOp);
        this.priority = 2;
    }

    @Override
    public String toString() {
        return "Substract{" +
                "firstOp=" + firstOp +
                ", secondOp=" + secondOp +
                ", priority=" + priority +
                '}';
    }

    @Override
    public double getResult() {
        return firstOp - secondOp;
    }
}
