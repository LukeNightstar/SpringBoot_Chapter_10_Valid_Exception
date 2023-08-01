package com.springboot.valid_exception.common.exception;

import com.springboot.valid_exception.common.exceptior.CustomException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice //(basePackages = "com.springboot.valid_exception")
public class CustomExceptionHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Map<String, String>> handlerException(RuntimeException e, HttpServletRequest request) {

        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        LOGGER.error("Advice 내 HandleException 호출, {}, {}", request.getRequestURI(),
                e.getMessage());

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", e.getMessage());

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<Map<String, String>> handleException(CustomException e,                                                               HttpServletRequest request) {
        HttpHeaders responseHeaders = new HttpHeaders();

        LOGGER.error("Advice 내 handleException 호출, {}, {}", request.getRequestURI(), e.getMessage());
        Map<String, String> map = new HashMap<>();

        map.put("error type", e.getHttpStatusType());
        map.put("code", Integer.toString(e.getHttpStatusCode()));
        map.put("message", e.getMessage());

        return new ResponseEntity<>(map, responseHeaders, e.getHttpStatus());
    }


}
