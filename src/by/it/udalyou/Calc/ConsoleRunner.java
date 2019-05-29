package by.it.udalyou.Calc;



import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String line;

        Parser parser=new Parser();
        Printer printer=new Printer();

        while (!(line=scan.nextLine()).equals("end")){

            try {
                Var resalt = parser.calk(line);
                printer.print(resalt);
            } catch (CalkException e) {
                                System.out.println(e.getMessage());
            }

        }

        }
}
