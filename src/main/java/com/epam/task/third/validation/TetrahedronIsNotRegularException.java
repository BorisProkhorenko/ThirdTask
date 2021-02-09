package com.epam.task.third.validation;

public class TetrahedronIsNotRegularException extends Exception{

    public TetrahedronIsNotRegularException(String message, Throwable cause) {
        super(message, cause);
    }

    public TetrahedronIsNotRegularException(String message) {
        super(message);
    }
}
