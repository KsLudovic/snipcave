package fr.aston.snipcave.snipcave.repository;

import fr.aston.snipcave.snipcave.model.Games;
import fr.aston.snipcave.snipcave.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IGamesRepository extends JpaRepository<Games, Long> {

   Optional<Games> findByPost(Post post);

    Optional<Games> findByName(String name);

    List<Games> findAllByMultiplayer(Boolean multiplayer);
}
