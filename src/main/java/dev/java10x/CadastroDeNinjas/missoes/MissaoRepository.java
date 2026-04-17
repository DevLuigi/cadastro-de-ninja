package dev.java10x.CadastroDeNinjas.missoes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MissaoRepository extends JpaRepository<MissaoModel, Long> {
}