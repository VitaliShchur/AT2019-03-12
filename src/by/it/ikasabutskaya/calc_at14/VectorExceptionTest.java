package by.it.ikasabutskaya.calc_at14;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

@RunWith(value = Parameterized.class)
public class VectorExceptionTest {

    private Parser p;

    @Before
    public void parserInit()
    {
        p = new Parser();
    }

    @Parameters
    public static List<String> parameters(){
        return Arrays.asList("A={1,2,3}/{2,3,4}",
                "B={2,5,6,7}-{2,4}",
                "B1={5,7,0}/0",
                "B2={7,8,9,6}*{8,8}",
                "B3={6,7,8}+{9,0}");
    }

    @Parameter
    public String expression;


    @Test(expected = CalcException.class)
    public void scalarEvaluateTest() throws CalcException {
        p.calc(expression);
    }

}