package org.example.fluxarbackend.repository;

import org.example.fluxarbackend.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Optional<Funcionario> findByEmailAndSenha(String email, String senha);
}
