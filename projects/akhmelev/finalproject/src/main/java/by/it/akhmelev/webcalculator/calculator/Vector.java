package by.it.akhmelev.webcalculator.calculator;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value,value.length);
    }

    public Vector(String strVector) {
        String[] s = strVector.replace("{", "").replace("}", "").split(",\\s*");
        value=new double[s.length];
        for (int i = 0; i < s.length; i++) {
            value[i]= Double.parseDouble(s[i]);
        }
    }

    public Vector(Vector vector) {
        this.value= Arrays.copyOf(vector.value,vector.value.length);
    }

    @Override
    public Var add(Var other)  throws CalcException {
        if (other instanceof Scalar){
            double[] res= Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]+((Scalar) other).value;
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double[] res= Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]+((Vector) other).value[i];
            }
            return new Vector(res);
        }
        return super.add(other);
    }

    @Override
    public String toString() {
        return Arrays.toString(value).replace('[','{').replace(']','}');
    }
}
