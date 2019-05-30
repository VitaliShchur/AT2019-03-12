package by.it.ikasabutskaya;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {

    private double[][] arr;

    private Matrix(double[][] value) {
        this.arr = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            this.arr[i] = Arrays.copyOf(value[i],value[i].length);
        }
    }
    Matrix(Matrix matrix){
        this.arr = matrix.arr;
    }

    Matrix(String strMatrix){
        StringBuilder stringBuilder = new StringBuilder(strMatrix);
        Pattern arrayPattern = Pattern.compile("\\{[- 0-9.,]+\\}");
        Pattern commas = Pattern.compile("\\},\\s?\\{");
        Matcher rows = arrayPattern.matcher(stringBuilder);
        Matcher count = commas.matcher(stringBuilder);

        int length = 1;
        while (count.find()){
            length++;
        }


        this.arr = new double[length][1];
        int i=0;
        while (rows.find()){
            int j=0;
            String row[] = rows.group().replace("{","").replace("}","").replaceAll(" ","").split(",");
            for (String s : row) {
                this.arr[i] = Arrays.copyOf(arr[i],j+1);
                this.arr[i][j] = Double.parseDouble(s);
                j++;
            }
            i++;
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar){
            double[][] array = new double[this.arr.length][this.arr[0].length];
            for (int i = 0; i < array.length; i++) {
                array[i] = Arrays.copyOf(this.arr[i], this.arr[i].length);
            }
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    array[i][j] = array[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(array);
        }
        if (other instanceof Matrix) {
            if ((((Matrix) other).arr.length==this.arr.length) && (((Matrix) other).arr[0].length==this.arr.length)){
                double[][] array = new double[this.arr.length][this.arr[0].length];
                for (int i = 0; i < array.length; i++) {
                    array[i] = Arrays.copyOf(this.arr[i], this.arr[i].length);
                }

                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array[0].length; j++) {
                        array[i][j] = array[i][j] + ((Matrix) other).arr[i][j];
                    }
                }
                return new Matrix(array);
            }
            else throw new CalcException("Матрицы должны быть одного размера! ");

        }
        else
            return super.add(other);
    }


    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar){
            double[][] array = new double[this.arr.length][this.arr[0].length];
            for (int i = 0; i < array.length; i++) {
                array[i] = Arrays.copyOf(this.arr[i], this.arr[i].length);
            }
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    array[i][j] = array[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(array);
        }
        if (other instanceof Matrix){
            if ((((Matrix) other).arr.length==this.arr.length) && (((Matrix) other).arr[0].length==this.arr.length)) {
                double[][] array = new double[this.arr.length][this.arr[0].length];
                for (int i = 0; i < array.length; i++) {
                    array[i] = Arrays.copyOf(this.arr[i], this.arr[i].length);
                }

                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array[0].length; j++) {
                        array[i][j] = array[i][j] - ((Matrix) other).arr[i][j];
                    }
                }
                return new Matrix(array);
            }
            else throw new CalcException("Матрицы должны быть одного размера! ");

        }
        else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {

            for (int i = 0; i < this.arr.length; i++) {
                for (int j = 0; j < this.arr[0].length; j++) {
                    this.arr[i][j] = this.arr[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(this.arr);

        } else if (other instanceof Matrix) {
            if(this.arr[0].length == ((Matrix) other).arr.length) {
                double[][] resultMatrix = new double[this.arr.length][((Matrix) other).arr[0].length];
                double sum = 0;
                for (int i = 0; i < this.arr.length; i++) {
                    for (int j = 0; j < ((Matrix) other).arr[0].length; j++) {
                        for (int k = 0; k < ((Matrix) other).arr.length; k++) {
                            sum = sum + this.arr[i][k] * ((Matrix) other).arr[k][j];
                        }
                        resultMatrix[i][j] = sum;
                        sum = 0;
                    }

                }
                return new Matrix(resultMatrix);
            }
            else throw new CalcException("Матрицы разного размера нельзя умножать друг на друга! ");

        } else if (other instanceof Vector) {

            double[] resultMatrix = new double[this.arr.length];
            double sum = 0;
            for (int j = 0; j < this.arr.length; j++) {
                for (int k = 0; k < ((Vector) other).getValue().length; k++) {
                    sum = sum + this.arr[j][k] * ((Vector) other).getValue()[k];
                }
                resultMatrix[j] = sum;
                sum = 0;
            }
            return new Vector(resultMatrix);

        } else
            return super.sub(other);
    }


    @Override
    public Var div(Var other) throws CalcException {
        return super.div(other);
    }


    @Override
    public String toString() {
        String result = "{";
        for (int i = 0; i < arr.length; i++) {
            result = result.concat(Arrays.toString(arr[i])).replace('[','{').replace(']','}');
            if(i!=(arr.length-1))
                result = result.concat(", ");

        }
        result = result.concat("}");
        return result;
    }

        }
