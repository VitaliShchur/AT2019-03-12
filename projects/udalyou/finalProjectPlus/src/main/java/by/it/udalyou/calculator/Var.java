package by.it.udalyou.calculator;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Var implements Operation {

   private static Map<String, Var> vars=new HashMap<>();
   private static String filename=System.getProperty("user.dir")+
            "/src/by/it/akhmelev/calc_12/vars.txt";

   public static Var createVar(String strVar) throws CalcException {
       strVar=strVar.replace(" ","");
       if (strVar.matches(Patterns.SCALAR))
           return new Scalar(strVar);
       else if (strVar.matches(Patterns.VECTOR))
           return new Vector(strVar);
       else if (strVar.matches(Patterns.MATRIX))
           return new Matrix(strVar);
       else {
           Var var = vars.get(strVar);
           if (var==null)
                throw new CalcException(" неизвестное выражение "+strVar);
           else
               return var;
       }
   }

    public static void saveToFile() {
        try ( PrintWriter out=new PrintWriter(new FileWriter(filename))){
            Set<Map.Entry<String, Var>> entries = vars.entrySet();
            for (Map.Entry<String, Var> entry : entries) {
                out.println(entry.getKey()+"="+entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void loadFromFile() {
       Parser p=new Parser();
        try ( BufferedReader r=new BufferedReader(new FileReader(filename))){
           while (true){
               String line=r.readLine();
               if (line==null)
                   break;
               p.calc(line);
           }

        } catch (IOException | CalcException e) {
            //todo
        }
    }


    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("сложение "+this+" + "+other+" невозможно!");
    }

    @Override
    public Var sub(Var other)  throws CalcException {
        throw new CalcException("вычитание "+this+" - "+other+" невозможно!");
    }

    @Override
    public Var mul(Var other)  throws CalcException {
        throw new CalcException("умножение "+this+" * "+other+" невозможно!");
    }

    @Override
    public Var div(Var other)  throws CalcException {
        throw new CalcException("деление "+this+" + "+other+" невозможно!");
    }

    @Override
    public String toString() {
        return "Это абстрактная переменная";
    }

    static void saveVar(String name, Var var) {
       vars.put(name, var);
    }
}
