package com.techlab.pre_entrega.excepciones;

public class PrecioInvalidoException extends Exception {

    public PrecioInvalidoException(String mensaje) { // es el constructor
        super(mensaje); // super mensaje ...
    }
}
