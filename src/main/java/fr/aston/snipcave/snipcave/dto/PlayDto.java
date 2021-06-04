package fr.aston.snipcave.snipcave.dto;

import fr.aston.snipcave.snipcave.model.Games;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayDto {
    private Long id;
    private Instant createdDate;
    private Integer xpWon;
    private Integer nbPlayers;
    private Games game;
}
