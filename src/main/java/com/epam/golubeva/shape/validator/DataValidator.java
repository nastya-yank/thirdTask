package com.epam.golubeva.shape.validator;

public class DataValidator {
    private static final String STRING_DOUBLE_REGEX = "(?<CENTER>([+-]?)(\\d+)(\\.{1})(\\d+)(\\s*)){3}"
            + "(?<BOUNDARY>([+-]?)(\\d+)(\\.{1})(\\d+)(\\s*)){3}"
            + "(?<RADIUS>([+]?)(\\d+)(\\.{1})(\\d+)(\\s*)){1}";
    public static boolean isSphereDataValid(String data) {
        return data.matches(STRING_DOUBLE_REGEX);
    }
}
