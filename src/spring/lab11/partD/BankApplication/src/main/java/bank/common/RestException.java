package bank.common;

import org.springframework.http.HttpStatus;

public class RestException extends Exception{
    private final String message;
    private final HttpStatus statusCode;

    public RestException(String message, HttpStatus statusCode){
        this.message = message;
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}
