package com.twitter_backend.twitter_backend.Service;

import com.twitter_backend.twitter_backend.DAO.CommentDao;
import com.twitter_backend.twitter_backend.Model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("CommentService")
public class CommentService {
    @Autowired
    CommentDao commentDao;

    public Comment createComment(Comment newComment) {
        try{
            Comment createdComment = commentDao.save(newComment);
            return createdComment;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Comment fetchCommentByCommentId(int commentId) {
        Optional<Comment> commentResponse = commentDao.findById(commentId);
        if(commentResponse.isEmpty()){
            return null;
        }
        else{
            return commentResponse.get();
        }
    }
}
