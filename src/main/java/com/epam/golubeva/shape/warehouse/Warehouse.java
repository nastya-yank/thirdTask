package com.epam.golubeva.shape.warehouse;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    public static Logger logger = LogManager.getLogger();
    private  static Warehouse warehouse;
    private Map<Long, ShapeValue> shapesValues = new HashMap<>();
    private Warehouse(){

    }
    public static Warehouse getWarehouse() {
        if (warehouse == null) {
            warehouse = new Warehouse();
        }
        return warehouse;
    }
    public ShapeValue addShapeValue(Long shapeId, ShapeValue shapeValue) {
        logger.log(Level.INFO, "shapeId " + shapeId + " " + shapeValue + " added/changed in warehouse");
        return shapesValues.put(shapeId, shapeValue);
    }

    public ShapeValue removeShapeValue(Long shapeId) {
        return shapesValues.remove(shapeId);
    }

    public ShapeValue getShapeValue(Long shapeId) {
        return shapesValues.get(shapeId);
    }
}
