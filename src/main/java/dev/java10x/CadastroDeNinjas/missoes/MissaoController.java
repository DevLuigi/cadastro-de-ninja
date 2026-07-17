package dev.java10x.CadastroDeNinjas.missoes;

import dev.java10x.CadastroDeNinjas.exception.model.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Tag(name = "Missões", description = "Operações para dar manutenção as missões")
@RestController
@RequestMapping("/missao")
public class MissaoController {

    private final MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @Operation(
            summary = "Lista as missões",
            description = "Retorna uma lista com todas as missões do sistema"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Missões listadas com sucesso"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno do servidor",
                    content = @Content(
                            mediaType = "application/json", // Informando que o tipo de conteúdo será um JSON
                            schema = @Schema(
                                    implementation = ErrorResponse.class
                            )
                    )
            )
    })
    @GetMapping("/listarTodos")
    public ResponseEntity<List<MissaoDTO>> listarTodos() {
        List<MissaoDTO> missoes = missaoService.listarTodos();
        return ResponseEntity.ok(missoes);
    }

    @Operation(
            summary = "Busca uma missão por ID",
            description = "Retorna uma missão existente através do ID informado"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Missão encontrada com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Missão não encontrada"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno do servidor",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = ErrorResponse.class
                            )
                    )
            )
    })
    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<MissaoDTO> buscarPorId(
            @Parameter(
                    description = "ID do ninja",
                    example = "10"
            )
            @PathVariable("id") long id
    ) {
        MissaoDTO missao = missaoService.buscarPorId(id);
        return ResponseEntity.ok(missao);
    }

    @Operation(
            summary = "Insere uma missão",
            description = "Realiza o cadastro de uma nova missão"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Missão criada com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Os dados enviados da missão estão inválidos",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ErrorResponse.class
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno do servidor",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ErrorResponse.class
                            )
                    )
            )
    })
    @PostMapping("/salvar")
    public ResponseEntity<MissaoDTO> salvar(@Valid @RequestBody MissaoDTO missao) {
        MissaoDTO missaoCriada = missaoService.salvar(missao);
        URI location = URI.create("/missao/buscarPorId/" + missaoCriada.getId());
        return ResponseEntity
                .created(location)
                .body(missaoCriada);
    }

    @Operation(
            summary = "Altera uma missão por ID",
            description = "Realiza a alteração de uma missão existente através de um ID informado"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Missão alterada com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Os dados enviados da missão estão inválidos",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ErrorResponse.class
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Missão não encontrada",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ErrorResponse.class
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno do servidor",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ErrorResponse.class
                            )
                    )
            )
    })
    @PutMapping("/alterar/{id}")
    public ResponseEntity<MissaoDTO> alterar(
            @Parameter(
                    description = "ID do ninja",
                    example = "10"
            )
            @PathVariable("id") long id,
            @Valid @RequestBody MissaoDTO missao
    ) {
        MissaoDTO missaoAlterada = missaoService.alterar(id, missao);
        return ResponseEntity.ok(missaoAlterada);
    }

    @Operation(
            summary = "Deleta uma missão por ID",
            description = "Deleta uma missão existente através do ID informado"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Missão deletada com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Missão não encontrada",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ErrorResponse.class
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno do servidor",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ErrorResponse.class
                            )
                    )
            )
    })
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletar(
            @Parameter(
                    description = "ID do ninja",
                    example = "10"
            )
            @PathVariable("id") long id
    ) {
        missaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
