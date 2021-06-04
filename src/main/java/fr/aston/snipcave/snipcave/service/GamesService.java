package fr.aston.snipcave.snipcave.service;

import fr.aston.snipcave.snipcave.dto.GamesDto;
import fr.aston.snipcave.snipcave.exceptions.SpringSnipcaveException;
import fr.aston.snipcave.snipcave.model.Games;
import fr.aston.snipcave.snipcave.repository.IGamesRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Transactional
public class GamesService {

    private final IGamesRepository gameRepository;


    public Games addGames(Games game){
        return gameRepository.save(game);
    }

    public Games updateGames(Games updatedGame){
        return gameRepository.save(updatedGame);
    }

    @Transactional(readOnly = true)
    public List<GamesDto> findAllGames(){
        return gameRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(toList());
    }
    @Transactional(readOnly = true)
    public List<GamesDto> findAllMultiplayerGame(Boolean multiplayer){
        return gameRepository.findAllByMultiplayer(multiplayer)
                .stream()
                .map(this::mapToDto)
                .collect(toList());
    }
    @Transactional(readOnly = true)
    public GamesDto findGameByPost(Long postId){
        Games game=gameRepository.findByPost(postId)
                .orElseThrow(() -> new SpringSnipcaveException("There is no game linked to this post."));
                return this.mapToDto(game);
    }
    @Transactional(readOnly = true)
    public GamesDto findGameByName(String name){
        Games game=gameRepository.findByName(name)
                .orElseThrow(() -> new SpringSnipcaveException("There is no game named "+name+"."));
        return this.mapToDto(game);
    }

    public void deletedGame(Long id){
        gameRepository.deleteById(id);
    }

    public Games map(GamesDto gamesDto){
        return new Games(gamesDto.getId(),
                gamesDto.getName(),
                gamesDto.isMultiplayer(),
                gamesDto.getNumberMaxPlayer(),
                gamesDto.getPost());
    }

    public  GamesDto mapToDto(Games game){
        return new GamesDto(game.getGamesId(),
                game.getName(),
                game.isMultiplayer(),
                game.getNumberMaxPlayer(),
                game.getPost());
    }
}
