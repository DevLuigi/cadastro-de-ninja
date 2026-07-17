package dev.java10x.CadastroDeNinjas.exception.model;

public record ValidationError(
        String campo,
        String mensagem
) {
}
