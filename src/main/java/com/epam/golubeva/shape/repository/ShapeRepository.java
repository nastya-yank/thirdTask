package com.epam.golubeva.shape.repository;

import com.epam.golubeva.shape.entity.CustomerShape;
import com.epam.golubeva.shape.exception.ShapeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShapeRepository {
    public static Logger logger = LogManager.getLogger();
    private final static ShapeRepository repository = new ShapeRepository();
    private List<CustomerShape> shapes = new ArrayList<>();

    public ShapeRepository(){

    }
    public static ShapeRepository getShapeRepository () {
        return repository;
    }

    public boolean addShape(CustomerShape shape) throws ShapeException {
        if (shape == null) {
            throw new ShapeException("shape repository cannot store null");
        }
        return shapes.add(shape);
    }

    public boolean removeShape(CustomerShape shape) {
        return this.shapes.remove(shape);
    }

    public CustomerShape setShape(int index, CustomerShape shape) throws ShapeException {
        if (shape == null) {
            throw new ShapeException("shape repository cannot store null");
        }
        return shapes.set(index, shape);
    }

    public CustomerShape getShape(int index) {
        return shapes.get(index);
    }

    public List<CustomerShape> query(Specification specification) {
        List<CustomerShape> requestShapes = new ArrayList<>();
        for (CustomerShape shape : shapes) {
            if (specification.specify(shape)) {
                requestShapes.add(shape);
            }
        }
        logger.log(Level.INFO, "requested shapes: " + requestShapes.toString());
        return requestShapes;
    }

    public List<CustomerShape> sort(Comparator<CustomerShape> comparator) {
        shapes.sort(comparator);
        logger.log(Level.INFO, "sorted shapes: " + shapes.toString());
        return shapes;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ShapeRepository [shapes=");
        builder.append(shapes);
        builder.append("]");
        return builder.toString();
    }
}
