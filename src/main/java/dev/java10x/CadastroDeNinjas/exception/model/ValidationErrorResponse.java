package dev.java10x.CadastroDeNinjas.exception.model;

import java.time.LocalDateTime;
import java.util.List;

public record ValidationErrorResponse(
        String mensagem,
        int status,
        LocalDateTime timestamp,
        String caminho,
        List<ValidationError> listaErros
) {
}
