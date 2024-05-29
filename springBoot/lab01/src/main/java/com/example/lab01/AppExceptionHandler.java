package com.example.lab01;

import com.example.lab01.common.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ErrorResponse<Map<String, List<String>>>> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, List<String>> errors = new HashMap<String, List<String>>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error -> {
                    if (errors.containsKey(error.getField())) {
                        errors.get(error.getField()).add(error.getDefaultMessage());
                    } else {
                        errors.put(error.getField(), new ArrayList<String>() {{
                            add(error.getDefaultMessage());
                        }});
                    }
                });
        ErrorResponse<Map<String, List<String>>> error = new ErrorResponse<Map<String, List<String>>>("Validation Failed", errors);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse<Map<String, String>>> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
        Map<String, String> errors = new HashMap<String, String>();
        errors.put(ex.getName(), "Not a valid " + ex.getName());
        ErrorResponse<Map<String, String>> error = new ErrorResponse<Map<String, String>>("Validation Failed", errors);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public final ResponseEntity<ErrorResponse<Map<String, String>>> handleNoResourceFoundException(NoResourceFoundException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<String, String>();
        errors.put("message", "Resource not found");
        ErrorResponse<Map<String, String>> error = new ErrorResponse<Map<String, String>>(HttpStatus.NOT_FOUND.name(), errors);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse<Map<String, String>>> handleValidationExceptions(Exception ex, WebRequest request) {
        System.out.println("error:" + ex.toString());
        Map<String, String> errors = new HashMap<String, String>();
        errors.put("message", "An unexpected error occurred");
        ErrorResponse<Map<String, String>> error = new ErrorResponse<Map<String, String>>(HttpStatus.INTERNAL_SERVER_ERROR.name(), errors);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
