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

    /**
     * Method to find all plays existed
     * @return a list of play (dto)
     */
    @Transactional(readOnly = true)
    public List<PlayDto> findAll() {
        return playRepository.findAll()
                .stream()
                .map(playMapper::mapToDto)
                .collect(toList());
    }

    /**
     * Method to find all play of a game
     * @param iterable
     * @return a list of play (dto)
     */
    @Transactional(readOnly = true)
    public List<PlayDto> findAllByGamesId(Iterable<Long> iterable) {
        return playRepository.findAllByGamesId(iterable)
                .stream()
                .map(playMapper::mapToDto)
                .collect(toList());
    }

    /**
     * Method to find all play played at a specific date
     * @param date
     * @return a list of plays(dto)
     */
    @Transactional(readOnly = true)
    public List<PlayDto> findAllByDate(Instant date) {
        return playRepository.findAllByDate(date)
                .stream()
                .map(playMapper::mapToDto)
                .collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PlayDto> findAllById(Iterable<Long> iterable) {
        return playRepository.findAllById(iterable)
                .stream()
                .map(playMapper::mapToDto)
                .collect(toList());
    }

    public long count() {
        return playRepository.count();
    }

    public <S extends Play> S saveAndFlush(S s) {
        return playRepository.saveAndFlush(s);
    }

    /**
     * Method to delete a play
     * @param aLong
     */
    public void deleteById(Long aLong) {
        playRepository.deleteById(aLong);
    }
}
