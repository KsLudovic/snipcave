package fr.aston.snipcave.snipcave.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LevelDto {
    private Long id;
    private String level;
    private Integer ExperienceMax;
}
