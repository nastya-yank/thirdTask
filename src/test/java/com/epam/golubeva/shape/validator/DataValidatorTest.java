package com.epam.golubeva.shape.validator;

import org.testng.Assert;
import org.testng.annotations.Test;


public class DataValidatorTest {


    @Test
    public void testIsSphereDataValid() {
        boolean result = DataValidator.isSphereDataValid("{1 2 3 4 5}");
        Assert.assertTrue(result);
    }

    @Test
    public void testIsSphereDataValid2() {
        boolean result = DataValidator.isSphereDataValid("{1 2 a 4 5}");
        Assert.assertFalse(result);
    }

    @Test
    public void testIsSphereDataValid3() {
        boolean result = DataValidator.isSphereDataValid("{1 2 3 4 5");
        Assert.assertFalse(result);
    }
    @Test
    public void testIsSphereDataValid4() {
        boolean result = DataValidator.isSphereDataValid(" 1 2 3 45,");
        Assert.assertFalse(result);
    }
}