package com.epam.golubeva.shape.repository.impl;

import com.epam.golubeva.shape.entity.CustomerShape;
import com.epam.golubeva.shape.entity.Sphere;
import com.epam.golubeva.shape.repository.Specification;
import com.epam.golubeva.shape.validator.SphereValidator;

public class IsTouchSpecification implements Specification {
    @Override
    public boolean specify(CustomerShape shape) {
        SphereValidator sphereValidator = new SphereValidator();
        boolean result = sphereValidator.isTouchUpon((Sphere) shape);
        return result;
    }
}
