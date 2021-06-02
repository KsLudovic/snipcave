package fr.aston.snipcave.snipcave.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Collection;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToMany(fetch= FetchType.EAGER)  // la relation est chargée par défaut
    private Collection<User> users;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="playId",referencedColumnName = "playId")
    private Play play;
}
