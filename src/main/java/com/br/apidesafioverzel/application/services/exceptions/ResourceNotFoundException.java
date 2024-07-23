package com.br.apidesafioverzel.application.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{


    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
