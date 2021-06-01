package fr.aston.snipcave.snipcave.repository;

import fr.aston.snipcave.snipcave.model.Comment;
import fr.aston.snipcave.snipcave.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findByUser(User user);
    //Optional<Comment> findByPost(Post post);

    @Override
    List<Comment> findAll();

}