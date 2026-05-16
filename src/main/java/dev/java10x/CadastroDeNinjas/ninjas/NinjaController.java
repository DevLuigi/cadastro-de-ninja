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
    public List<NinjaModel> listarTodos() {
        return ninjaService.listarTodos();
    }

    @GetMapping("/buscarPorId/{id}")
    public NinjaModel buscarPorId(@PathVariable("id") long id) {
        return ninjaService.buscarPorId(id);
    }

    @PostMapping("/salvar")
    public NinjaModel salvar(@RequestBody NinjaModel ninja) {
        return ninjaService.salvar(ninja);
    }

    @PutMapping("/alterar/{id}")
    public NinjaModel alterar(@PathVariable("id") long id, @RequestBody NinjaModel ninja) {
        return ninjaService.alterar(id, ninja);
    }

    @DeleteMapping("/deletar/{id}")
    public Boolean deletar(@PathVariable("id") long id) {
        boolean deletado = ninjaService.deletar(id);
        return deletado;
    }
}