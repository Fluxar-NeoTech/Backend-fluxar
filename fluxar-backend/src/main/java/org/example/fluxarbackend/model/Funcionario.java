package org.example.fluxarbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Funcionario {
    @Id
    private long id;
    @Size(min = 2, message = "Nome invalido, coloque um nome maior ")
    @NotNull(message = "O campo nome não pode ser null")
    @NotBlank(message = "O campo nome não pode estar branco")
    private String nome;
    @NotNull(message = "O campo sobrenome não pode ser null")
    @NotBlank(message = "O campo sobrenome não pode estar branco")
    private String sobrenome;
    @NotNull(message = "O campo email não pode ser null")
    @NotBlank(message = "O campo email não pode estar branco")
    @Size(min = 6, message = "o email deve ser maior que 6 caracteres")
    private String email;
    @Size(min = 5, message = "Senha invalido, coloque uma senha maior que 5 caracteres")
    @NotNull(message = "O campo nome não pode ser null")
    private String senha;
    private String cargo;
    private Long unidade_id;
    private Long setor_id;

    // Controllers


    public Funcionario( long id, String nome, String sobrenome, String email, String senha, String cargo, Long setor_id, Long unidade_id) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
        this.setor_id = setor_id;
        this.unidade_id = unidade_id;
    }

    public Funcionario( String nome, String sobrenome, String email, String senha, String cargo, Long setor_id, Long unidade_id) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
        this.setor_id = setor_id;
        this.unidade_id = unidade_id;
    }

    public Funcionario() {}

    // Getter e Setter

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public long getId() {
        return id;
    }

    public @Size(min = 2, message = "Nome invalido, coloque um nome maior ") @NotNull(message = "O campo nome não pode ser null") @NotBlank(message = "O campo nome não pode estar branco") String getNome() {
        return nome;
    }

    public void setNome(@Size(min = 2, message = "Nome invalido, coloque um nome maior ") @NotNull(message = "O campo nome não pode ser null") @NotBlank(message = "O campo nome não pode estar branco") String nome) {
        this.nome = nome;
    }

    public @Size(min = 5, message = "Senha invalido, coloque um nome maior ") @NotNull(message = "O campo nome não pode ser null") String getSenha() {
        return senha;
    }

    public void setSenha(@Size(min = 5, message = "Senha invalido, coloque um nome maior ") @NotNull(message = "O campo nome não pode ser null") String senha) {
        this.senha = senha;
    }

    public Long getSetor_id() {
        return setor_id;
    }

    public void setSetor_id(Long setor_id) {
        this.setor_id = setor_id;
    }

    public @NotNull(message = "O campo sobrenome não pode ser null") @NotBlank(message = "O campo sobrenome não pode estar branco") String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(@NotNull(message = "O campo sobrenome não pode ser null") @NotBlank(message = "O campo sobrenome não pode estar branco") String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Long getUnidade_id() {
        return unidade_id;
    }

    public void setUnidade_id(Long unidade_id) {
        this.unidade_id = unidade_id;
    }

    public @NotNull(message = "O campo email não pode ser null") @NotBlank(message = "O campo email não pode estar branco") @Size(min = 6, message = "o email deve ser maior que 6 caracteres") String getEmail() {
        return email;
    }

    public void setEmail(@NotNull(message = "O campo email não pode ser null") @NotBlank(message = "O campo email não pode estar branco") @Size(min = 6, message = "o email deve ser maior que 6 caracteres") String email) {
        this.email = email;
    }

    //toString

    @Override
    public String toString() {
        return "Funcionario{" +
                "cargo='" + cargo + '\'' +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", senha='" + senha + '\'' +
                ", unidade_id=" + unidade_id +
                ", setor_id=" + setor_id +
                '}';
    }
}
