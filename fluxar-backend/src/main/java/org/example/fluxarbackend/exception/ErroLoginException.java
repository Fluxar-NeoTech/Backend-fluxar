package org.example.fluxarbackend.exception;

public class ErroLoginException extends RuntimeException{
    public ErroLoginException(){
        super("Email ou senha inválidos.");
    }
    public ErroLoginException(String mensagem){
        super(mensagem);
    }

}
