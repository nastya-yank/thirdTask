package com.epam.golubeva.shape.service.impl;

import com.epam.golubeva.shape.entity.CustomerPoint;
import com.epam.golubeva.shape.exception.ShapeException;
import com.epam.golubeva.shape.service.InputDataParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputDataParserImpl implements InputDataParser {
    public static Logger logger = LogManager.getLogger();
    public final static String NUMBER_SPLIT = " ";

    @Override
    public List<CustomerPoint[]> parseList(List<String> data) throws ShapeException {
        if (data == null || data.isEmpty()) {
            logger.error("invalid argument {}", data);
            throw new ShapeException("argument is null or empty");
        }
        List<CustomerPoint[]> sphereData = new ArrayList<>();
        CustomerPoint[] points;
        for (String Data : data) {
            try {
                points = parseLine(Data);
                sphereData.add(points);
            } catch (ShapeException e) {
                logger.log(Level.ERROR, Data + " is not suitable for creating a sphere");
            }
        }
        if (sphereData.isEmpty()) {
            throw new ShapeException("no data to create a sphere");
        }
        return sphereData;
    }


    private CustomerPoint[] parseLine(String data) throws ShapeException {
        CustomerPoint customerPoints[] = new CustomerPoint[3];
        Double[] points = (Double[]) Arrays
                .stream(data.split(" "))
                .map(Double::parseDouble)
                .toArray();
        customerPoints[0] = new CustomerPoint(points[0], points[1], points[2]);
        customerPoints[2] = new CustomerPoint(points[3], points[4], points[5]);
        return customerPoints;
    }
}
