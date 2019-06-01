package by.it.udalyou;

import by.it.udalyou.calculator.Parser;
import by.it.udalyou.calculator.Var;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ScalarEvaluateTest {
    public ScalarEvaluateTest() {
    }

    @DataProvider
    public Object[][] parameters() {
        return new Object[][]{{"2+2*2", "6.0"}, {"2+2-8", "-4.0"}, {"2+2/2", "3.0"}, {"A=3+3*3", "12.0"}, {"100+200", "300.0"}};
    }

    @Test(
            dataProvider = "parameters"
    )
    public void calc(String expression, String result) throws Exception {
        Parser parser = new Parser();
        Var actual = parser.calc(expression);
        Assert.assertEquals(result, actual.toString());
        System.out.println("passed " + expression + " = " + result);
    }
}

