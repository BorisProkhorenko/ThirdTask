package com.epam.task.third.logic;

public class CalculationException extends Exception {

    public CalculationException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalculationException(String message) {
        super(message);
    }
}

