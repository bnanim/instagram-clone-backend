package com.app.instagramclonebackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "posts")

// Mapping entity fields to Database

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "caption", length = Integer.MAX_VALUE)
    private String caption;

    @Column(name = "image_url", length = Integer.MAX_VALUE)
    private String imageUrl;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "post")
    private Set<Like> likes = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    // Add and remove comments
    public void addComment(Comment comment){
        this.comments.add(comment);
        comment.setPost(this);
    }
    public void removeComment(Comment comment){
        this.comments.remove(comment);
        comment.setPost(null);
    }


    // Add and remove likes
    public void addLike(Like like){
        this.likes.add(like);
        like.setPost(this);
    }
    public void removeLike(Like like){
        this.likes.remove(like);
        like.setPost(null);
    }

}