package com.example.addressbook.exception;

public final class NotFoundException extends IllegalArgumentException {

    public NotFoundException(String message) {
        super(message);
    }

}
