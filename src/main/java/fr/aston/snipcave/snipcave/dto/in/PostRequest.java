package fr.aston.snipcave.snipcave.dto.in;

import fr.aston.snipcave.snipcave.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    private Long postId;
    private String postName;
    private String url;
    private String description;
    private String script;
    private Instant instant;
    private Long userId;

}