package fr.aston.snipcave.snipcave.service;

import fr.aston.snipcave.snipcave.repository.IGamesRepository;
import org.springframework.stereotype.Service;

@Service
public class GamesService {

    private final IGamesRepository gameRepository;

    public GamesService(IGamesRepository gameRepository) {
        this.gameRepository = gameRepository;
    }


}
