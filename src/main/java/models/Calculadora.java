package models;

import operations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Calculadora {
    private List<String> operators = Arrays.asList("+", "-", "*", "/");
    private List<Integer> operandsList = new ArrayList<>();
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

        char lastOperandChar = expression.charAt(expression.length()-1);
        Operand lastOperand = new Operand(String.valueOf(lastOperandChar));
        operandsList.add(lastOperand.getFinalValue());

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

        operandsList.add(new Operand(result).getFinalValue());
        auxList.clear();
    }

    public void buildOperation(){
        int count = 0;
        for(Integer op : operandsList){
            System.out.println("Operand: " + op);
            operation.add(String.valueOf(op));
//            if(isNumeric(op.getValue())){
//                operation.add(s);
//            }else{
//                char column = s.charAt(0); // Columna
//                int row = Integer.parseInt(Character.toString(s.charAt(1))); // Fila
//                operation.add(String.valueOf(SpreadSheet.getCellByCoordinate(new Coordinate(column,row))));
//            }
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
    public Integer execute(){
        System.out.println(operandsList);
        System.out.println(operatorsList);

        List<Integer> resultList = operandsList;
        List<Operation> operationList = new ArrayList<>();
        Operation operation = null;

        for(Operator operator : operatorsList){
            operation = getOperation(operator, new Operand(String.valueOf(operandsList.get(operator.getOriginalPosition()))),
                    new Operand(String.valueOf(operandsList.get(operator.getOriginalPosition()+1))));
            operationList.add(operation);
        }
        int pos;
        Integer rightValue;
        Integer leftValue;
        Integer result = 0;

        for(Operator operator : operatorsList){
            pos = operator.getOriginalPosition()+1;
            rightValue = operandsList.get(pos);

            int leftPos = assignLeftOperand(pos);
            leftValue = resultList.get(assignLeftOperand(pos));
            Operation operation1 = getOperation(operator, new Operand(String.valueOf(leftValue)), new Operand(String.valueOf(rightValue)));

            resultList.set(pos, null);
            resultList.set(leftPos, operation1.getResult());
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

    public Operation getOperation(Operator operator, Operand firstOperand, Operand secondOperand) {

        if(operator.getValue().equals("+")){
            return new Sum(firstOperand, secondOperand);
        }else if(operator.getValue().equals("-")){
            return new Substract(firstOperand, secondOperand);
        }else if(operator.getValue().equals("*")){
            return new Product(firstOperand, secondOperand);
        }else if(operator.getValue().equals("/")){
            return new Division(firstOperand, secondOperand);
        }
        return null;
    }

    public List<Operator> getOperatorsList(){
        return this.operatorsList;
    }
}
