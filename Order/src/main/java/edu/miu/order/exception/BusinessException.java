package edu.miu.order.exception;

import java.util.HashMap;

public class BusinessException extends Exception {

    public String reason;

    public HashMap<String, String> reasons;

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, HashMap<String, String> reasons) {
        super(message);
        this.reasons = reasons;
    }

    public BusinessException(String message, String reason) {
        super(message);
        this.reason = reason;
    }

}
