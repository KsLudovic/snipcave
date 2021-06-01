package fr.aston.snipcave.snipcave.exceptions;

import javax.validation.constraints.NotBlank;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(@NotBlank(message = "Username is required") String s) {
    }
}
