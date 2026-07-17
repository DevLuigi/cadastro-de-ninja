package dev.java10x.CadastroDeNinjas.exception.handler;

import dev.java10x.CadastroDeNinjas.exception.BusinessException;
import dev.java10x.CadastroDeNinjas.exception.ResourceNotFoundException;
import dev.java10x.CadastroDeNinjas.exception.model.ErrorResponse;
import dev.java10x.CadastroDeNinjas.exception.model.ValidationError;
import dev.java10x.CadastroDeNinjas.exception.model.ValidationErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(HttpServletRequest request) {
        int status = HttpStatus.INTERNAL_SERVER_ERROR.value();

        ErrorResponse erro = new ErrorResponse(
                "Ocorreu um erro interno do servidor",
                status,
                LocalDateTime.now(),
                request.getRequestURI()
        );

        return ResponseEntity
                .status(status)
                .body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleArgumentNotValidException(
            MethodArgumentNotValidException exception,
            HttpServletRequest request
    ){
        int status = HttpStatus.BAD_REQUEST.value();

        List<ValidationError> listaErros = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new ValidationError(
                            error.getField(),
                            error.getDefaultMessage()
                        )
                ).toList();

        ValidationErrorResponse erro = new ValidationErrorResponse(
                "Objeto inválido",
                status,
                LocalDateTime.now(),
                request.getRequestURI(),
                listaErros
        );

        return ResponseEntity
                .status(status)
                .body(erro);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(
            DataIntegrityViolationException exception,
            HttpServletRequest request
    ) {
        int status = HttpStatus.CONFLICT.value();

        ErrorResponse erro = new ErrorResponse(
                "Violação da integridade dos dados",
                status,
                LocalDateTime.now(),
                request.getRequestURI()
        );

        return ResponseEntity
                .status(status)
                .body(erro);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(
            BusinessException exception,
            HttpServletRequest request
    ) {
        int status = HttpStatus.CONFLICT.value();

        ErrorResponse erro = new ErrorResponse(
                exception.getMessage(),
                status,
                LocalDateTime.now(),
                request.getRequestURI()
        );

        return ResponseEntity
                .status(status)
                .body(erro);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(
            ResourceNotFoundException exception,
            HttpServletRequest request
    ) {
        int status = HttpStatus.NOT_FOUND.value();

        ErrorResponse erro = new ErrorResponse(
                exception.getMessage(),
                status,
                LocalDateTime.now(),
                request.getRequestURI()
        );

        return ResponseEntity
                .status(status)
                .body(erro);
    }

}
