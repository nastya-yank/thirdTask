package com.epam.golubeva.shape.factory;

import com.epam.golubeva.shape.action.SphereAction;
import com.epam.golubeva.shape.entity.CustomerPoint;
import com.epam.golubeva.shape.entity.CustomerShape;
import com.epam.golubeva.shape.entity.Sphere;
import com.epam.golubeva.shape.exception.ShapeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereFactory extends ShapeFactory{
    public static Logger logger = LogManager.getLogger();

    @Override
    public  CustomerShape createShape(CustomerPoint center, CustomerPoint boundary) throws ShapeException {
        if (center == null || boundary == null) {
            logger.error("invalid arguments {} {} {}", center, boundary);
            throw new ShapeException("invalid arguments: " + center + " " + boundary);
        }
        return new Sphere(center, boundary);
    }
}
