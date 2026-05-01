package dev.java10x.CadastroDeNinjas.ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    @GetMapping("/helloWorld")
    public String HelloWorld() {
        return "Hello world";
    }

    @GetMapping("/listarTodos")
    public String listarTodos() {
        return "Lista todos os ninjas";
    }

    @GetMapping("/buscarPorId")
    public String buscarPorId() {
        return "Lista por ID";
    }

    @PostMapping("/salvar")
    public String salvar() {
        return "Salva o ninja";
    }

    @PutMapping("/alterar")
    public String alterar() {
        return "Altera o ninja";
    }

    @DeleteMapping("/deletar")
    public String deletar() {
        return "Deletar o ninja";
    }

}