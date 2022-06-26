package functions;

import models.Operand;

import java.util.ArrayList;

public class Suma extends Function {


    public Suma(ArrayList<Operand> operands) {
        super(operands);

    }

    @Override
    public String toString() {
        return null;
    }


    @Override
    public Integer getResult() {
        Integer result = 0;
        for (Operand op : this.operands){
            result += op.getFinalValue();
        }
        return result;
    }
}
