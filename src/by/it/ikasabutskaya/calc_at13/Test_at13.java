package by.it.ikasabutskaya.calc_at13;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test_at13 {

    @Test
    public void calcA() throws Exception {
        Parser parser = new Parser();
        String actual, expected;
        actual = parser.calc("A=2+5.3").toString();
        expected = "7.3";
        assertEquals("Incorrect calc_at14 A", expected, actual);
        actual = parser.calc("B=A*3.5").toString();
        expected = "25.55";
        assertEquals("Incorrect calc_at14 B", expected, actual);
        actual = parser.calc("B1=B+0.11*-5").toString();
        expected = "25.0";
        assertEquals("Incorrect calc_at14 B1", expected, actual);
        actual = parser.calc("B2=A/2-1").toString();
        expected = "2.65";
        assertEquals("Incorrect calc_at14 B2", expected, actual);
    }

    @Test
    public void calcB() throws Exception {
        Parser parser = new Parser();
        String actual, expected;
        actual = parser.calc(parser.excludeBracers("C=B+(A*2)")).toString();
        expected = "40.15";
        assertEquals("Incorrect calc_at14 C", expected, actual);
        actual = parser.calc(parser.excludeBracers("D=((C-0.15)-20)/(7-5)")).toString();
        expected = "10.0";
        assertEquals("Incorrect calc_at14 D", expected, actual);
        actual = parser.calc(parser.excludeBracers("E={2,3}*(D/2)")).toString();
        expected = "{10.0, 15.0}";
        assertEquals("Incorrect calc_at14 E", expected, actual);
    }

    @Test
    public void calcSumScalar() throws CalcException {
        Parser parser = new Parser();
        String expression = "A = 4.6+8.9", control = "13.5";

        Assert.assertEquals(parser.calc(expression).toString(),control);
    }

    @Test
    public void calcSubScalar() throws CalcException {
        Parser parser = new Parser();
        String expression = "A = 12.6-17.0", control = "-4.4";

        Assert.assertEquals(parser.calc(expression).toString(),control);
    }

    @Test
    public void calcMulScalar() throws CalcException {
        Parser parser = new Parser();
        String expression = "A = 88.3*6.3", control = "556.29";

        Assert.assertEquals(parser.calc(expression).toString(),control);
    }

    @Test
    public void calcDivScalar() throws CalcException {
        Parser parser = new Parser();
        String expression = "A = 26.8/-2", control = "-13.4";

        Assert.assertEquals(parser.calc(expression).toString(),control);
    }

    @Test
    public void calcAddVector() throws CalcException {
        Parser parser = new Parser();
        String expression = "A = {5,-4,0}+{6,8,-4}", control = "{11.0, 4.0, -4.0}";

        Assert.assertEquals(parser.calc(expression).toString(),control);
    }

    @Test
    public void calcSubVector() throws CalcException {
        Parser parser = new Parser();
        String expression = "A = {5,-4,0}-{6,8,-4}", control = "{-1.0, -12.0, 4.0}";

        Assert.assertEquals(parser.calc(expression).toString(),control);
    }

    @Test
    public void calcMulVector() throws CalcException {
        Parser parser = new Parser();
        String expression = "A = {5,-4,0}*{6,8,-4}", control = "-2.0";

        Assert.assertEquals(parser.calc(expression).toString(),control);
    }

    @Test
    public void calcErrorDivVector(){
        try {
            Parser parser = new Parser();
            String expression = "A = {5,-4,0}/{6,8,-4}";
            String result = parser.calc(expression).toString();
            System.out.println(result);
        }
        catch (CalcException e){
            Assert.assertTrue(e.getMessage().contains("ERROR"));
        }

    }

    @Test
    public void calcSumMatrix() throws CalcException {
        Parser parser = new Parser();
        String expression = "A = {{1,2.0,3},{4,5,6},{7, 8,9}}+{{1,2.8,3},{4,0,6},{7,8,-9}}", control = "{{2.0, 4.8, 6.0}, {8.0, 5.0, 12.0}, {14.0, 16.0, 0.0}}";

        Assert.assertEquals(parser.calc(expression).toString(),control);

    }
    @Test
    public void calcSubMatrix() throws CalcException {
        Parser parser = new Parser();
        String expression = "A = {{1,2.0,3},{4,5,6},{7,8,9}}-{{7,-72,34},{60,5,9},{7,8,9}}", control = "{{-6.0, 74.0, -31.0}, {-56.0, 0.0, -3.0}, {0.0, 0.0, 0.0}}";

        Assert.assertEquals(parser.calc(expression).toString(),control);

    }
    @Test
    public void calcMulMatrix() throws CalcException {
        Parser parser = new Parser();
        String expression = "A = {{1,2.0,3},{4,5,6}}*{{7,-72},{60,5},{7,8}}", control = "{{148.0, -38.0}, {370.0, -215.0}}";

        Assert.assertEquals(parser.calc(expression).toString(),control);

    }
    @Test
    public void calcErrorDivMatrix() {
        try {
        Parser parser = new Parser();
        String expression = "A = {{1,2.0,3},{4,5,6}}/{{7,-72},{60,5},{7,8}}";
        parser.calc(expression);
        }
        catch (CalcException e){
            Assert.assertTrue(e.getMessage().contains("ERROR"));
        }

    }

}