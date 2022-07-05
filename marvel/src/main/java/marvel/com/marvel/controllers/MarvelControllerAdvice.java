package marvel.com.marvel.controllers;


import lombok.extern.slf4j.Slf4j;
import marvel.com.marvel.exceptions.MarvelException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(basePackageClasses = CharacterController.class)
@Slf4j
public class MarvelControllerAdvice {

    @ExceptionHandler(MarvelException.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, MarvelException ex) {
        log.warn("Exception during request {}: {}, {}", request.getRequestURI(), ex.getHttpStatus(), ex.getErrorMessage());
        return new ResponseEntity<>(ex.getErrorMessage(), ex.getHttpStatus());
    }
}
