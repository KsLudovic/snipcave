package fr.aston.snipcave.snipcave.repository;

import fr.aston.snipcave.snipcave.model.Comment;
import fr.aston.snipcave.snipcave.model.Post;
import fr.aston.snipcave.snipcave.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {
    void deleteCommentById(Long id);
    List<Comment> findAll();

    Collection<Comment> findByPost(Post post);

    Collection<Comment> findAllByUser(User user);
}