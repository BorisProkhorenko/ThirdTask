package com.epam.task.third.validation;

import java.util.regex.Pattern;

public class InputLineValidator {

    private static final String VALID_LINE_PATTERN = "(((-?\\d+\\.\\d+\\s?){3}), ){3}(-?\\d+\\.\\d+\\s?){3}";

    public boolean validate(String line) {
        return Pattern.matches(VALID_LINE_PATTERN, line);
    }

}
