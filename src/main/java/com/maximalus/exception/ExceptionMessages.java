package com.maximalus.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessages {
    public static final String INVALID_REQUEST_PARAM = "Invalid request parameter value";
    public static final String NOT_UNIQUE_VALUE = "The value is not unique";


    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Authentication {
        public static final String BAD_CREDENTIALS = "You've entered invalid Employee number or Password";
        public static final String ACCESS_DENIED = "You don't have permission to perform this action";
    }

    @RequiredArgsConstructor
    @Getter
    public enum ConstraintMessages {
        DEFAULT("NOT_DEFINED_CONSTRAINT", BAD_REQUEST, NOT_UNIQUE_VALUE);

        private final String constraint;
        private final HttpStatus status;
        private final String message;

        public static ConstraintMessages findByConstraintMessage(String constraintName) {
            return Arrays
                    .stream(ConstraintMessages.values())
                    .filter(cm -> constraintName.contains(cm.getConstraint()))
                    .findFirst()
                    .orElse(ConstraintMessages.DEFAULT);
        }
    }
}
