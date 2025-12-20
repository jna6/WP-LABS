package mk.ukim.finki.wp.jan2024g2.model;

import java.time.LocalDate;
import java.util.List;

public class Post {

    public Post() {
    }

    public Post(String title, String content, LocalDate dateCreated, PostType postType, List<Tag> tags) {
        this.title = title;
        this.content = content;
        this.dateCreated = dateCreated;
        this.postType = postType;
        this.tags = tags;
        this.likes = 0;
    }

    private Long id;

    private String title;

    private String content;

    private LocalDate dateCreated;

    private PostType postType;

    private List<Tag> tags;

    private Integer likes = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}
