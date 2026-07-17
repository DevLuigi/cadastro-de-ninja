package dev.java10x.CadastroDeNinjas.missoes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MissaoRepository extends JpaRepository<MissaoModel, Long> {
}