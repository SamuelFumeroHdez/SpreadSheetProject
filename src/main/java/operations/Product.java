package operations;

public class Product extends Operation{
    public Product(double firstOp, double secondOp) {
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
    public double getResult() {
        return firstOp * secondOp;
    }
}
