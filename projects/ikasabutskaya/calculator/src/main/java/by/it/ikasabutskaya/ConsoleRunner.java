package by.it.ikasabutskaya;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {

        Parser parser=new Parser();
        Printer printer=new Printer();
        Scanner scanner=new Scanner(System.in);
        for(;;){
            String expression=scanner.nextLine();
            if (expression.equals("end"))
                break;

            Var var;
            try {
                if (expression.contains("(") && expression.contains(")")) {
                    expression = parser.excludeBracers(expression);
                }

                var = parser.calc(expression);
                printer.print(var);
            } catch (CalcException e) {
                System.out.println("Ошибка в " + expression + "\n" + e.getMessage());
            }
        }
    }
}

