package fr.aston.snipcave.snipcave.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Games {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    @NotBlank
    private String name;
    @NotBlank
    private boolean multiplayer;
    @NotBlank
    private int numberMaxPlayer;
    @OneToOne
    @JoinColumn(name="postId",nullable = false,referencedColumnName = "postId")
    private Post post;

}
