package models;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.TopLevelElement;
import functions.*;

import java.util.ArrayList;

public class Operand {

    private Integer finalValue;

    private final String value;

    private OperandType type;

    private static final String SUMA_STRING = "SUMA";
    private static final String MAX_STRING = "MAX";
    private static final String MIN_STRING = "MIN";
    private static final String AVERAGE_STRING = "AVERAGE";

    public Operand(String value) {
        this.value = value;
        this.type = getType();
    }

    public OperandType getType() {
        if (isNumeric(value)) {
            return OperandType.NUMERIC;
        } else if (isFunction(value)) {
            return OperandType.FUNCTION;
        } else if (isCell(value)) {
            return OperandType.CELL;
        } else {
            return null;
        }
    }

    private boolean isNumeric(String str) {
        boolean isNumeric = true;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                isNumeric = false;
            }
        }
        return isNumeric;
    }

    private boolean isFunction(String str) {
        return str.contains("(");
    }

    private boolean isCell(String str) {
        return str.length() == 2 && (Character.isAlphabetic(str.charAt(0)) && Character.isDigit(str.charAt(1)));
    }

    public Integer getFinalValue() {
        if(type.name() == "NUMERIC"){
            return Integer.parseInt(value);
        }else if(type.name() == "FUNCTION"){
            String type = value.substring(0,value.indexOf("("));
            String[] values = value.substring(value.indexOf("(")+1, value.indexOf(")")).split(",");
            ArrayList<Operand> operands = new ArrayList<>();
            for(String str : values){
                operands.add(new Operand(str));
            }
            if (type.equalsIgnoreCase(SUMA_STRING)){
                Function suma = new Suma(operands);
                return suma.getResult();
            }else if(type.equalsIgnoreCase(MAX_STRING)){
                Function max = new Max(operands);
                return max.getResult();
            }else if(type.equalsIgnoreCase(MIN_STRING)){
                Function min = new Min(operands);
                return min.getResult();
            }else if(type.equalsIgnoreCase(AVERAGE_STRING)){
                Function average = new Average(operands);
                return average.getResult();
            }
        }else if(type.name() == "CELL"){
            char column = value.charAt(0);
            int row = Integer.parseInt(String.valueOf(value.charAt(1)));
            int cellValue = SpreadSheet.getCellByCoordinate(new Coordinate(column, row)).getValue();
            return cellValue;
        }
        return 0;
    }

    public void setFinalValue(Integer finalValue) {
        this.finalValue = finalValue;
    }

    public String getValue() {
        return value;
    }
}
