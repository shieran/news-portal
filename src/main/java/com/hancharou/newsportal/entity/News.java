package com.hancharou.newsportal.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class News {

    @Id
    @GeneratedValue
    private Long id;
    private String newsName;
    private String newsDetails;
    @OneToMany(targetEntity = Comment.class, mappedBy = "news", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "news-comment")
    private List<Comment> comments;
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    @JsonBackReference(value = "user-news")
    private User newsAuthor;

    public News() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNewsName() {
        return newsName;
    }

    public void setNewsName(String newsName) {
        this.newsName = newsName;
    }

    public String getNewsDetails() {
        return newsDetails;
    }

    public void setNewsDetails(String newsDetails) {
        this.newsDetails = newsDetails;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User getNewsAuthor() {
        return newsAuthor;
    }

    public void setNewsAuthor(User newsAuthor) {
        this.newsAuthor = newsAuthor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return Objects.equals(id, news.id) &&
                Objects.equals(newsName, news.newsName) &&
                Objects.equals(newsDetails, news.newsDetails) &&
                Objects.equals(comments, news.comments) &&
                Objects.equals(newsAuthor, news.newsAuthor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", newsName='" + newsName + '\'' +
                ", newsDetails='" + newsDetails + '\'' +
                ", comments=" + comments +
                ", newsAuthor=" + newsAuthor +
                '}';
    }
}
