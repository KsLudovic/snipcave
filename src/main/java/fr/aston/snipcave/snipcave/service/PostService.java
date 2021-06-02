package fr.aston.snipcave.snipcave.service;

import fr.aston.snipcave.snipcave.dto.PostRequest;
import fr.aston.snipcave.snipcave.dto.PostResponse;
import fr.aston.snipcave.snipcave.exceptions.PostNotFoundException;
import fr.aston.snipcave.snipcave.mapper.PostMapper;
import fr.aston.snipcave.snipcave.model.Post;
import fr.aston.snipcave.snipcave.model.User;
import fr.aston.snipcave.snipcave.repository.IPostRepository;
import fr.aston.snipcave.snipcave.repository.IUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class PostService {

    private final IPostRepository postRepository;
    private final IUserRepository userRepository;
    private final AuthService authService;
    private final PostMapper postMapper;

    public void save(PostRequest postRequest) {
        Post post = postRepository.findByName(postRequest.getPostName())
                .orElseThrow(() -> new PostNotFoundException(postRequest.getPostName()));
        postRepository.save(postMapper.map(postRequest, authService.getCurrentUser()));
    }

    //public void addPost(PostRequest postRequest){
    // posRepository.save(postMapper.map(postRequest,authService.getCurrentUser()));}

    //public void putPost(PostRequest postRequest){
    // Post post=postRepository.findByName(postRequest.getPostName())
    //                         .orElseThrow(()-> new PostFoundException(postRequest.getPostName()));
    // PostResponse postResponse = postMapper.mapToDto(post);
    // postRepository.save(postMapper.map(postResponse,authService.getCurrentUser()));}

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id.toString()));
        return postMapper.mapToDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return postRepository.findByUser(user)
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }
}
