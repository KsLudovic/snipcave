package fr.aston.snipcave.snipcave.service;

import fr.aston.snipcave.snipcave.model.Play;
import fr.aston.snipcave.snipcave.repository.ICommentRepository;
import fr.aston.snipcave.snipcave.repository.IPlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayService {
    private final IPlayRepository playRepository;


    @Autowired
    public PlayService(IPlayRepository playRepository) {
        this.playRepository = playRepository;
    }

    public List<Play> findAll() {
        return playRepository.findAll();
    }

    public List<Play> findAllByGamesId(Iterable<Long> iterable) {
        return playRepository.findAllByGamesId(iterable);
    }

    public List<Play> findAllByDate(Iterable<Long> iterable) {
        return playRepository.findAllByDate(iterable);
    }

    public List<Play> findAllById(Iterable<Long> iterable) {
        return playRepository.findAllById(iterable);
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
