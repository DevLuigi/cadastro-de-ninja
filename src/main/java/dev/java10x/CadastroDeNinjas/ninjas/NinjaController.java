package dev.java10x.CadastroDeNinjas.ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listarTodos")
    public List<NinjaDTO> listarTodos() {
        return ninjaService.listarTodos();
    }

    @GetMapping("/buscarPorId/{id}")
    public NinjaDTO buscarPorId(@PathVariable("id") long id) {
        return ninjaService.buscarPorId(id);
    }

    @PostMapping("/salvar")
    public NinjaDTO salvar(@RequestBody NinjaDTO ninja) {
        return ninjaService.salvar(ninja);
    }

    @PutMapping("/alterar/{id}")
    public NinjaDTO alterar(@PathVariable("id") long id, @RequestBody NinjaDTO ninja) {
        return ninjaService.alterar(id, ninja);
    }

    @DeleteMapping("/deletar/{id}")
    public Boolean deletar(@PathVariable("id") long id) {
        boolean deletado = ninjaService.deletar(id);
        return deletado;
    }
}