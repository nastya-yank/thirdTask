package com.epam.golubeva.shape.validator;

public class DataValidator {
    private static final String STRING_DOUBLE_REGEX = "\\{[\\d ]+\\}";
    public static boolean isSphereDataValid(String data) {
        return data.matches(STRING_DOUBLE_REGEX);
    }
}
