package org.example.apifluxar.dto;

public class EmployeeReposeDTO {
    private long id;
    private String nome;
    private String sobrenome;
    private String email ;
    private Character cargo;
    private long setor_id;
    private long unidade_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getUnidade_id() {
        return unidade_id;
    }

    public void setUnidade_id(long unidade_id) {
        this.unidade_id = unidade_id;
    }
}
