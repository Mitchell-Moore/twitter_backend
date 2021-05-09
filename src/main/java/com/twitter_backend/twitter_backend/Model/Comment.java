package com.twitter_backend.twitter_backend.Model;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "commentId")
    private Integer commentId;
    private String comment;
    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne()
    @JoinColumn(name="post_Id")
    private Post post;

    protected Comment(){}

    public Comment(Integer commentId, String comment, User user, Post post) {
        this.commentId = commentId;
        this.comment = comment;
        this.user = user;
        this.post = post;
    }


    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
