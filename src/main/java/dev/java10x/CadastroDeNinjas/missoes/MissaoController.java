package dev.java10x.CadastroDeNinjas.missoes;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/missao")
public class MissaoController {

    private final MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @GetMapping("/listarTodos")
    public List<MissaoModel> listarTodos() {
        return missaoService.listarTodos();
    }

    @GetMapping("/buscarPorId/{id}")
    public MissaoModel buscarPorId(@PathVariable("id") long id) {
        return missaoService.buscarPorId(id);
    }

    @PostMapping("/salvar")
    public MissaoModel salvar(@RequestBody MissaoModel missao) {
        return missaoService.salvar(missao);
    }

    @PutMapping("/alterar/{id}")
    public MissaoModel alterar(@PathVariable("id") long id, @RequestBody MissaoModel missao) {
        return missaoService.alterar(id, missao);
    }

    @DeleteMapping("/deletar/{id}")
    public Boolean deletar(@PathVariable("id") long id) {
        boolean deletado = missaoService.deletar(id);
        return deletado;
    }

}
