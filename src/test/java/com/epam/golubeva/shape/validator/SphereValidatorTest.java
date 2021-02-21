package com.epam.golubeva.shape.validator;

import com.epam.golubeva.shape.entity.CustomerPoint;
import com.epam.golubeva.shape.entity.Sphere;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SphereValidatorTest {

    private Sphere sphere1;

    private Sphere sphere2;

    @BeforeTest
    public void init() {
        CustomerPoint point1 = new CustomerPoint(5, 5, 5);
        CustomerPoint point2 = new CustomerPoint(0, 5, 5);
        sphere1 = new Sphere(point1, point2);
        point1 = new CustomerPoint(1,2,3);
        point2 = new CustomerPoint(1,2,3);
        sphere2 = new Sphere(point1,point2);
    }

    @Test
    public void testIsSphere1() {
        boolean result = SphereValidator.isSphere(sphere1);
        Assert.assertTrue(result);

    }

    @Test
    public void testIsSphere2() {
        boolean result = SphereValidator.isSphere(sphere2);
        Assert.assertFalse(result);
    }

    @Test
    public void testIsTouchUpon1() {
        boolean result = SphereValidator.isTouchUpon(sphere1);
        Assert.assertTrue(result);
    }

    @Test
    public void testIsTouchUpon2() {
        boolean result = SphereValidator.isTouchUpon(sphere2);
        Assert.assertFalse(result);
    }


}