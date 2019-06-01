package by.it.udalyou;

import by.it.udalyou.calculator.CalcException;
import by.it.udalyou.calculator.Parser;
import by.it.udalyou.calculator.Var;
import org.testng.Assert;
import org.testng.annotations.Test;

class ScalarExceptionTest extends Assert {
    public ScalarExceptionTest() {
    }

    @Test(
            expectedExceptions = {CalcException.class}
    )
    public void checkCalcException() throws Exception {
        Parser parser = new Parser();
        parser.calc("sadasd+asdasdas");
    }

    @Test(
            expectedExceptions = {CalcException.class}
    )
    public void checkVarCreate() throws Exception {
        Var var = Var.createVar("bla bla bla");
    }
}
