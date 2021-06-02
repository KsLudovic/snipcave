package fr.aston.snipcave.snipcave.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.Instant;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Token {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private String token;
    @OneToOne(fetch = LAZY)
    private User user;
    private Instant expirationDate;
}
