package dev.java10x.CadastroDeNinjas.missoes;

import dev.java10x.CadastroDeNinjas.ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "missao")
public class MissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private String dificuldade;

    // Uma missão tem vários ninjas
    @OneToMany(mappedBy = "missao")
    private List<NinjaModel> ninjas;

    public MissaoModel() {
    }

    public MissaoModel(Long id, String descricao, String dificuldade, List<NinjaModel> ninjas) {
        this.id = id;
        this.descricao = descricao;
        this.dificuldade = dificuldade;
        this.ninjas = ninjas;
    }

    public List<NinjaModel> getNinjas() {
        return ninjas;
    }

    public void setNinjas(List<NinjaModel> ninjas) {
        this.ninjas = ninjas;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}