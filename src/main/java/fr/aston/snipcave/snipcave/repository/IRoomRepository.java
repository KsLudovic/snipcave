package fr.aston.snipcave.snipcave.repository;

import fr.aston.snipcave.snipcave.model.Play;
import fr.aston.snipcave.snipcave.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface IRoomRepository extends JpaRepository<Room,Long> {
    List<Room> findAll();
    List<Room> findAllById(Iterable<Long> iterable);
    long count();

    List<Room> findByPlay(Play play);
}
