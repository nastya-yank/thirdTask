package com.epam.golubeva.shape.factory;

import com.epam.golubeva.shape.entity.CustomerPoint;
import com.epam.golubeva.shape.entity.CustomerShape;
import com.epam.golubeva.shape.entity.Sphere;
import com.epam.golubeva.shape.exception.ShapeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereFactory extends ShapeFactory{
    public static Logger logger = LogManager.getLogger();

    @Override
    public  CustomerShape createShape(CustomerPoint center, CustomerPoint boundary, double radius) throws ShapeException {
        if (center == null || radius == 0) {
            logger.error("invalid arguments {} {} {}", center, boundary, radius);
            throw new ShapeException("invalid arguments: " + center + " " + boundary + " " + radius);
        }
        return new Sphere(center, boundary, radius);
    }
}
