package by.it.ikasabutskaya.calc_at14;

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
public class ScalarCreateTest {

    private Parser p;

    @Before
    public void parserInit()
    {
        p = new Parser();
    }

    @Parameters
    public static List<Object[]> parameters(){
        return Arrays.asList(new Object[][]{
                {"A=2", "2.0"},
                {"B=-3.5", "-3.5"},
                {"B1=45.8", "45.8"},
                {"B2=B", "-3.5"},
                {"B3=B1", "45.8"}
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