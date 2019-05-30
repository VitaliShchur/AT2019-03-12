package by.it.ikasabutskaya.calc_at13;

public class Scalar extends Var {

    double value;

    public double getValue() {return value; }

    public Scalar(double value) {
        this.value = value;
    }



    public Scalar(String strScalar) {
        value=Double.parseDouble(strScalar); }


    public Scalar(Scalar scalar) {
        this.value = scalar.value;
    }


    @Override
    public String toString() {
        return Double.toString(value);
    }


    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar){
            Scalar i = (Scalar)other;
            double result = this.value + i.value;
            return new Scalar(result);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar){
            Scalar i = (Scalar)other;
            double result = this.value - i.value;
            return new Scalar(result);
        }
        else return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar){
            Scalar i = (Scalar)other;
            double result = this.value * i.value;
            return new Scalar(result);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar i = (Scalar) other;
            if (i.value == 0)
                throw new CalcException("Деление на ноль ");


            double result = this.value / i.value;
            return new Scalar(result);
        }
        else
            return super.div(other);

    }

}
