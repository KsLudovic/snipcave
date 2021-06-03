package fr.aston.snipcave.snipcave.service;

import fr.aston.snipcave.snipcave.dto.GamesDto;
import fr.aston.snipcave.snipcave.exceptions.SpringSnipcaveException;
import fr.aston.snipcave.snipcave.mapper.GameMapper;
import fr.aston.snipcave.snipcave.model.Games;
import fr.aston.snipcave.snipcave.repository.IGamesRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class GamesService {

    private final GameMapper gameMapper;
    private final IGamesRepository gameRepository;


    public Games addGames(Games game){
        return gameRepository.save(game);
    }

    public Games updateGames(Games updatedGame){
        return gameRepository.save(updatedGame);
    }

    public List<GamesDto> findAllGames(){
        return gameRepository.findAll()
                .stream()
                .map(gameMapper::mapToDto)
                .collect(toList());
    }

    public List<GamesDto> findAllMultiplayerGame(Boolean multiplayer){
        return gameRepository.findAllByMultiplayer(multiplayer)
                .stream()
                .map(gameMapper::mapToDto)
                .collect(toList());
    }

    public GamesDto findGameByPost(Long postId){
        Games game=gameRepository.findByPost(postId)
                .orElseThrow(() -> new SpringSnipcaveException("There is no game linked to this post."));
                return gameMapper.mapToDto(game);
    }

    public GamesDto findGameByName(String name){
        Games game=gameRepository.findByName(name)
                .orElseThrow(() -> new SpringSnipcaveException("There is no game named "+name+"."));
        return gameMapper.mapToDto(game);
    }

    public void deletedGame(Long id){
        gameRepository.deleteById(id);
    }
}
