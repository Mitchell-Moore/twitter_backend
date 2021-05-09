package com.twitter_backend.twitter_backend.Model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "postId")
    private Integer postId;
    @Column(name = "postText")
    private String postText;
    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;

    protected Post(){}
    public Post(Integer postId, String postText, User user){
        this.postId = postId;
        this.postText = postText;
        this.user = user;
    }
    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }
    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
