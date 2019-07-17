package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CollegueException {

    // @ControllerAdvice désigne un greffon appliqué aux controlleurs

    // la méthode handleConflict est exécutée lorsqu'un contrôleur émet une
    // exception présente
    // dans la liste définie par l'annotation @ExceptionHandler
    @ExceptionHandler(value = { ColleguesNonTrouveException.class })
    protected ResponseEntity<Object> handleConflict(ColleguesNonTrouveException ex) {
        String bodyOfResponse = "Collegue non trouvé";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bodyOfResponse);

    }
}
