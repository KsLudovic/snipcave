package fr.aston.snipcave.snipcave.service;

import fr.aston.snipcave.snipcave.exceptions.SpringSnipcaveException;
import fr.aston.snipcave.snipcave.model.RefreshToken;
import fr.aston.snipcave.snipcave.repository.IRefreshTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class RefreshTokenService {
    private final IRefreshTokenRepository iRefreshTokenRepository;

    public RefreshToken generateRefreshToken(){
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setExpirationDate(Instant.now());
        return iRefreshTokenRepository.save(refreshToken);
    }

    void validateRefreshToken(String token){
        iRefreshTokenRepository.findByToken(token)
                .orElseThrow(() -> new SpringSnipcaveException("Invalid Activation Token"));
    }

    public void deleteRefreshToken(String token){
        iRefreshTokenRepository.deleteByToken(token);
    }


}
