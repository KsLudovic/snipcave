package fr.aston.snipcave.snipcave.exceptions;

public class SpringSnipcaveException extends RuntimeException {
    public SpringSnipcaveException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public SpringSnipcaveException(String exMessage) {
        super(exMessage);
    }
}