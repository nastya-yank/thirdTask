package com.epam.golubeva.shape.action;

import com.epam.golubeva.shape.entity.CustomerPoint;
import com.epam.golubeva.shape.entity.Sphere;
import com.epam.golubeva.shape.exception.ShapeException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SphereActionTest {
    private Sphere sphere1;

    @BeforeTest
    public void init() {
        CustomerPoint point1 = new CustomerPoint(4, 2, 0);
        CustomerPoint point2 = new CustomerPoint(1, 3, 4);
        sphere1 = new Sphere(point1, point2);
    }

    @Test
    public void testComputeSquare1() throws ShapeException {
        double square = SphereAction.computeSquare(sphere1);
        Assert.assertEquals(square,326.72, 0.01);
    }

    @Test
    public void testComputeSquare2() throws ShapeException {
        double square = SphereAction.computeSquare(sphere1);
        Assert.assertNotEquals(square, 178.72, 0.01);
    }

    @Test(expectedExceptions = ShapeException.class)
    public void testComputeSquare3() throws ShapeException {
        double square = SphereAction.computeSquare(null);
    }

    @Test
    public void testComputeVolume1() throws ShapeException {
        double volume = SphereAction.computeVolume(sphere1);
          Assert.assertEquals(volume, 555.32, 0.01);
    }

    @Test
    public void testComputeVolume2() throws ShapeException {
        double volume = SphereAction.computeVolume(sphere1);
        Assert.assertNotEquals(volume, 84, 0.01);
    }
    @Test(expectedExceptions = ShapeException.class)
    public void testComputeVolume3() throws ShapeException {
        double volume = SphereAction.computeVolume(null);
    }
    @Test
    public void testVolumeRatioByXY1() throws ShapeException {
        double ratio = SphereAction.volumeRatioByXY(sphere1);
        Assert.assertEquals(ratio, 1, 0.01);
    }
    @Test
    public void testVolumeRatioByXY2() throws ShapeException {
        double ratio = SphereAction.volumeRatioByXY(sphere1);
        Assert.assertNotEquals(ratio, 4, 0.01);
    }
    @Test(expectedExceptions = ShapeException.class)
    public void testVolumeRatioByXY3() throws ShapeException {
        double ratio = SphereAction.volumeRatioByXY(null);
    }
}