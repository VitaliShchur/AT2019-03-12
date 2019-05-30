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
public class VectorMulTest {

    private Parser p;

    @Before
    public void parserInit(){
        p = new Parser();
    }

    @Parameters
    public static List<Object[]> parameters(){
        return Arrays.asList(new Object[][]{
                {"{1,2,3}*{2,3,4}", "20.0"},
                {"{4,5,6}*{2.3,6.7,2}", "54.7"},
                {"{1.3,4,6}*{0,-5,7}", "22.0"},
                {"{2,4,7.8}*{2,3,4}", "47.2"},
                {"{-5,-5,6}*{2,3,4}", "-1.0"},

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