package fr.aston.snipcave.snipcave.controller;

import fr.aston.snipcave.snipcave.dto.PlayDto;
import fr.aston.snipcave.snipcave.service.PlayService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/plays")
@AllArgsConstructor
public class PlayController {

    @Autowired
    private PlayService playService;

    @GetMapping("/all")
    public ResponseEntity<List<PlayDto>> getAll(){
        return status(HttpStatus.OK).body(playService.findAll());
    }
    @GetMapping("/all/{date}")
    public ResponseEntity<List<PlayDto>> getAll(@PathVariable Instant date){
        return status(HttpStatus.OK).body(playService.findAllByGameInProgress(date));
    }
    @GetMapping("/all/{gameId}")
    public ResponseEntity<List<PlayDto>> getAll(@PathVariable Long gameId){
        return status(HttpStatus.OK).body(playService.findByGamesId(gameId));
    }
}
