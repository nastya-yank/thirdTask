package com.epam.golubeva.shape.repository.impl;

import com.epam.golubeva.shape.action.SphereAction;
import com.epam.golubeva.shape.entity.CustomerShape;
import com.epam.golubeva.shape.entity.Sphere;
import com.epam.golubeva.shape.exception.ShapeException;
import com.epam.golubeva.shape.repository.Specification;

public class SquareIntervalSpecification implements Specification {
    private double squareMin;
    private double squareMax;

    public SquareIntervalSpecification(double squareMin, double squareMax) {
        this.squareMin = squareMin;
        this.squareMax = squareMax;
    }

    @Override
    public boolean specify(CustomerShape shape) {
        boolean result;
        try {
            double square = new SphereAction().computeSquare((Sphere) shape);
            result = square >= squareMin && square <= squareMax;
        } catch (ShapeException e){
            result = false;
        }
        return result;
    }
}
