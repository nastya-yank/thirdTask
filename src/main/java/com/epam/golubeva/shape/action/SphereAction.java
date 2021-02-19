package com.epam.golubeva.shape.action;

import com.epam.golubeva.shape.entity.CustomerPoint;
import com.epam.golubeva.shape.entity.CustomerShape;
import com.epam.golubeva.shape.entity.Sphere;
import com.epam.golubeva.shape.exception.ShapeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereAction {
    public static Logger logger = LogManager.getLogger();

    public static double computeSquare(CustomerShape shape) throws ShapeException {
        if (shape == null || shape.getClass() != Sphere.class) {
            throw new ShapeException("Incompatible shape");
        }
        Sphere sphere = (Sphere) shape;
        double radius = sphere.getRadius();
        double square = 4*Math.PI*radius*radius;
        logger.log(Level.INFO, "square sphere " + sphere.toString() + " :" + square);
        return square;
    }

    public static double computeVolume(CustomerShape shape) throws ShapeException {
        if (shape == null || shape.getClass() != Sphere.class) {
            throw new ShapeException("Incompatible shape");
        }
        Sphere sphere = (Sphere) shape;
        double radius = sphere.getRadius();
        double volume = (4.0 / 3) * Math.PI * radius * radius *radius;
        logger.log(Level.INFO, "volume sphere " + shape.toString() + " :" + volume);
        return volume;
    }
    public static double volumeRatioByXY(CustomerShape shape) throws ShapeException{
        if (shape == null || shape.getClass() != Sphere.class) {
            throw new ShapeException("Incompatible shape");
        }
        Sphere sphere = (Sphere) shape;
        CustomerPoint center = sphere.getCenter();
        double radius = sphere.getRadius();
        double z = center.getZ();
        if(z >= 0 && z - radius >= 0 || z <= 0 && z + radius <= 0) {
            throw  new ShapeException("sphere : " + sphere + "does not dissection by XY");
        }
        double heightSphereSegment = radius - Math.abs(z);
        double heightRestSphereSegment = radius + Math.abs(z);
        double volumeSphereSegment = Math.PI * Math.pow(heightSphereSegment, 2) * (3 * radius - heightSphereSegment) / 3;
        double volumeRestSphereSegment = Math.PI * Math.pow(heightRestSphereSegment, 2)
                * (3 * radius - heightRestSphereSegment) / 3;
        return volumeSphereSegment / volumeRestSphereSegment;
    }
    public static boolean isSphere(CustomerShape shape) throws ShapeException {
        boolean result=false;
        if (shape == null || shape.getClass() != Sphere.class) {
            throw new ShapeException("Incompatible shape");
        }
        Sphere sphere = (Sphere) shape;
        CustomerPoint center = sphere.getCenter();
        double radius = sphere.getRadius();
        double x = center.getX();
        double y = center.getY();
        double z = center.getZ();
        if (x >= 0 && x - radius < 0 || y >= 0 && y - radius < 0 || z >= 0 && z - radius < 0 ) {
            result = true;
        }
        if (x <= 0 && x + radius > 0 || y <= 0 && y + radius > 0 || z <= 0 && z + radius > 0 ) {
            result = true;
        }
        return result;
    }
    public static boolean isTouchUpon(CustomerShape shape) throws ShapeException {
        boolean result = false;
        if (shape == null || shape.getClass() != Sphere.class) {
            throw new ShapeException("Incompatible shape");
        }
        Sphere sphere = (Sphere) shape;
        CustomerPoint center = sphere.getCenter();
        double radius = sphere.getRadius();
        double x = center.getX();
        double y = center.getY();
        double z = center.getZ();
        if (x + radius == 0 || x - radius == 0 ||
                y + radius == 0 || y - radius == 0 ||
                z + radius == 0	|| z - radius == 0) {
            result = true;
        }
        return result;
    }
}
