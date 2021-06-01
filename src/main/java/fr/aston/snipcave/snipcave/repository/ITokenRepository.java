package fr.aston.snipcave.snipcave.repository;

import fr.aston.snipcave.snipcave.model.Token;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITokenRepository extends JpaRepository<Token, Long> {
  Optional<Token> findByToken(String token);
}
