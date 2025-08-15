package org.example.fluxarbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O campo nome não pode ser null")
    @NotBlank(message = "O campo nome não pode estar branco")
    @Size(min = 2, max = 100, message = "O nome do setor deve ter entre 2 a 100 caracteres")
    private String nome;

    @NotNull(message = "O campo nome não pode ser null")
    @NotBlank(message = "O campo nome não pode estar branco")
    @Size(min = 2, max = 250, message = "A descrição do setor deve ter entre 2 a 250 caracteres")
    private String descricao;

    // Construtores

    public Setor(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Setor (String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Setor() {}

    // Getter e Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "O campo nome não pode ser null") @NotBlank(message = "O campo nome não pode estar branco") @Size(min = 2, max = 100, message = "O nome do setor deve ter entre 2 a 100 caracteres") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O campo nome não pode ser null") @NotBlank(message = "O campo nome não pode estar branco") @Size(min = 2, max = 100, message = "O nome do setor deve ter entre 2 a 100 caracteres") String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "O campo nome não pode ser null") @NotBlank(message = "O campo nome não pode estar branco") @Size(min = 2, max = 250, message = "A descrição do setor deve ter entre 2 a 250 caracteres") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O campo nome não pode ser null") @NotBlank(message = "O campo nome não pode estar branco") @Size(min = 2, max = 250, message = "A descrição do setor deve ter entre 2 a 250 caracteres") String descricao) {
        this.descricao = descricao;
    }

    // toString

    @Override
    public String toString() {
        return "Setor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
