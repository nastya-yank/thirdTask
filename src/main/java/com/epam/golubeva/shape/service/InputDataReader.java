package com.epam.golubeva.shape.service;

import com.epam.golubeva.shape.exception.NotLineException;
import com.epam.golubeva.shape.exception.ShapeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class InputDataReader {
    private final String patternString="\\{[\\d, ]+\\}";
    private final Logger LOGGER = LogManager.getLogger(InputDataReader.class);
    public List<Integer> read(String url) {
        List<Integer> result=new ArrayList<>();
        Path path = Paths.get(url);
        try {
            LOGGER.log(Level.INFO,"Read from file");
            Stream<String> lines = Files.lines(path);

            Optional<String> first = lines
                    .filter(e -> e.matches(patternString))
                    .findFirst();
            String lineFromFile = first.orElseThrow(() ->new NotLineException("File has not line"));
            result = Parser.parsToList(lineFromFile, patternString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
