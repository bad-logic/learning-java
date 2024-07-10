package bank;

import bank.common.RestException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
        Map<String, String> errors = new HashMap<String, String>();
        errors.put(ex.getName(), "Not a valid " + ex.getName());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @Override
    public final ResponseEntity<Object> handleNoResourceFoundException(NoResourceFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> errors = new HashMap<String, String>();
        errors.put("message", "Resource not found");
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @Override
    public final ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> errors = new HashMap<String, String>();
        errors.put("message", "Resource not found");
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }


    @Override
    public final ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        errors.put("message", "unable to parse the request, check the request header or body");
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @Override
    public final ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> errors = new HashMap<String, String>();
        errors.put("message",ex.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


    @Override
    public final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
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
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RestException.class)
    public final ResponseEntity<Object> handleOperationalExceptions(RestException exception) {
        Map<String, String> errors = new HashMap<String, String>();
        errors.put("message", exception.getMessage());
        return new ResponseEntity<Object>(errors,exception.getStatusCode());
    }

    @ExceptionHandler(value = Exception.class)
    public final ResponseEntity<Object> handleUnknownExceptions(Exception exception) {
        System.out.println(exception);
        Map<String, String> errors = new HashMap<String, String>();
        errors.put("message", "Something went wrong");
        return new ResponseEntity<Object>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
