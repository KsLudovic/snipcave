package fr.aston.snipcave.snipcave.controller;

import fr.aston.snipcave.snipcave.dto.GamesDto;
import fr.aston.snipcave.snipcave.model.Games;
import fr.aston.snipcave.snipcave.model.Post;
import fr.aston.snipcave.snipcave.service.GamesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/games")
@AllArgsConstructor
public class GamesController {

    private final GamesService gamesService;

    @GetMapping("/all")
    public List<Games> getAllGames(){
        return gamesService.findAllGames();
    }
    @GetMapping("/{name}")
    public Games getByName(@PathVariable String name){
        return gamesService.findGameByName(name);
    }
    @GetMapping("/{postId}")
    public Games getByPost(@PathVariable Long postId){
        return gamesService.findGameByPost(postId);
    }
    @GetMapping("/multiplayer/{multi}")
    public List<Games> getAllByMultiplayer(@PathVariable boolean multi){
        return gamesService.findAllMultiplayerGame(multi);
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
