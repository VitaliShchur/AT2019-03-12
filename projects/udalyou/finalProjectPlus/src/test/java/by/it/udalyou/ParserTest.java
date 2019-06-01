package by.it.udalyou;
import by.it.udalyou.calculator.Parser;
import by.it.udalyou.calculator.Var;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParserTest {
    public ParserTest() {
    }

    @Test
    public void calcScalarAddTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("2+2");
        double actialValue = Double.parseDouble(actual.toString());
        double expectedValue = 4.0D;
        Assert.assertEquals(expectedValue, actialValue, 1.0E-10D);
    }

    @Test
    public void calcScalarSubTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("8-2");
        double actialValue = Double.parseDouble(actual.toString());
        double expectedValue = 6.0D;
        Assert.assertEquals(expectedValue, actialValue, 1.0E-10D);
    }

    @Test
    public void calcScalarMalTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("4*6");
        double actialValue = Double.parseDouble(actual.toString());
        double expectedValue = 24.0D;
        Assert.assertEquals(expectedValue, actialValue, 1.0E-10D);
    }
    @Test
    public void calcScalarDivTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("32/5");
        double actialValue = Double.parseDouble(actual.toString());
        double expectedValue = 6.4D;
        Assert.assertEquals(expectedValue, actialValue, 1.0E-10D);
    }
}