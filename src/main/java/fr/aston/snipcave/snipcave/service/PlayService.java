package fr.aston.snipcave.snipcave.service;

import fr.aston.snipcave.snipcave.dto.PlayDto;

import fr.aston.snipcave.snipcave.model.Play;
import fr.aston.snipcave.snipcave.repository.ICommentRepository;
import fr.aston.snipcave.snipcave.repository.IPlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class PlayService {
    private final IPlayRepository playRepository;


    @Autowired
    public PlayService(IPlayRepository playRepository) {
        this.playRepository = playRepository;
    }


    @Transactional(readOnly = true)
    public List<PlayDto> findAll() {
        return playRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(toList());
    }


    @Transactional(readOnly = true)
    public List<PlayDto> findAllByGamesId(Iterable<Long> iterable) {
        return playRepository.findAllByGamesId(iterable)
                .stream()
                .map(this::mapToDto)
                .collect(toList());
    }


    @Transactional(readOnly = true)
    public List<PlayDto> findAllByDate(Instant date) {
        return playRepository.findAllByDate(date)
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
