package funciones;

import models.Operand;
import models.OperandType;

import java.util.Arrays;
import java.util.List;

public class ProccessFunction {


    private List<String> types = Arrays.asList("SUM", "MAX", "MIN", "AVERAGE");
    private List<Operand> operandsList;


    ProccessFunction(String functionString){
        String functionType = functionString.substring(0, functionString.indexOf('('));
        String operands = functionString.substring(functionString.indexOf('(')+1, functionString.length()-1);
        List<String> operandsArray = Arrays.asList(operands.split(","));
        buildOperandsList(operandsArray);
    }

    private void buildOperandsList(List<String> operandsArray){
        //Convertir elemento por elemento al operando concreto
        for(String op : operandsArray){
            //operandsList.add(getOperandType(op));
        }

    }


}
