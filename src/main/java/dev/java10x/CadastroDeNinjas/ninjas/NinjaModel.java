package dev.java10x.CadastroDeNinjas.ninjas;

import dev.java10x.CadastroDeNinjas.missoes.MissaoModel;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "ninja")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;

    // Um ninja tem uma Missão
    @ManyToOne
    @JoinColumn(name = "missao_id")
    private MissaoModel missao;

    public NinjaModel() {
    }

    public NinjaModel(int idade, String email, String nome, Long id) {
        this.idade = idade;
        this.email = email;
        this.nome = nome;
        this.id = id;
    }

    public NinjaModel(Long id, String nome, String email, int idade, MissaoModel missao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.missao = missao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public MissaoModel getMissao() {
        return missao;
    }

    public void setMissao(MissaoModel missao) {
        this.missao = missao;
    }
}