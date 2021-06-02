package fr.aston.snipcave.snipcave.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @NotNull
    private boolean multiplayer;
    @NotNull
    private int numberMaxPlayer;
    @OneToOne
    @JoinColumn(name="postId",nullable = false,referencedColumnName = "postId")
    private Post post;

}
