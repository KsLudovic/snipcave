package fr.aston.snipcave.snipcave.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;
    private int vote;
    private String comment;

    //Foreign Keys
    @ManyToOne
    @JoinColumn(name = "postId",referencedColumnName = "postId")
    private Post postId;
    @ManyToOne
    @JoinColumn(name="userId",referencedColumnName = "userId")
    private User userId;

}
