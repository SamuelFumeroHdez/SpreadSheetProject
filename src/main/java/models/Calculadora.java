package models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculadora {
    private List<String> operators = Arrays.asList("+", "-", "*", "/");
    private List<String> operandsList = new ArrayList<>();
    private List<String> operatorsList = new ArrayList<>();
    private List<String> auxList = new ArrayList<>();
    private List<String> operation = new ArrayList<>();

    private String expression;

    public Calculadora(String expression){
        this.expression = expression;
    }

    public void processExpression(){
        for(char token : expression.toCharArray()){
            if(isOperator(token)){
                operatorsList.add(Character.toString(token));
                addAndClean();
            }else{
                auxList.add(Character.toString(token));
            }
        }
        buildOperation();
    }

    private boolean isOperator(char token){
        return operators.contains(token);
    }

    private void addAndClean(){
        String result = "";
        for(String s : auxList){
            result += s;
        }
        operandsList.add(result);
        auxList.clear();
    }

    private void buildOperation(){
        int count = 0;
        for(String s : operandsList){
            if(isNumeric(s)){
                operation.add(s);
            }else{
                //Tener en cuenta que las celdas pueden ser de mas de dos caracteres
                char column = s.charAt(0); // Columna
                int row = Integer.parseInt(Character.toString(s.charAt(1))); // Fila
                operation.add(String.valueOf(SpreadSheet.getCellByCoordinate(new Coordinate(column,row))));
            }

            operation.add(operatorsList.get(count));
            count++;

        }
    }

    private boolean isNumeric(String s){
        return  s.chars().allMatch( Character::isDigit );
    }

}
