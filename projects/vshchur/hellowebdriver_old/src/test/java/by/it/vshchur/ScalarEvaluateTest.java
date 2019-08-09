package by.it.vshchur;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(value = Parameterized.class)
public class ScalarEvaluateTest {


    @Parameterized.Parameters
    public static List<String[]> createData(){
        String[][] strings = {
                {"2+2*2", "6.0"},
                {"2+2-8", "-4.0"},
                {"2+2/2", "3.0"},
                {"A=3+3*3", "12.0"},
                {"100+200", "300.0"}
        };
        return Arrays.asList(strings);
    }

    @Parameterized.Parameter(value = 0)
    public String expression;

    @Parameterized.Parameter(value = 1)
    public String result;


    @Test
    public void calc() throws Exception {
        Parser parser=new Parser();
        Var actual = parser.calc(expression);
        Assert.assertEquals(result,actual.toString());
        System.out.println("passed "+expression+" = "+result);
    }

}