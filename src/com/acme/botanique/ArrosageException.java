package com.acme.botanique;

/**
 * Une exception lors d'arrosage.
 */
public class ArrosageException extends Exception {

    public ArrosageException() {
        super("Quantity négative d'arrosage!");
    }
}
