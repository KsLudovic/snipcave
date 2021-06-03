package fr.aston.snipcave.snipcave.mapper;

import fr.aston.snipcave.snipcave.dto.PlayDto;
import fr.aston.snipcave.snipcave.model.Games;
import fr.aston.snipcave.snipcave.model.Play;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlayMapper {

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "gameInProgress",expression = "java(java.time.Instant.now())")
    @Mapping(target = "xpWon",source = "PlayDto.xpWon")
    @Mapping(target = "nbPlayers",source = "PlayDto.nbPlayers")
    @Mapping(target = "game",source = "game")
    Play map(PlayDto playDto, Games game);

    @Mapping(target = "gameName",expression = "java(play.getGames().getGamesName())")
    @Mapping(target = "createdDate",expression = "java(java.time.Instant.now())")
    PlayDto mapToDto(Play play);
}
