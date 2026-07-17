package dev.java10x.CadastroDeNinjas.ninjas;

import dev.java10x.CadastroDeNinjas.missoes.MissaoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
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
    @NotNull(message = "A idade é obrigatória")
    @Positive(message = "A idade deve ser um valor positivo maior que zero")
    private Integer idade;

    @Schema(
            description = "Nome do ninja",
            example = "Naruto Uzumaki"
    )
    @NotBlank(message = "O nome é obrigatório")
    @Size(message = "O nome deve conter entre 3 e 50 caracteres", min = 3 , max = 50)
    private String nome;

    @Schema(
            description = "Rank do ninja",
            example = "GENNIN"
    )
    @NotBlank(message = "O rank é obrigatório")
    private String rank;

    @Schema(
            description = "E-mail do ninja",
            example = "narutouzumaki@gmail.com"
    )
    @Email(message = "E-mail inválido")
    @NotBlank(message = "O e-mail é obrigatório")
    private String email;

    @Schema(
            description = "Missão que o ninja está relacionado"
    )
    @NotNull(message = "A missão é obrigatória")
    private MissaoDTO missao;
}
