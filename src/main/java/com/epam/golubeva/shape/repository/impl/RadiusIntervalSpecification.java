package com.epam.golubeva.shape.repository.impl;

import com.epam.golubeva.shape.entity.CustomerShape;
import com.epam.golubeva.shape.entity.Sphere;
import com.epam.golubeva.shape.exception.ShapeException;
import com.epam.golubeva.shape.repository.Specification;

public class RadiusIntervalSpecification implements Specification {
    private double minRadius;
    private double maxRadius;

    public RadiusIntervalSpecification(double minRadius, double maxRadius) {
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
    }

    @Override
    public boolean specify(CustomerShape shape)  {
        if (shape == null || shape.getClass() != Sphere.class) {
            return false;
        }
        Sphere sphere = (Sphere) shape;
        double radius = sphere.getRadius();
        boolean result = radius >= minRadius && radius <= maxRadius;
        return result;
    }
}
