package functions;

import models.Operand;

import java.util.ArrayList;

public class Max extends Function {
    public Max(ArrayList<Operand> operands) {
        super(operands);

    }

    @Override
    public String toString() {
        return null;
    }


    @Override
    public Integer getResult() {
        Integer max = operands.get(0).getFinalValue();
        for (Operand op : operands){
            if(max<op.getFinalValue()){
                max = op.getFinalValue();
            }
        }
        return max;
    }
}
