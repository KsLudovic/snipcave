package fr.aston.snipcave.snipcave.repository;

import fr.aston.snipcave.snipcave.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ILevelRepository extends JpaRepository<Level, Long> {
    @Override
    long count();
    List<Level> findAll();
    Optional<Level> findById(Long id);
}
