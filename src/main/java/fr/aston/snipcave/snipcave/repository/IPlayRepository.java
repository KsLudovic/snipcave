package fr.aston.snipcave.snipcave.repository;

import fr.aston.snipcave.snipcave.model.Play;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface IPlayRepository extends JpaRepository<Play,Long> {
    List<Play> findAll();
    List<Play> findAllByGamesId(Iterable<Long> iterable);
    List<Play> findAllByDate(Instant date);
    List<Play> findAllById(Iterable<Long> iterable);
    long count();
}
