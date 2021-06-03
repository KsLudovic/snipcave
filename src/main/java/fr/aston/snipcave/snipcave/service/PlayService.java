package fr.aston.snipcave.snipcave.service;

import fr.aston.snipcave.snipcave.dto.PlayDto;
import fr.aston.snipcave.snipcave.mapper.PlayMapper;
import fr.aston.snipcave.snipcave.model.Play;
import fr.aston.snipcave.snipcave.repository.ICommentRepository;
import fr.aston.snipcave.snipcave.repository.IPlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class PlayService {
    private final IPlayRepository playRepository;
    private  PlayMapper playMapper;


    @Autowired
    public PlayService(IPlayRepository playRepository) {
        this.playRepository = playRepository;
    }

    public List<PlayDto> findAll() {
        return playRepository.findAll()
                .stream()
                .map(playMapper::mapToDto)
                .collect(toList());
    }

    public List<PlayDto> findAllByGamesId(Iterable<Long> iterable) {
        return playRepository.findAllByGamesId(iterable)
                .stream()
                .map(playMapper::mapToDto)
                .collect(toList());
    }

    public List<PlayDto> findAllByDate(Iterable<Long> iterable) {
        return playRepository.findAllByDate(iterable)
                .stream()
                .map(playMapper::mapToDto)
                .collect(toList());
    }

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

    public void deleteById(Long aLong) {
        playRepository.deleteById(aLong);
    }
}
