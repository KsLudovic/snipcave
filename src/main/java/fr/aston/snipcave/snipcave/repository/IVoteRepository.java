package fr.aston.snipcave.snipcave.repository;

import fr.aston.snipcave.snipcave.model.Post;
import fr.aston.snipcave.snipcave.model.User;
import fr.aston.snipcave.snipcave.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface IVoteRepository extends JpaRepository<Vote,Long> {
    Optional<Vote> findByUserAndPost(User user, Post post);

    void deleteVoteByVoteId(Long id);

    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);

    Collection<Vote> findByPost(Post post);
}
