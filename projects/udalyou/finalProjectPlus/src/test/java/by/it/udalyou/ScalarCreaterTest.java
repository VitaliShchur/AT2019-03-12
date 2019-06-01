package by.it.udalyou;


import by.it.udalyou.calculator.Var;
import org.testng.Assert;
import org.testng.annotations.Test;

class ScalarCreateTest {
    public ScalarCreateTest() {
    }

    @Test
    public void checkVarCreate() throws Exception {
        Var var = Var.createVar("123");
        Assert.assertEquals("123.0", var.toString());
    }
}
