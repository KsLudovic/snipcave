package fr.aston.snipcave.snipcave.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.Instant;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Play {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long playId;
    Instant gameInProgress;
    private Integer xpWon;
    private Integer nbPlayers;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="gamesId", referencedColumnName = "gamesId")
    private Games game;

}
