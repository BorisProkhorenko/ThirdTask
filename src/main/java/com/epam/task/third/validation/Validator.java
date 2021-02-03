package com.epam.task.third.validation;

public interface Validator<T> {
    
    boolean validate(T data);
}
