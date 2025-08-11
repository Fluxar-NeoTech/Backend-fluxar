package org.example.fluxarbackend.exception;

public class CargoInexistenteException extends RuntimeException{
    public CargoInexistenteException(){
        super("Cargo Inexistente. Os possiveis sao G e A");
    }
    public CargoInexistenteException(String msg){
        super(msg);
    }
}
