package Client.Api_Restfull_Client.controller.handlers;

import Client.Api_Restfull_Client.dto.CustomErrorDTO;
import Client.Api_Restfull_Client.dto.ValidationErrorDTO;
import Client.Api_Restfull_Client.service.exceptions.DatabaseException;
import Client.Api_Restfull_Client.service.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomErrorDTO>resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomErrorDTO error = new CustomErrorDTO(Instant.now(),status.value(),e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<CustomErrorDTO> databaseViolation(DatabaseException e,HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomErrorDTO error = new CustomErrorDTO(Instant.now(),status.value(),e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorDTO>methodArgumentNotValidation(MethodArgumentNotValidException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationErrorDTO err = new ValidationErrorDTO(Instant.now(), status.value(), "Invalid data", request.getRequestURI());
        for(FieldError f : e.getBindingResult().getFieldErrors()){
            err.addError(f.getField(),f.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(err);
    }


}
