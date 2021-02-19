package com.epam.golubeva.shape.observer;


import com.epam.golubeva.shape.action.SphereAction;
import com.epam.golubeva.shape.entity.Sphere;
import com.epam.golubeva.shape.exception.ShapeException;
import com.epam.golubeva.shape.warehouse.ShapeValue;
import com.epam.golubeva.shape.warehouse.Warehouse;

public class SphereObserver implements CustomerObserver {
    @Override
    public void parameterChanged(SphereEvent event) throws ShapeException {
        if (event == null) {
            throw new ShapeException("argument is null");
        }
        Sphere sphere = event.getSource();
        SphereAction action = new SphereAction();
        double square = action.computeSquare(sphere);
        double volume = action.computeVolume(sphere);
        ShapeValue shapeValue = new ShapeValue(square,volume);
        Warehouse warehouse = Warehouse.getWarehouse();
        warehouse.addShapeValue(sphere.getShapeId(), shapeValue);
    }
}
