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
        if (shape == null ) {
            throw new ShapeException("Incompatible shape");
        }
        Sphere sphere = (Sphere) shape;
        double radius = getRadius(sphere);
        double square = 4*Math.PI*radius*radius;
        logger.log(Level.INFO, "square sphere " + sphere.toString() + " :" + square);
        return square;
    }

    public static double computeVolume(CustomerShape shape) throws ShapeException {
        if (shape == null) {
            throw new ShapeException("Incompatible shape");
        }
        Sphere sphere = (Sphere) shape;
        double radius = getRadius(sphere);
        double volume = (4.0 / 3) * Math.PI * radius * radius *radius;
        logger.log(Level.INFO, "volume sphere " + shape.toString() + " :" + volume);
        return volume;
    }
    public static double volumeRatioByXY(Sphere sphere) throws ShapeException{
        if (sphere == null) {
            throw new ShapeException("Incompatible shape");
        }
        CustomerPoint center = sphere.getCenter();
        double radius = getRadius(sphere);
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
    public static double getRadius(Sphere sphere){
        double x1 = sphere.getCenter().getX();
        double y1 = sphere.getCenter().getY();
        double z1 = sphere.getCenter().getZ();
        double x2 = sphere.getBoundary().getX();
        double y2 = sphere.getBoundary().getY();
        double z2 = sphere.getBoundary().getZ();
        double result = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2)+Math.pow(z2-z1,2));
        return result;
    }

}
