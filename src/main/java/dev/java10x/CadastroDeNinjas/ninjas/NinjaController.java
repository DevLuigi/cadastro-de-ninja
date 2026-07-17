package dev.java10x.CadastroDeNinjas.ninjas;

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

@Tag(name = "Ninjas", description = "Operações para dar manutenção aos ninjas")
@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @Operation(
            summary = "Lista os ninjas",
            description = "Retorna uma lista com todos os ninjas do sistema"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Ninjas listados com sucesso"
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
    @GetMapping("/listarTodos")
    public ResponseEntity<List<NinjaDTO>> listarTodos() {
        List<NinjaDTO> ninjas = ninjaService.listarTodos();
        return ResponseEntity.ok(ninjas);
    }

    @Operation(
            summary = "Busca ninja por ID",
            description = "Retorna um ninja existente através do ID informado"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Ninja encontrado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Ninja não encontrado",
                    content = @Content(
                            schema = @Schema(
                                    implementation = org.springframework.web.ErrorResponse.class
                            )
                    )
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
    public ResponseEntity<NinjaDTO> buscarPorId(
            @Parameter(
                    description = "ID do ninja",
                    example = "10"
            )
            @PathVariable("id") long id
    ) {
        NinjaDTO ninja = ninjaService.buscarPorId(id);
        return ResponseEntity.ok(ninja);
    }

    @Operation(
            summary = "Insere um ninja",
            description = "Realiza o cadastro de um novo ninja"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Ninja salvo com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Os dados do ninja estão inválidos",
                    content = @Content(
                            schema = @Schema(
                                    implementation = org.springframework.web.ErrorResponse.class
                            )
                    )
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
    @PostMapping("/salvar")
    public ResponseEntity<NinjaDTO> salvar(@Valid @RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaCriado = ninjaService.salvar(ninja);
        URI location = URI.create("/ninja/buscarPorId/" + ninjaCriado.getId());
        return ResponseEntity
                .created(location)
                .body(ninjaCriado);
    }

    @Operation(
            summary = "Altera ninja por ID",
            description = "Altera um ninja existente através do ID informado"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Ninja alterado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Os dados do ninja estão inválidos",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ErrorResponse.class
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Ninja não encontrado",
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
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = ErrorResponse.class
                            )
                    )
            )
    })
    @PutMapping("/alterar/{id}")
    public ResponseEntity<NinjaDTO> alterar(
            @Parameter(
                    description = "ID do ninja",
                    example = "10"
            )
            @PathVariable("id") long id,
            @Valid @RequestBody NinjaDTO ninja
    ) {
        NinjaDTO ninjaAlterado = ninjaService.alterar(id, ninja);
        return ResponseEntity.ok(ninjaAlterado);
    }

    @Operation(
            summary = "Deleta ninja por ID",
            description = "Deleta um ninja existente através do ID informado"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Ninja deletado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Ninja não encontrado",
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
                            mediaType = "application/json",
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
        ninjaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}