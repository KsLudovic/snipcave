package fr.aston.snipcave.snipcave.service;

import fr.aston.snipcave.snipcave.exceptions.PostNotFoundException;
import fr.aston.snipcave.snipcave.model.Post;
import fr.aston.snipcave.snipcave.model.User;
import fr.aston.snipcave.snipcave.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {


    private final IPostRepository postRepository;

    @Autowired
    public PostService(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> findAllPost() {
        return postRepository.findAll();
    }

    public Post updatePost(Post post) {
        return postRepository.save(post);
    }

    public Post findPostByUser(User user) {
        return postRepository.findByUser(user)
                .orElseThrow(() -> new PostNotFoundException("There is no post edited by " + user.getUsername() + "."));
    }

    public Post findPostByName(String name){
        return postRepository.findByName(name)
                .orElseThrow(() -> new PostNotFoundException("No post was found having: "+name+" as name."));
    }

    public void deletePost(Long id){
        postRepository.deletePostById(id);
    }
}
