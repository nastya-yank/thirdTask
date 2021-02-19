package com.epam.golubeva.shape.observer;

import com.epam.golubeva.shape.entity.Sphere;

import java.util.EventObject;

public class SphereEvent extends EventObject {
    public SphereEvent(Sphere source) {
        super(source);
    }

    @Override
    public Sphere getSource() {
        return (Sphere) super.getSource();
    }
}

