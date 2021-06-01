package fr.aston.snipcave.snipcave.repository;

import fr.aston.snipcave.snipcave.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVoteRepository extends JpaRepository<Vote,Long> {
}
