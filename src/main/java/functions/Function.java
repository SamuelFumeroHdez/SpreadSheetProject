package functions;

import models.Operand;

import java.util.ArrayList;

public abstract class Function {

    protected final ArrayList<Operand> operands;

    public Function(ArrayList<Operand> operands) {
        this.operands = operands;
    }

    @Override
    public abstract String toString();

    public abstract Integer getResult();

}
