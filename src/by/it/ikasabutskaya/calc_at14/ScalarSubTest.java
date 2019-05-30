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
public class ScalarSubTest {

    private Parser p;

    @Before
    public void parserInit()
    {
        p = new Parser();
    }

    @Parameters
    public static List<Object[]> parameters(){
        return Arrays.asList(new Object[][]{
                {"A=2-5.3", "-3.3"},
                {"B=A-3.5", "-6.8"},
                {"B1=B-2", "-8.8"},
                {"B2=A-89.5", "-92.8"},
                {"B3=B2-80.2", "-173.0"}
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