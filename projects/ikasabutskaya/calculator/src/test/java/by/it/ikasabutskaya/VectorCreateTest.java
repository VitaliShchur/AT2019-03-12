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
public class VectorCreateTest {

    private Parser p;

    @Before
    public void parserInit(){
        p = new Parser();
    }

    @Parameters
    public static List<Object[]> parameters(){
        return Arrays.asList(new Object[][]{
                {"A={1,2,3}", "{1.0, 2.0, 3.0}"},
                {"B=A", "{1.0, 2.0, 3.0}"},
                {"C={1.3,4,6}", "{1.3, 4.0, 6.0}"},
                {"B2={-3,5.0,0,5.5,-8}", "{-3.0, 5.0, 0.0, 5.5, -8.0}"},
                {"B3={   5,    5,5,-6}", "{5.0, 5.0, 5.0, -6.0}"},

         });
    }

    @Parameter
    public String expression;

    @Parameter(1)
    public String expected;


    @Test
    public void main() throws CalcException {
        assertThat(p.calc(expression).toString(), is(expected));
    }
}