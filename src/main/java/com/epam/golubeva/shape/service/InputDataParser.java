package com.epam.golubeva.shape.service;

import com.epam.golubeva.shape.entity.CustomerPoint;
import com.epam.golubeva.shape.exception.ShapeException;

import java.util.List;

public interface InputDataParser {
    List<CustomerPoint[]> parseList(List<String> data) throws ShapeException;


}
