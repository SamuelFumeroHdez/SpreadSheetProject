package functions;

import models.Operand;

import java.util.ArrayList;

public class Min extends Function {
    public Min(ArrayList<Operand> operands) {
        super(operands);

    }

    @Override
    public String toString() {
        return null;
    }


    @Override
    public Integer getResult() {
        Integer min = operands.get(0).getFinalValue();
        for (Operand op : operands){
            if(min>op.getFinalValue()){
                min = op.getFinalValue();
            }
        }
        return min;
    }
}
