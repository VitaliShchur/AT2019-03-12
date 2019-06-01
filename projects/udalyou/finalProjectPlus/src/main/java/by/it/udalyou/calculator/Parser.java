package by.it.udalyou.calculator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private Map<String,Integer> priority;

    public Parser() {
        priority = new HashMap<>();
        priority.put("=",0);
        priority.put("+",1);
        priority.put("-",1);
        priority.put("*",2);
        priority.put("/",2);
    }

    private int getIndex(List<String> operations) {
        int currentPriority=-1;
        int index=-1;
        for (int i = 0; i < operations.size(); i++) {
            String op = operations.get(i);
            if (priority.get(op)>currentPriority){
                currentPriority=priority.get(op);
                index=i;
            }
        }
        return index;
    }


    private Var oneOperation(String operand1, String operation, String operand2) throws CalcException {
        Var two = Var.createVar(operand2);
        if (operation.equals("=")) {
            Var.saveVar(operand1, two);
            return two;
        }
        Var one = Var.createVar(operand1);
        switch (operation) {
            case "+":
                return one.add(two);
            case "-":
                return one.sub(two);
            case "*":
                return one.mul(two);
            case "/":
                return one.div(two);
            default:
                throw new CalcException("что странное произошло");
        }
    }

    public Var calc(String expression) throws CalcException {
        //2.0*3.0
        Pattern patternOperation = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = patternOperation.matcher(expression);
        List<String> operations = new ArrayList<>();
        while (matcher.find())
            operations.add(matcher.group());
        String[] parts = expression.split(Patterns.OPERATION);
        List<String> tmp = Arrays.asList(parts);
        List<String> operands = new ArrayList<>(tmp);
        while (!operations.isEmpty()) {
            int index = getIndex(operations);
            String operand1 = operands.remove(index);
            String operand2 = operands.remove(index);
            String operation = operations.remove(index);
            Var result = oneOperation(operand1, operation, operand2);
            operands.add(index, result.toString());
        }
        String result=operands.get(0);
        return Var.createVar(result);

    }
}
