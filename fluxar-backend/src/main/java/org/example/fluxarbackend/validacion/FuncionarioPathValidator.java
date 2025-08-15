package org.example.fluxarbackend.validacion;

import org.example.fluxarbackend.exception.ErroLoginException;

public class FuncionarioPathValidator {
    public void verificarSenha(String senha) {
        if (senha == null || senha.isEmpty() || senha.length() < 5) {
            throw new ErroLoginException("Senha incorreta");
        }
    }
    public void verificarEmail(String email) {
        if (email == null || email.isEmpty() || email.length() < 6) {
            throw new ErroLoginException("Email incorreta");
        }
    }
}
