package com.twitter_backend.twitter_backend.DAO;


import com.twitter_backend.twitter_backend.Model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostDao extends CrudRepository<Post, Integer> {
}
