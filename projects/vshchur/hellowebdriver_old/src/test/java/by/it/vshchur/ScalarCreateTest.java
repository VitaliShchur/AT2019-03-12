package by.it.vshchur;

import org.junit.Assert;
import org.junit.Test;

public class ScalarCreateTest {


    @Test()
    public void checkVarCreate() throws Exception{
        Var var= Var.createVar("123");
        Assert.assertEquals("123.0",var.toString());
    }
}
