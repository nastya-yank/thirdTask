package com.epam.golubeva.shape.generator;

public class GeneratorId {
    private static long idCounter;

    private GeneratorId() {
    }

    public static long generateId() {
        return ++idCounter;
    }
}
