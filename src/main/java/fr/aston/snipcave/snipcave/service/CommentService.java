package fr.aston.snipcave.snipcave.service;

import fr.aston.snipcave.snipcave.exceptions.PostNotFoundException;
import fr.aston.snipcave.snipcave.model.Comment;
import fr.aston.snipcave.snipcave.model.User;
import fr.aston.snipcave.snipcave.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private static final String POST_URL = "";
    private final ICommentRepository ICommentRepository;


    @Autowired
    public CommentService(ICommentRepository ICommentRepository) {
        this.ICommentRepository = ICommentRepository;
    }

    public Comment addComment(Comment comment) {
        return ICommentRepository.save(comment);
    }

    public List<Comment> findAllComment() {
        return ICommentRepository.findAll();
    }

    public Comment updateComment(Comment comment) {
        return ICommentRepository.save(comment);
    }

    public Comment findCommentByUser(User user) {
        return ICommentRepository.findByUser(user)
                .orElseThrow(() -> new PostNotFoundException("There is no comment edited by " + user.getUsername() + "."));
    }
    public void deleteComment(Long id){
        ICommentRepository.deleteCommentById(id);
    }

}
