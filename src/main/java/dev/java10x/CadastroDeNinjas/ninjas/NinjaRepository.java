package dev.java10x.CadastroDeNinjas.ninjas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
    Optional<NinjaModel> findByEmail(String email);
}