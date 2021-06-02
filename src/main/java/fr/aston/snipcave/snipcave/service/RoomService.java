package fr.aston.snipcave.snipcave.service;

import fr.aston.snipcave.snipcave.model.Room;
import fr.aston.snipcave.snipcave.repository.IPlayRepository;
import fr.aston.snipcave.snipcave.repository.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final IRoomRepository roomRepository;


    @Autowired
    public RoomService(IRoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public List<Room> findAllById(Iterable<Long> iterable) {
        return roomRepository.findAllById(iterable);
    }

    public List<Room> findAllByPlayId(Iterable<Long> iterable) {
        return roomRepository.findAllByPlayId(iterable);
    }

    public long count() {
        return roomRepository.count();
    }

    public <S extends Room> S saveAndFlush(S s) {
        return roomRepository.saveAndFlush(s);
    }

    public Room getById(Long aLong) {
        return roomRepository.getById(aLong);
    }

    public void deleteById(Long aLong) {
        roomRepository.deleteById(aLong);
    }

    public void delete(Room room) {
        roomRepository.delete(room);
    }

    public <S extends Room> long count(Example<S> example) {
        return roomRepository.count(example);
    }
}
