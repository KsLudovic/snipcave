package fr.aston.snipcave.snipcave.repository;

import fr.aston.snipcave.snipcave.model.Post;
import fr.aston.snipcave.snipcave.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IPostRepository extends JpaRepository<Post,Long> {
    Optional<Post> findByUser(User user);

   // void deletePostById(Long id);

    Optional<Post> findByName(String name);
}
