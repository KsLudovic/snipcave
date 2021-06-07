package fr.aston.snipcave.snipcave.controller;


import fr.aston.snipcave.snipcave.dto.CommentsDto;
import fr.aston.snipcave.snipcave.dto.LevelDto;
import fr.aston.snipcave.snipcave.service.CommentService;
import fr.aston.snipcave.snipcave.service.LevelService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/levels")
@AllArgsConstructor
public class LevelController {

    private LevelService levelService;

    @PostMapping
    public ResponseEntity<Void> createLevel(@RequestBody LevelDto levelDto) {
        levelService.save(levelDto);
        return new ResponseEntity<>(CREATED);
    }
}
