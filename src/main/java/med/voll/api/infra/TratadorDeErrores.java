package med.voll.api.infra;

import java.util.NoSuchElementException;

import javax.swing.text.html.parser.Entity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorDeErrores {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity tratarError404(){
        return ResponseEntity.notFound().build();
    }




}
