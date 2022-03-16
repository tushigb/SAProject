package edu.miu.order.constant;

/**
 * ExceptionType
 *
 * @author Tushig Battumur
 **/

public enum OrderStatus {

    PENDING("pending"),

    SUCCESS("success"),

    FAILED("failed");

    private final String value;

    OrderStatus(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

}
