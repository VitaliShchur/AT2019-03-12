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
public class VectorSubTest {

    private Parser p;

    @Before
    public void parserInit(){
        p = new Parser();
    }

    @Parameters
    public static List<Object[]> parameters(){
        return Arrays.asList(new Object[][]{
                {"{1,2,3}-{2,3,4}", "{-1.0, -1.0, -1.0}"},
                {"{4,5,6}-{2,6.5,2}", "{2.0, -1.5, 4.0}"},
                {"{1.3,4,6}-{0,-5,7.5}", "{1.3, 9.0, -1.5}"},
                {"{2,4,7.8}-{2,3,4}", "{0.0, 1.0, 3.8}"},
                {"{-5.3,-5,6}-{2,3,4}", "{-7.3, -8.0, 2.0}"},

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