package org.saopaulofc.sociotorcedor.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFfound(NoSuchElementException ne){
        return new ResponseEntity<>(ne.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleAlreadyExists(RuntimeException re){
        return new ResponseEntity<>(re.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public ResponseEntity<String> handleThrowable(Throwable th){
        String message = "Unexpected server error";
        return new ResponseEntity<>(message,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
