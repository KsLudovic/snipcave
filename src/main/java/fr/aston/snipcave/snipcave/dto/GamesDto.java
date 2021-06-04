package fr.aston.snipcave.snipcave.dto;

import fr.aston.snipcave.snipcave.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GamesDto {
    private long id;
    private String name;
    private boolean multiplayer;
    private int numberMaxPlayer;
    private Post post;
}
