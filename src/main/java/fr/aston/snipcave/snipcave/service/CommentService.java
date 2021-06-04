package fr.aston.snipcave.snipcave.service;

import fr.aston.snipcave.snipcave.dto.CommentsDto;
import fr.aston.snipcave.snipcave.exceptions.PostNotFoundException;
import fr.aston.snipcave.snipcave.model.Comment;
import fr.aston.snipcave.snipcave.model.Post;
import fr.aston.snipcave.snipcave.model.User;
import fr.aston.snipcave.snipcave.repository.ICommentRepository;
import fr.aston.snipcave.snipcave.repository.IPostRepository;
import fr.aston.snipcave.snipcave.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class CommentService {
    //private static final String POST_URL = "";
    private final IPostRepository postRepository;
    private final IUserRepository userRepository;
    private final AuthService authService;
    private final ICommentRepository commentRepository;
    //private final MailService mailService;



    public void save(CommentsDto commentsDto) {
        Post post = postRepository.findById(commentsDto.getPost().getPostId())
                .orElseThrow(() -> new PostNotFoundException(commentsDto.getPost().getPostId().toString()));
        Comment comment = this.map(commentsDto);
        commentRepository.save(comment);

        //String message = mailContentBuilder.build(authService.getCurrentUser() + " posted a comment on your post." + POST_URL);
        //sendCommentNotification(message, post.getUser());
    }

   // private void sendCommentNotification(String message, User user) {
   //     mailService.sendMail(new NotificationEmail(user.getUsername() + " Commented on your post", user.getEmail(), message));
    //}

    public List<CommentsDto> getAllCommentsForPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException(postId.toString()));
        return commentRepository.findByPost(post)
                .stream()
                .map(this::mapToDto).collect(toList());
    }

    public List<CommentsDto> getAllCommentsForUser(String userName) {
        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException(userName));
        return commentRepository.findAllByUser(user)
                .stream()
                .map(this::mapToDto)
                .collect(toList());
    }

    public Comment map(CommentsDto commentsDto){
        return new Comment(commentsDto.getId(),
                commentsDto.getText(),
                commentsDto.getPost(),
                commentsDto.getCreatedDate(),
                commentsDto.getUser());
    }

    public CommentsDto mapToDto(Comment comment){
        return new CommentsDto(comment.getId(),
                comment.getPost(),
                comment.getCreatedDate(),
                comment.getText(),
                comment.getUser());

    }

}