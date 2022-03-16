package edu.miu.product.constant;

/**
 * ExceptionType
 *
 * @author Tushig Battumur
 **/

public enum ExceptionType {

    VALIDATION("validation"),

    NOT_FOUND("not found"),

    BUSINESS("business"),

    RUN_TIME("run time"),

    FATAL("fatal");

    private final String value;

    ExceptionType(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

}
