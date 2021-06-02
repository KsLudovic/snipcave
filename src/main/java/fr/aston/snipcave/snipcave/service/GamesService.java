package fr.aston.snipcave.snipcave.service;

import fr.aston.snipcave.snipcave.exceptions.PostNotFoundException;
import fr.aston.snipcave.snipcave.exceptions.SpringSnipcaveException;
import fr.aston.snipcave.snipcave.model.Games;
import fr.aston.snipcave.snipcave.model.Post;
import fr.aston.snipcave.snipcave.repository.IGamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamesService {

    private final IGamesRepository gameRepository;
    @Autowired
    public GamesService(IGamesRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Games addGames(Games game){
        return gameRepository.save(game);
    }

    public Games updateGames(Games updatedGame){
        return gameRepository.save(updatedGame);
    }

    public List<Games> findAllGames(){
        return gameRepository.findAll();
    }

    public List<Games> findAllMultiplayerGame(Boolean multiplayer){
        return gameRepository.findAllByMultiplayer(multiplayer);
    }

    public Games findGameByPost(Long postId){
        return gameRepository.findByPost(postId)
                .orElseThrow(() -> new SpringSnipcaveException("There is no game linked to this post."));
    }

    public Games findGameByName(String name){
        return gameRepository.findByName(name)
                .orElseThrow(() -> new SpringSnipcaveException("There is no game named "+name+"."));
    }

    public void deletedGame(Long id){
        gameRepository.deleteById(id);
    }
}
