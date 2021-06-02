package fr.aston.snipcave.snipcave.mapper;

import fr.aston.snipcave.snipcave.dto.PostRequest;
import fr.aston.snipcave.snipcave.dto.PostResponse;
import fr.aston.snipcave.snipcave.model.Post;
import fr.aston.snipcave.snipcave.model.User;
import fr.aston.snipcave.snipcave.model.Vote;
import fr.aston.snipcave.snipcave.repository.ICommentRepository;
import fr.aston.snipcave.snipcave.repository.IVoteRepository;
import fr.aston.snipcave.snipcave.service.AuthService;
import fr.aston.snipcave.snipcave.utils.VoteType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
@Mapper(componentModel = "spring")
public abstract class PostMapper {

    @Autowired
    private ICommentRepository commentRepository;
    @Autowired
    private IVoteRepository voteRepository;
    @Autowired
    private AuthService authService;


    @Mapping(target = "posted", expression = "java(java.time.Instant.now())")
    @Mapping(target = "description", source = "postRequest.description")
    @Mapping(target = "totalVote", constant = "0")
    @Mapping(target = "user", source = "user")
    public abstract Post map(PostRequest postRequest, User user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "userName", source = "user.username")
    @Mapping(target = "commentCount", expression = "java(commentCount(post))")
    @Mapping(target = "duration", expression = "java(getDuration(post))")
    @Mapping(target = "like", expression = "java(isPostUpVoted(post))")
    @Mapping(target = "dislike", expression = "java(isPostDownVoted(post))")
    public abstract PostResponse mapToDto(Post post);

    Integer commentCount(Post post) {
        return commentRepository.findByPost(post).size();
    }

    // one dependency missing
   // String getDuration(Post post) {
   //     return TimeAgo.using(post.getCreatedDate().toEpochMilli());
    //}

    boolean isLiked(Post post) {
        return checkVoteType(post, VoteType.LIKE);
    }

    boolean isDisliked(Post post) {
        return checkVoteType(post, VoteType.DISLIKE);
    }

    private boolean checkVoteType(Post post, VoteType voteType) {
        if (authService.isLoggedIn()) {
            Optional<Vote> voteForPostByUser =
                    voteRepository.findTopByPostAndUserOrderByVoteIdDesc(post,
                            authService.getCurrentUser());
            return voteForPostByUser.filter(vote -> vote.getVoteType().equals(voteType))
                    .isPresent();
        }
        return false;
    }

}