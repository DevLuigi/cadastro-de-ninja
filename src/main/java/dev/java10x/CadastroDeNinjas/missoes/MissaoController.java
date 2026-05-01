package dev.java10x.CadastroDeNinjas.missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missao")
public class MissaoController {

    @GetMapping("/listarTodos")
    public String listarTodos() {
        return "Lista todos as missões";
    }

    @GetMapping("/buscarPorId")
    public String buscarPorId() {
        return "Lista por ID";
    }

    @PostMapping("/salvar")
    public String salvar() {
        return "Salva a missão";
    }

    @PutMapping("/alterar")
    public String alterar() {
        return "Altera a missão";
    }

    @DeleteMapping("/deletar")
    public String deletar() {
        return "Deletar a missão";
    }

}
