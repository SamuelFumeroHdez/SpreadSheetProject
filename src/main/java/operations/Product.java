package operations;

public class Product extends Operation{
    public Product(double firstOp, double secondOp) {
        super(firstOp, secondOp);
    }

    @Override
    public double getResult() {
        return firstOp * secondOp;
    }
}
