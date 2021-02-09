package com.epam.task.third.validation;


import java.util.Objects;
import java.util.regex.Pattern;

public class InputLineValidator implements Validator {

    private static final String VALID_LINE_PATTERN = "-?\\d+\\.\\d+\\s-?\\d+\\.\\d+\\s-?\\d+\\.\\d+," +
            "\\s-?\\d+\\.\\d++\\s-?\\d+\\.\\d++\\s-?\\d+\\.\\d+,\\s-?\\d+\\.\\d+" +
            "\\s-?\\d+\\.\\d+\\s-?\\d+\\.\\d+,\\s-?\\d+\\.\\d+\\s-?\\d+\\.\\d+\\s-?\\d+\\.\\d+";

    private String line;

    public InputLineValidator(String line) {
        this.line = line;
    }

    public boolean validate() {
        return Pattern.matches(VALID_LINE_PATTERN, line);
    }

    public static String getValidLinePattern() {
        return VALID_LINE_PATTERN;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InputLineValidator validator = (InputLineValidator) o;
        return Objects.equals(line, validator.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }

    @Override
    public String toString() {
        return "InputLineValidator{" +
                "line='" + line + '\'' +
                '}';
    }
}
