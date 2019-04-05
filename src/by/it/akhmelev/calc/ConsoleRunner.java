package by.it.akhmelev.calc;

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
            Var var = null;
            try {
                var = parser.calc(expression);
            } catch (CalcException e) {
                System.out.println("Ошибка в "+expression);
                System.out.println(e.getMessage());
            }
            printer.print(var);
        }
    }
}