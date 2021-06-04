package fr.aston.snipcave.snipcave.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationEmail {

    private String receiver;
    private String subject;
    private String body;
}
