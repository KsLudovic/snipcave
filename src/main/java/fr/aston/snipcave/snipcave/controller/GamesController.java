package fr.aston.snipcave.snipcave.controller;

import fr.aston.snipcave.snipcave.dto.GamesDto;
import fr.aston.snipcave.snipcave.model.Games;
import fr.aston.snipcave.snipcave.model.Post;
import fr.aston.snipcave.snipcave.service.GamesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/games")
@AllArgsConstructor
public class GamesController {

    private final GamesService gamesService;

    @GetMapping("/all")
    public ResponseEntity<List<GamesDto>> getAllGames(){
        return status(HttpStatus.OK).body(gamesService.findAllGames());
    }
    @GetMapping("/{name}")
    public ResponseEntity<GamesDto> getByName(@PathVariable String name){
        return status(HttpStatus.OK).body(gamesService.findGameByName(name));
    }
    @GetMapping("/{postId}")
    public ResponseEntity<GamesDto> getByPost(@PathVariable Long postId){
        return status(HttpStatus.OK).body(gamesService.findGameByPost(postId));
    }
    @GetMapping("/multiplayer/{multi}")
    public ResponseEntity<List<GamesDto>> getAllByMultiplayer(@PathVariable boolean multi){
        return status(HttpStatus.OK).body(gamesService.findAllMultiplayerGame(multi));
    }

//    @PostMapping("/add")
//    public Games postGame(@Valid @RequestBody Games game){
//        return gamesService.addGames(game);
//    }
//    @PutMapping("/update")
//    public GamesDto putGame(@Valid @RequestBody Games updateGame){
//        return gamesService.updateGames(updateGame);
//    }

}
