package com.app.instagramclonebackend.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")

// Mapping entity fields to Database

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "bio", length = Integer.MAX_VALUE)
    private String bio;

    @Column(name = "profile_image_url", length = Integer.MAX_VALUE)
    private String profileImageUrl;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private Set<Comment> comments = new LinkedHashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private Set<Like> likes = new LinkedHashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private Set<Post> posts = new LinkedHashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private Set<Story> stories = new LinkedHashSet<>();


    // Add and remove stories
    public void addStory(Story story){
        this.stories.add(story);
        story.setUser(this);
    }
    public void removeStory(Story story){
        this.stories.remove(story);
        story.setUser(null);
    }


    // Add and remove posts
    public void addPost(Post post){
        this.posts.add(post);
        post.setUser(this);
    }
    public void removePost(Post post){
        this.posts.remove(post);
        post.setUser(null);
    }


    // Add and remove comments
    public void addComment(Comment comment){
        this.comments.add(comment);
        comment.setUser(this);
    }
    public void removeComment(Comment comment){
        this.comments.remove(comment);
        comment.setUser(null);
    }


    // Add and remove likes
    public void addLike(Like like){
        this.likes.add(like);
        like.setUser(this);
    }
    public void removeLike(Like like){
        this.likes.remove(like);
        like.setUser(null);
    }
}