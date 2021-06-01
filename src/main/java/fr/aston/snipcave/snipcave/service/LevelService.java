package fr.aston.snipcave.snipcave.service;


import fr.aston.snipcave.snipcave.model.Level;
import fr.aston.snipcave.snipcave.repository.ILevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevelService {

    private ILevelRepository ILevelRepository;


    @Autowired
    public LevelService(ILevelRepository ILevelRepository) {
        this.ILevelRepository = this.ILevelRepository;
    }

    public Level updateLevel(Level level) {
        return ILevelRepository.save(level);
    }
}
