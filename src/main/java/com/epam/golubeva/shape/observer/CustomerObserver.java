package com.epam.golubeva.shape.observer;


import com.epam.golubeva.shape.exception.ShapeException;

public interface CustomerObserver {
    void parameterChanged (SphereEvent event) throws ShapeException;
}
