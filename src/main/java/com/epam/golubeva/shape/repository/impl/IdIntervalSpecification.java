package com.epam.golubeva.shape.repository.impl;

import com.epam.golubeva.shape.entity.CustomerShape;
import com.epam.golubeva.shape.exception.ShapeException;
import com.epam.golubeva.shape.repository.Specification;

public class IdIntervalSpecification implements Specification {
    private double shapeIdMin;
    private double shapeIdMax;

    public IdIntervalSpecification(double shapeIdMin, double shapeIdMax) {
        this.shapeIdMin = shapeIdMin;
        this.shapeIdMax = shapeIdMax;
    }

    @Override
    public boolean specify(CustomerShape shape) {
        boolean result = shape.getShapeId() >= shapeIdMin && shape.getShapeId() <= shapeIdMax;
        return result;
    }
}
