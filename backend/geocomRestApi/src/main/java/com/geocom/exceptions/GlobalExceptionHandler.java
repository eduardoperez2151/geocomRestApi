package com.geocom.exceptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.geocom.dtos.ResponseAPI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.geocom.dtos.ResponseAPI.error;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.status;


@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ResponseAPI> handleNotFoundEntityException() throws IOException {
        final ResponseAPI responseAPI = error("No se pudo recuperar la receta");
        return status(HttpStatus.NOT_FOUND).body(responseAPI);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ResponseAPI> handleMethodArgumentTypeMismatchException() throws IOException {
        final ResponseAPI responseAPI = error("Error en la petici\u00F3n del servicio");
        return badRequest().body(responseAPI);
    }

    @ExceptionHandler({InvalidFormatException.class,HttpMessageNotReadableException.class})
    public ResponseEntity<ResponseAPI> handleHttpMessageNotReadableException() throws IOException {
        final ResponseAPI responseAPI = error("Error en el proceso de deserializacion");
        return  badRequest().body(responseAPI);
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<ResponseAPI> handleHttpMediaTypeNotAcceptableException() throws IOException {
        final ResponseAPI responseAPI = error("Error generar la respuesta");
        return  badRequest().body(responseAPI);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseAPI> handleGenericException() throws IOException {
        final ResponseAPI responseAPI = error("No se pudo recuperar la receta");
        return status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseAPI);
    }

}
