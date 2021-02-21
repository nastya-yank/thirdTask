package com.epam.golubeva.shape.factory;

import com.epam.golubeva.shape.entity.CustomerPoint;
import com.epam.golubeva.shape.entity.CustomerShape;
import com.epam.golubeva.shape.exception.ShapeException;

public abstract class ShapeFactory {
    public abstract CustomerShape createShape (CustomerPoint center, CustomerPoint boundary) throws ShapeException;
}
