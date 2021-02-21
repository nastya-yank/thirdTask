package com.epam.golubeva.shape.repository.impl;

import com.epam.golubeva.shape.action.SphereAction;
import com.epam.golubeva.shape.entity.CustomerShape;
import com.epam.golubeva.shape.entity.Sphere;
import com.epam.golubeva.shape.exception.ShapeException;
import com.epam.golubeva.shape.repository.Specification;

public class VolumeIntervalSpecification implements Specification {
    private double minVolume;
    private double maxVolume;

    public VolumeIntervalSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specify(CustomerShape shape) {
        boolean result;
        try {
            double volume = new SphereAction().computeVolume((Sphere) shape);
            result = volume >= minVolume && volume <= maxVolume;
        } catch (ShapeException e){
            result = false;
        }
        return result;
    }
}
