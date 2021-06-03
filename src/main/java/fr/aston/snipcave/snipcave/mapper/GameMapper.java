package fr.aston.snipcave.snipcave.mapper;

import fr.aston.snipcave.snipcave.dto.GamesDto;
import fr.aston.snipcave.snipcave.model.Games;
import fr.aston.snipcave.snipcave.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GameMapper {

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "name",source="gamesDto.name")
    @Mapping(target = "multiplayer",source = "gamesDto.multiplayer")
    @Mapping(target = "numberMaxPlayer",source = "gamesDto.numberMaxPlayer")
    @Mapping(target = "post",source = "post")
    Games map(GamesDto gamesDto, Post post);

    @Mapping(target = "postId",expression = "java(games.getPost().getPostId())")
    GamesDto mapToDto(Games games);
}
