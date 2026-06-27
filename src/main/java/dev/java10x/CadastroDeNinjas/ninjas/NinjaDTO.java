package dev.java10x.CadastroDeNinjas.ninjas;

import dev.java10x.CadastroDeNinjas.missoes.MissaoModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Dados para manipular um Ninja")
public class NinjaDTO {

    @Schema(
            description = "Identificador único do ninja",
            example = "77"
    )
    private Long id;

    @Schema(
            description = "Idade do ninja",
            example = "21"
    )
    private int idade;

    @Schema(
            description = "Nome do ninja",
            example = "Naruto Uzumaki"
    )
    private String nome;

    @Schema(
            description = "Rank do ninja",
            example = "GENNIN"
    )
    private String rank;

    @Schema(
            description = "E-mail do ninja",
            example = "narutouzumaki@gmail.com"
    )
    private String email;

    @Schema(
            description = "Missão que o ninja está relacionado"
    )
    private MissaoModel missao;
}
