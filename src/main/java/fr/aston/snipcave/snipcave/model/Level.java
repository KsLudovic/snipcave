package fr.aston.snipcave.snipcave.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Level {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long levelId;
    @Column(name="level")
    private String level="1";
    @Column(name="ExperienceMax")
    private Integer ExperienceMax=100;

}
