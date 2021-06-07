package fr.aston.snipcave.snipcave.service;

import fr.aston.snipcave.snipcave.dto.LevelDto;
import fr.aston.snipcave.snipcave.model.Level;
import fr.aston.snipcave.snipcave.repository.ILevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevelService {

    private ILevelRepository levelRepository;


    @Autowired
    public LevelService(ILevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    public Level updateLevel(Level level) {
        return levelRepository.save(level);
    }

    public void save(LevelDto levelDto) {
        levelRepository.save(this.map(levelDto));
    }


    public Level map(LevelDto levelDto){
        return new Level(levelDto.getId(), levelDto.getLevel(), levelDto.getExperienceMax());

    }

    public LevelDto mapToDto(Level level){
        return new LevelDto(level.getLevelId(),level.getLevel(),level.getExperienceMax());


    }
}
