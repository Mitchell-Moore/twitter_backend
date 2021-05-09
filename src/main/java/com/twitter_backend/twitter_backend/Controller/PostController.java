package com.twitter_backend.twitter_backend.Controller;

import com.twitter_backend.twitter_backend.Model.Post;
import com.twitter_backend.twitter_backend.Model.User;
import com.twitter_backend.twitter_backend.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/createPost")
    public Post createPost(@RequestBody Post newPost) {
        Post createdPost = postService.createPost(newPost);
        if(createdPost != null){
            return createdPost;
        }
        return null;
    }

    @GetMapping("/fetchPostByPostId/{postId}")
    public Post fetchPostByPostId(@PathVariable int postId) {
        return postService.fetchPostByPostId(postId);
    }

    @GetMapping("/fetchPostsByUserId/{userId}")
    public Set<Post> fetchPostsByUserId(@PathVariable int userId) {
        return postService.fetchPostsByUserId(userId);
    }
}
