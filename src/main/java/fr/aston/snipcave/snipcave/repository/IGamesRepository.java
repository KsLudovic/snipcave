package fr.aston.snipcave.snipcave.repository;

import fr.aston.snipcave.snipcave.model.Games;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGamesRepository extends JpaRepository<Games, Long> {



}
