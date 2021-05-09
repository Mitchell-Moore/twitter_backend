package com.twitter_backend.twitter_backend.Service;

import com.twitter_backend.twitter_backend.DAO.PostDao;
import com.twitter_backend.twitter_backend.Model.Post;
import com.twitter_backend.twitter_backend.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("PostService")
public class PostService {
    @Autowired
    PostDao postDao;

    public Post createPost(Post post) {
        try{
            Post createdPost = postDao.save(post);
            return createdPost;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Post fetchPostByPostId(int postId) {
        Optional<Post> postResponse = postDao.findById(postId);
        if(postResponse.isEmpty()){
            return null;
        }
        else{
            return postResponse.get();
        }
    }

    public Set<Post> fetchPostsByUserId(int userId) {
        Iterator<Post> postIterator = postDao.findAll().iterator();
        Set<Post> posts = new HashSet<Post>();
        while(postIterator.hasNext()){
            Post post = postIterator.next();
            if(post.getUser().getUserId() == userId){
                posts.add(post);
            }
        }
        return posts;
    }
}
