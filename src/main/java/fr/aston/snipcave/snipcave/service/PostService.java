package fr.aston.snipcave.snipcave.service;

import fr.aston.snipcave.snipcave.dto.in.PostRequest;
import fr.aston.snipcave.snipcave.dto.out.PostResponse;
import fr.aston.snipcave.snipcave.exceptions.PostNotFoundException;
import fr.aston.snipcave.snipcave.model.Post;
import fr.aston.snipcave.snipcave.model.User;
import fr.aston.snipcave.snipcave.model.Vote;
import fr.aston.snipcave.snipcave.repository.ICommentRepository;
import fr.aston.snipcave.snipcave.repository.IPostRepository;
import fr.aston.snipcave.snipcave.repository.IUserRepository;
import fr.aston.snipcave.snipcave.repository.IVoteRepository;
import fr.aston.snipcave.snipcave.utils.VoteType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class PostService {

    private final IPostRepository postRepository;
    private final IUserRepository userRepository;
    @Autowired
    private final AuthService authService;
    @Autowired
    private IVoteRepository voteRepository;
    @Autowired
    private ICommentRepository commentRepository;

    public void save(PostRequest postRequest) {
        postRepository.save(this.map(postRequest));
    }

    //public void addPost(PostRequest postRequest){
    // postRepository.save(this.map(postRequest,authService.getCurrentUser()));
    // }

    //public void putPost(PostRequest postRequest){
    // Post post=postRepository.findByName(postRequest.getPostName())
    //                         .orElseThrow(()-> new PostFoundException(postRequest.getPostName()));
    // PostResponse postResponse = postMapper.mapToDto(post);
    // postResponse.url=postRequest.url;
    // postResponse.description=postRequest.description;
    // postResponse.script=postRequest.script;
    // postRepository.save(postMapper.map(postResponse,authService.getCurrentUser()));}

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id.toString()));
        return this.mapToDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return postRepository.findByUser(user)
                .stream()
                .map(this::mapToDto)
                .collect(toList());
    }

    //public void deletePost(PostRequest postRequest){
    //   postRepository.deleteById(postRequest.getId());
    // }

    public Post map(PostRequest postRequest){
        return new Post(postRequest.getPostId(),
                postRequest.getDescription(),
                postRequest.getUrl(),postRequest.getPostName(),
                postRequest.getInstant(),postRequest.getScript(),0,postRequest.getUser());
    }

    public PostResponse mapToDto(Post post){
        return new PostResponse(post.getPostId(),
                post.getName(),
                post.getUrl(),
                post.getDescription(),
                post.getUser().getUsername(),
                voteCount(post),
                commentCount(post),
                isPostLiked(post),
                isPostDisliked(post));



    }


    // Function relative
    Integer commentCount(Post post) {
        return commentRepository.findByPost(post).size();
    }

    Integer voteCount(Post post){
        return voteRepository.findByPost(post).size();
    }

    //String getDuration(Post post) {
    //    return TimeAgo.using(post.getCreatedDate().toEpochMilli());
    //}

    boolean isPostLiked(Post post) {
        return checkVoteType(post, VoteType.LIKE);
    }

    boolean isPostDisliked(Post post) {
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
