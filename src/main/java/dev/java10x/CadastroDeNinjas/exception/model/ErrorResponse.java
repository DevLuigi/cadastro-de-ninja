package dev.java10x.CadastroDeNinjas.exception.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Resposta de erro padrão")
public class ErrorResponse {

    @Schema(
            description = "Mensagem descritiva do erro",
            example = "Mensagem de erro"
    )
    private String mensagem;

    @Schema(
            description = "Status do erro",
            example = "999"
    )
    private Integer status;

    @Schema(
            description = "Data e hora do erro",
            example = "2026-06-12T10:30:00"
    )
    private LocalDateTime timeStamp;

    @Schema(
            description = "Local onde erro ocorreu",
            example = "/ninja/999"
    )
    private String caminho;
}
