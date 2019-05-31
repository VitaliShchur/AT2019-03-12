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
public class ScalarExceptionTest {

    private Parser p;

    @Before
    public void parserInit()
    {
        p = new Parser();
    }

    @Parameters
    public static List<String> parameters(){
        List<String> strings = Arrays.asList(new String[]{
                "A=2/0",
                "B=A*3",
                "B1=0/0",
                "B2=jjj",
                "B3=B2*0"
        });
        return strings;
    }

    @Parameter
    public String expression;


    @Test(expected = CalcException.class)
    public void scalarEvaluateTest() throws CalcException {
        p.calc(expression);
    }

}