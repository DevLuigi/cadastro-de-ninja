package dev.java10x.CadastroDeNinjas.ninjas;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<NinjaDTO>> listarTodos() {
        List<NinjaDTO> ninjas = ninjaService.listarTodos();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<NinjaDTO> buscarPorId(@PathVariable("id") long id) {
        NinjaDTO ninja = ninjaService.buscarPorId(id);
        return ResponseEntity.ok(ninja);
    }

    @PostMapping("/salvar")
    public ResponseEntity<NinjaDTO> salvar(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaCriado = ninjaService.salvar(ninja);
        URI location = URI.create("/ninja/buscarPorId/" + ninjaCriado.getId());
        return ResponseEntity
                .created(location)
                .body(ninjaCriado);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<NinjaDTO> alterar(@PathVariable("id") long id, @RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaAlterado = ninjaService.alterar(id, ninja);
        return ResponseEntity.ok(ninjaAlterado);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") long id) {
        ninjaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}