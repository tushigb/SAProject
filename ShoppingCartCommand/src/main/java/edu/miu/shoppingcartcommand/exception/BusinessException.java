package edu.miu.shoppingcartcommand.exception;


public class BusinessException extends Exception {
    
    public String reason;

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, String reason) {
        super(message);
        this.reason = reason;
    }

}
