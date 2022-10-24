package com.meucarro.exception;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;


@RestControllerAdvice
public class ErrorExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(ErrorExceptionHandler.class);


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        log.warn("Erro: " + ex.getMessage());
        return errors;
    }




    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(JsonParseException.class)
    public Map<String, String> JsonParseException(JsonParseException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("Falha ao converter campo:", ex.getMessage());
        log.warn("Erro: " + ex.getMessage());
        return errors;

    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RegraNegocioException.class)
    public String MensagemCustomizadaRegraNegocioException(RegraNegocioException ex) {

        log.warn("Erro: " + ex.getMessage());
        return   ex.getMessage() ;

    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjetoNotFoundException.class)
    public String MensagemCustomizadaObjetoNotFoundException(ObjetoNotFoundException ex) {

        log.warn("Erro: " + ex.getMessage());
        return   ex.getMessage() ;

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidFormatException.class)
    public String InvalidFormatException(InvalidFormatException ex) {

        log.warn("Erro: " + ex.getMessage());
        return   ex.getMessage() ;

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler( NullPointerException.class)
    public String  NullPointerException( NullPointerException ex) {
        ex.printStackTrace();
        log.warn("Erro: " + ex.getMessage());
        return   ex.getMessage() ;

    }
}
