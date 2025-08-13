package org.example.fluxarbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Industria {
    @Id
    private long id;
    @NotNull(message = "O campo nome não pode ser null")
    @NotBlank(message = "O campo nome não pode estar branco")
    @Size(min = 2, max = 100, message = "O nome da indústria deve ter entre 2 a 100 caracteres")
    private String nome;

    @NotNull(message = "O campo nome não pode ser null")
    @NotBlank(message = "O campo nome não pode estar branco")
    @Size(min = 14, max = 14, message = "O CNPJ deve ter exatamente 14 caracteres")
    @Pattern(regexp = "\\d{14}", message = "O CNPJ deve conter apenas números")
    private String cnpj;

    @NotNull(message = "O campo email não pode ser null")
    @NotBlank(message = "O campo email não pode estar branco")
    @Size(min = 6, message = "o email deve ser maior que 6 caracteres")
    private String email;

    //Construtores

    public Industria ( long id, String nome, String cnpj, String email){
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
    }

    public Industria ( String nome, String cnpj, String email){
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
    }

    public Industria(){}

    // Getter e Setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotNull(message = "O campo nome não pode ser null") @NotBlank(message = "O campo nome não pode estar branco") @Size(min = 2, max = 100, message = "O nome da indústria deve ter entre 2 a 100 caracteres") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O campo nome não pode ser null") @NotBlank(message = "O campo nome não pode estar branco") @Size(min = 2, max = 100, message = "O nome da indústria deve ter entre 2 a 100 caracteres") String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "O campo nome não pode ser null") @NotBlank(message = "O campo nome não pode estar branco") @Size(min = 14, max = 14, message = "O CNPJ deve ter exatamente 14 caracteres") @Pattern(regexp = "\\d{14}", message = "O CNPJ deve conter apenas números") String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotNull(message = "O campo nome não pode ser null") @NotBlank(message = "O campo nome não pode estar branco") @Size(min = 14, max = 14, message = "O CNPJ deve ter exatamente 14 caracteres") @Pattern(regexp = "\\d{14}", message = "O CNPJ deve conter apenas números") String cnpj) {
        this.cnpj = cnpj;
    }

    public @NotNull(message = "O campo email não pode ser null") @NotBlank(message = "O campo email não pode estar branco") @Size(min = 6, message = "o email deve ser maior que 6 caracteres") String getEmail() {
        return email;
    }

    public void setEmail(@NotNull(message = "O campo email não pode ser null") @NotBlank(message = "O campo email não pode estar branco") @Size(min = 6, message = "o email deve ser maior que 6 caracteres") String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Industria{" +
                "nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
