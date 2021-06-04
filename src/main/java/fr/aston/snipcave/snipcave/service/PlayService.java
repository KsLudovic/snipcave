package fr.aston.snipcave.snipcave.service;

import fr.aston.snipcave.snipcave.dto.PlayDto;

import fr.aston.snipcave.snipcave.exceptions.SpringSnipcaveException;
import fr.aston.snipcave.snipcave.model.Games;
import fr.aston.snipcave.snipcave.model.Play;
import fr.aston.snipcave.snipcave.repository.ICommentRepository;
import fr.aston.snipcave.snipcave.repository.IGamesRepository;
import fr.aston.snipcave.snipcave.repository.IPlayRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
@AllArgsConstructor
public class PlayService {

    private final IPlayRepository playRepository;
    private final IGamesRepository gamesRepository;

    @Transactional(readOnly = true)
    public List<PlayDto> findAll() {
        return playRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PlayDto> findByGamesId(Long id) {
        Games game= gamesRepository.findById(id)
                .orElseThrow(() -> new SpringSnipcaveException("No game found."));
        return playRepository.findByGame(game)
                .stream()
                .map(this::mapToDto)
                .collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PlayDto> findAllByGameInProgress(Instant date) {
        return playRepository.findAllByGameInProgress(date)
                .stream()
                .map(this::mapToDto)
                .collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PlayDto> findAllById(Iterable<Long> iterable) {
        return playRepository.findAllById(iterable)
                .stream()
                .map(this::mapToDto)
                .collect(toList());
    }

    public long count() {
        return playRepository.count();
    }

    public <S extends Play> S saveAndFlush(S s) {
        return playRepository.saveAndFlush(s);
    }

    public void deleteById(Long aLong) {
        playRepository.deleteById(aLong);
    }

    public Play map(PlayDto playDto){
        return new Play(playDto.getId(),
                playDto.getCreatedDate(),
                playDto.getXpWon(),
                playDto.getNbPlayers(),
                playDto.getGame());
    }

    public PlayDto mapToDto (Play play){
        return new PlayDto(play.getPlayId(),
                play.getGameInProgress(),
                play.getXpWon(),
                play.getNbPlayers(),
                play.getGame());
    }
}
