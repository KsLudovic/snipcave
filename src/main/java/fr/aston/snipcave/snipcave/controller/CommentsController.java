package fr.aston.snipcave.snipcave.controller;

import fr.aston.snipcave.snipcave.dto.CommentsDto;
import fr.aston.snipcave.snipcave.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/api/comments")
@AllArgsConstructor
public class CommentsController {

    private CommentService commentService;

    @GetMapping("/by-post/{postId}")
    public ResponseEntity<List<CommentsDto>> getAllCommentsForPost(@PathVariable Long postId) {
        return ResponseEntity.status(OK)
                .body(commentService.getAllCommentsForPost(postId));
    }

    @GetMapping("/by-user/{username}")
    public ResponseEntity<List<CommentsDto>> getCommentsByUser(@PathVariable String username){
        System.out.println(username);
        return ResponseEntity.status(OK)
                .body(commentService.getCommentsByUser(username));
    }

}