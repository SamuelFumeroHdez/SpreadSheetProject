package models;

import operations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Calculadora {
    private List<String> operators = Arrays.asList("+", "-", "*", "/");
    private List<String> operandsList = new ArrayList<>();
    private List<Operator> operatorsList = new ArrayList<>();
    private List<String> auxList = new ArrayList<>();
    private List<String> operation = new ArrayList<>();

    private String expression;

    public Calculadora(String expression){
        this.expression = expression;
    }

    public void processExpression(){
        Operator operator;
        int position = 0;
        for(char token : expression.toCharArray()){
            if(isOperator(token)){
                operator = getOperator(Character.toString(token), position);
                operatorsList.add(operator);
                addAndClean();
                position++;
            }else{
                auxList.add(Character.toString(token));
            }

        }
        //auxList.add(Character.toString(expression.charAt(expression.length()-1)));

        char lastOperand = expression.charAt(expression.length()-1);
        operandsList.add(String.valueOf(lastOperand));

        buildOperation();
    }

    private boolean isOperator(char token){
        for(String op : operators){
            if(String.valueOf(token).equalsIgnoreCase(op)){
                return true;
            }
        }
        return false;
    }

    private void addAndClean(){
        String result = "";
        for(String s : auxList){
            result += s;
        }
        operandsList.add(result);
        auxList.clear();
    }

    /**
     * ¡¡¡IMPORTANTE!!! Se debe refactorizar para que el añadir el ultimo valor sea responsabildiad del algoritmo
     * que cosntruye la operacion
     */
    public void buildOperation(){
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
            if(count<operandsList.size()-1){
                operation.add(operatorsList.get(count).getValue());
                count++;
            }
        }

    }

    public void sortOperatos(){
        for(Operator op : operatorsList){
            if (op.getpriority()==1){
                int right = operatorsList.indexOf(op);
                int left = right-1;
                if(right!=0){
                    while (left>=0){
                        if(operatorsList.get(left).getpriority()>1){
                            swap(operatorsList, left, right);
                        }
                        left--;
                        right--;
                    }
                }
            }
        }
    }

    private void swap(List<Operator> operatorsList, int left, int right){
        Operator aux = new Operator(operatorsList.get(left).getpriority(), operatorsList.get(left).getValue(), operatorsList.get(left).getOriginalPosition());

        operatorsList.get(left).setValue(operatorsList.get(right).getValue());
        operatorsList.get(left).setpriority(operatorsList.get(right).getpriority());
        operatorsList.get(left).setOriginalPosition(operatorsList.get(right).getOriginalPosition());

        operatorsList.get(right).setValue(aux.getValue());
        operatorsList.get(right).setpriority(aux.getpriority());
        operatorsList.get(right).setOriginalPosition(aux.getOriginalPosition());

    }
    public String execute(){
        System.out.println(operandsList);
        System.out.println(operatorsList);

        List<String> resultList = operandsList;
        List<Operation> operationList = new ArrayList<>();
        Operation operation = null;

        for(Operator operator : operatorsList){
            operation = getOperation(operator, operandsList.get(operator.getOriginalPosition()),
                    operandsList.get(operator.getOriginalPosition()+1));
            operationList.add(operation);
        }
        int pos;
        String rightValue;
        String leftValue;
        Double result = 0.0;

        for(Operator operator : operatorsList){
            pos = operator.getOriginalPosition()+1;
            rightValue = operandsList.get(pos);

            int leftPos = assignLeftOperand(pos);
            leftValue = resultList.get(assignLeftOperand(pos));
            Operation operation1 = getOperation(operator, leftValue, rightValue);

            resultList.set(pos, null);
            resultList.set(leftPos, String.valueOf(operation1.getResult()));
        }
        return resultList.get(0);
    }

    private int assignLeftOperand(int pos){
        while(operandsList.get(pos-1)==null){
            pos--;
        }
        return pos-1;
    }

    private Operator getOperator(String token, int position){
        if(token.equals("+") || token.equals("-")){
            return new Operator(2,token, position);
        }else if(token.equals("*") || token.equals("/")){
            return new Operator(1,token, position);
        }
        return null;
    }


    private boolean isNumeric(String s){
        return s.chars().allMatch( Character::isDigit );
    }

    public Operation getOperation(Operator operator, String firstOperand, String secondOperand) {

        if(operator.getValue().equals("+")){
            return new Sum(Double.parseDouble(firstOperand), Double.parseDouble(secondOperand));
        }else if(operator.getValue().equals("-")){
            return new Substract(Double.parseDouble(firstOperand), Double.parseDouble(secondOperand));
        }else if(operator.getValue().equals("*")){
            return new Product(Double.parseDouble(firstOperand), Double.parseDouble(secondOperand));
        }else if(operator.getValue().equals("/")){
            return new Division(Double.parseDouble(firstOperand), Double.parseDouble(secondOperand));
        }
        return null;
    }

    public List<Operator> getOperatorsList(){
        return this.operatorsList;
    }
}
