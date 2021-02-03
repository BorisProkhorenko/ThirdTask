package com.epam.task.third.validation;


import java.util.regex.Pattern;

public class InputLineValidator implements Validator<String> {

    private static final String VALID_LINE_PATTERN = "-?\\d+\\.\\d+\\s-?\\d+\\.\\d+\\s-?\\d+\\.\\d+," +
            "\\s-?\\d+\\.\\d++\\s-?\\d+\\.\\d++\\s-?\\d+\\.\\d+,\\s-?\\d+\\.\\d+" +
            "\\s-?\\d+\\.\\d+\\s-?\\d+\\.\\d+,\\s-?\\d+\\.\\d+\\s-?\\d+\\.\\d+\\s-?\\d+\\.\\d+";

    public boolean validate(String line) {
        return Pattern.matches(VALID_LINE_PATTERN, line);
    }
}
