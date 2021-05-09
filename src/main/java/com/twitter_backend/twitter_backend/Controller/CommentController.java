package com.twitter_backend.twitter_backend.Controller;


import com.twitter_backend.twitter_backend.Model.Comment;
import com.twitter_backend.twitter_backend.Model.Post;
import com.twitter_backend.twitter_backend.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/createComment")
    public Comment createComment(@RequestBody Comment newComment) {
        Comment createdPost = commentService.createComment(newComment);
        if(createdPost != null){
            return createdPost;
        }
        return null;
    }

    @GetMapping("/fetchCommentByCommentId/{commentId}")
    public Comment fetchCommentByCommentId(@PathVariable int commentId) {
        return commentService.fetchCommentByCommentId(commentId);
    }

}
