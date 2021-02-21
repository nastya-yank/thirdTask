package com.epam.golubeva.shape.reader;

import com.epam.golubeva.shape.exception.ShapeException;

import java.util.List;

public interface CommonReader {
    List<String> readAll(String filePath) throws ShapeException;
}
