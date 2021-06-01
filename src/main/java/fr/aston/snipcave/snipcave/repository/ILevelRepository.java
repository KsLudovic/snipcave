package fr.aston.snipcave.snipcave.repository;

import fr.aston.snipcave.snipcave.model.Comment;
import fr.aston.snipcave.snipcave.model.Level;
import fr.aston.snipcave.snipcave.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ILevelRepository extends JpaRepository<Level, Long> {
    @Override
    long count();
    List<Level> findAll();
}
