package fr.aston.snipcave.snipcave.service;

import fr.aston.snipcave.snipcave.dto.in.PostRequest;
import fr.aston.snipcave.snipcave.dto.out.PostResponse;
import fr.aston.snipcave.snipcave.exceptions.PostNotFoundException;
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

    public void save(PostRequest postRequest) {
        postRepository.save(postMapper.map(postRequest, authService.getCurrentUser()));
    }

    //public void addPost(PostRequest postRequest){
    // posRepository.save(postMapper.map(postRequest,authService.getCurrentUser()));
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

    //public void deletePost(PostRequest postRequest){
    //   postRepository.deleteById(postRequest.getId());
    // }

}
