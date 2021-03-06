package by.it.agrinkevich.calc.at14;

import by.it.agrinkevich.calc.CalcException;
import by.it.agrinkevich.calc.Parser;
import by.it.agrinkevich.calc.Var;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;


@RunWith(value = Parameterized.class)
public class ScalarDivTest {

    @Parameterized.Parameters
    public static List<String[]> createData() {
        String[][] str = {
                {"8/4", "2.0"},
                {"100/20", "5.0"},
                {"8.75/3.5", "2.5"},
                {"6.6/1.1", "6.0"},
                {"22.5/5", "4.5"}

        };
        return Arrays.asList(str);
    }

    @Parameterized.Parameter(value = 0)
    public String expression;

    @Parameterized.Parameter(value = 1)
    public String result;

    @Test
    public void div() throws CalcException {
        Parser parser = new Parser();
        Var actual = parser.calc(expression);
        Assert.assertEquals(result, actual.toString());
        System.out.println("passed: " + expression +"="+ result);
    }
}

