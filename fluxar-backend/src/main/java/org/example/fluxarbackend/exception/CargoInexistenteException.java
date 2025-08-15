package org.example.fluxarbackend.exception;

public class CargoInexistenteException extends RuntimeException{
    public CargoInexistenteException(){
        super("Cargo Inexistente.");
    }
}
