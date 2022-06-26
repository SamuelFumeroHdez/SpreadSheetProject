package functions;

import models.Operand;

import java.util.ArrayList;

public class Average extends Function {

    public Average(ArrayList<Operand> operands) {
        super(operands);
    }

    @Override
    public String toString() {
        return null;
    }


    @Override
    public Integer getResult() {
        Integer acumulator = 0;

        for(Operand op : operands){
            acumulator += op.getFinalValue();
        }
        return acumulator / operands.size();
    }
}
