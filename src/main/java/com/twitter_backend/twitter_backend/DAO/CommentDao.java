package com.twitter_backend.twitter_backend.DAO;

import com.twitter_backend.twitter_backend.Model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentDao  extends CrudRepository<Comment, Integer> {
}
