package fr.aston.snipcave.snipcave.exceptions;

public class CommentException extends RuntimeException {
    public CommentException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public CommentException(String exMessage) {
        super(exMessage);
    }
}
