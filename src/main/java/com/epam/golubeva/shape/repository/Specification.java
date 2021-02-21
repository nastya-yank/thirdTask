package com.epam.golubeva.shape.repository;

import com.epam.golubeva.shape.entity.CustomerShape;
import com.epam.golubeva.shape.exception.ShapeException;

public interface Specification {
        boolean specify(CustomerShape shape) ;
}
