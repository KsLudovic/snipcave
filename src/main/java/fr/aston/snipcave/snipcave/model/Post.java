package fr.aston.snipcave.snipcave.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @NotBlank
    private String description;
    @NotBlank
    private String url;
    @NotBlank
    private String name;
    private Instant posted;
    @NotBlank
    private String script;
    private int totalVote;

    //Foreign keys
    @ManyToOne
    @JoinColumn(name="userId",referencedColumnName = "userId")
    private User user;
}
