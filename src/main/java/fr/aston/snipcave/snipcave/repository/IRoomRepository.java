package fr.aston.snipcave.snipcave.repository;

import fr.aston.snipcave.snipcave.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRoomRepository extends JpaRepository<Room,Long> {
    List<Room> findAll();
    List<Room> findAllById(Iterable<Long> iterable);
    List<Room> findAllByPlayId(Iterable<Long> iterable);
    long count();

}
