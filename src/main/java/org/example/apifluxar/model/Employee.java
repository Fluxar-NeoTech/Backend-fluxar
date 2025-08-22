package org.example.apifluxar.model;

import jakarta.persistence.*;

// We only read this table, so no further validations are needed.
@Entity
@Table(name = "Funcionario")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String sobrenome;
    private String email ;
    private String senha;
    private Character cargo;
    private long setor_id;
    private String unidade_id;

    //Construct

    public Employee(Character cargo, String email, long id, String nome, String senha, long setor_id, String sobrenome, String unidade_id) {
        this.cargo = cargo;
        this.email = email;
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.setor_id = setor_id;
        this.sobrenome = sobrenome;
        this.unidade_id = unidade_id;
    }


    public Employee() {}

    //Getter e Setter
    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Character getCargo() {
        return cargo;
    }

    public void setCargo(Character cargo) {
        this.cargo = cargo;
    }

    public long getSetor_id() {
        return setor_id;
    }

    public void setSetor_id(long setor_id) {
        this.setor_id = setor_id;
    }

    public String getUnidade_id() {
        return unidade_id;
    }

    public void setUnidade_id(String unidade_id) {
        this.unidade_id = unidade_id;
    }
}
