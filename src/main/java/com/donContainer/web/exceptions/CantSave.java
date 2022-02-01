package com.donContainer.web.exceptions;

public class CantSave extends RuntimeException {
    public CantSave(String error) {
        super(error);
    }
}
