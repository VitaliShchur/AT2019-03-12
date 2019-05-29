package by.it.ikasabutskaya.calc_at13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



class Parser {


        private static final List<String> priority = new ArrayList<>(Arrays.asList("=,+,-,*,/".split(",")));
        private List<String> operation = new ArrayList<>();
        private List<String> operand;

        private int getPosOperation(){
            int level = -1, pos = -1, i = 0;
            for (String op : operation) {
                int currentLevel = priority.indexOf(op);
                if(level<currentLevel) {
                    level = currentLevel;
                    pos = i;
                    }
                i++;
            }
        return pos;
    }

    by.it.ikasabutskaya.calc_at13.Var calc(String expression) throws CalcException {

        String[] operands = expression.split(Patterns.OPERATION);
        operand = new ArrayList<>(Arrays.asList(operands));

        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            operation.add(matcher.group());
        }

        Var res = null;
        while (operation.size() > 0) {
            int pos = getPosOperation();
            String vl = operand.get(pos);
            String op = operation.remove(pos);
            String v2 = operand.remove(pos + 1);
            res = operationCalc(vl, op, v2);
            operand.set(pos, res.toString());
        }
        return res;
    }

    String excludeBracers(String expression) throws CalcException {
        String res = expression, calculation;
        while ((res.contains("(")) || (res.contains(")"))) {
            Pattern pattern = Pattern.compile(Patterns.BRACES);
            Matcher matcher = pattern.matcher(res);
            while (matcher.find()) {
                calculation = matcher.group().replace("(", "").replace(")", "");
                res = res.replace(matcher.group(), calc(calculation).toString());
            }
        }
        return res;

    }

    private Var operationCalc(String v1, String operation, String v2) throws CalcException {
        Var two = Var.createVar(v2);
        if (operation.equals("=")){
            return Var.saveVar(v1, two);
        }
        Var one = Var.createVar(v1);

        switch (operation) {
            case "+": return one.add(two);
            case "-": return one.sub(two);
            case "*": return one.mul(two);
            case "/": return one.div(two);
        }
        return null;

        }
 }