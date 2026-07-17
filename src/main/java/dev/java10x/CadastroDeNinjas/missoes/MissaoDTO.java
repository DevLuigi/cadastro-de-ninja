package dev.java10x.CadastroDeNinjas.missoes;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Dados para manipular uma Missão")
public class MissaoDTO {

    @Schema(
            description = "Identificador único da missão",
            example = "12"
    )
    private Long id;

    @Schema(
            description = "Descrição da missão",
            example = "Derrotar Uchiha Madara na guerra ninja"
    )
    @NotBlank(message = "A descrição da missão é obrigatória")
    @Size(message = "A descrição deve ter no mínimo 10 caracteres", min = 10)
    private String descricao;

    @Schema(
            description = "Dificuldade da missão",
            example = "FACIL"
    )
    @NotBlank(message = "A dificuldade é obrigatória")
    private String dificuldade;

    @Schema(
            description = "Localização da missão",
            example = "Konoha"
    )
    @NotBlank(message = "A localização é obrigatória")
    private String localizacao;

}