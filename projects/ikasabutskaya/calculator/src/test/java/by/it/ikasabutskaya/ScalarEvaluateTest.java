package by.it.ikasabutskaya;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(value = Parameterized.class)
public class ScalarEvaluateTest {

    private Parser p;

    @Before
    public void parserInit()
    {
        p = new Parser();
    }

    @Parameters
    public static List<Object[]> parameters(){
        return Arrays.asList(new Object[][]{
            {"A=2+5.3", "7.3"},
            {"B=A*3.5", "25.55"},
            {"B1=B+0.11*-5", "25.0"},
            {"B2=A/2-1", "2.65"},
            {"B3=B2+4/2", "4.65"}
        });
    }

    @Parameter
    public String expression;

    @Parameter(1)
    public String result;

    @Test
    public void scalarEvaluateTest() throws CalcException {
        assertThat(p.calc(expression).toString(), is(result));
    }

}