package by.it.ikasabutskaya;

import java.util.Arrays;

public class Vector extends Var {


    private double[] value;

    public double[] getValue() {
        return value;
    }

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(String strVector) {
        String[] s = strVector.replace("{", "").replace("}", "").replaceAll(" ", "").split(",\\s*");
        value = new double[s.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(s[i]);
        }
    }

    public Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }


    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);

        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                double[] res = Arrays.copyOf(value, value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] + ((Vector) other).value[i];
                }
                return new Vector(res);
            }
            throw new CalcException("Размер векторов должен быть одинаковым! ");

        } else
            return super.add(other);
    }


    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                double[] res = Arrays.copyOf(value, value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] - ((Vector) other).value[i];
                }
                return new Vector(res);
            }
            throw new CalcException("Размер векторов должен быть одинаковым! ");

        } else
            return super.sub(other);
    }


    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                double[] array = Arrays.copyOf(value, value.length);
                double res = 0;
                for (int i = 0; i < array.length; i++) {
                    array[i] = array[i] * ((Vector) other).value[i];
                    res = res + array[i];
                }
                return new Scalar(res);
            } else throw new CalcException("Размер векторов должен быть одинаковым! ");

        } else
            return super.mul(other);
    }


        @Override
        public Var div(Var other) throws CalcException {
            if (other instanceof Scalar) {
                if (((Scalar) other).getValue() == 0)
                    throw new CalcException("На 0 делить нельзя! ");
                double[] res = Arrays.copyOf(value, value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] / ((Scalar) other).getValue();
                }
                return new Vector(res);
            } else
                return super.div(other);
        }


    @Override
    public String toString() {
        return Arrays.toString(value).replace('[','{').replace(']','}');
    }


    }
