package me.jjeda.accountexample.exception;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(long id) {
        super(id + " is not exited");
    }
}
