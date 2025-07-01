package com.example.relationshipsdemo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "story")
public class Story {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long storyId;

  @Column(name = "story_name")
  private String storyName;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "book_id")
  @JsonBackReference
  private Book book;

  @Column(name = "created")
  @CreationTimestamp
  private Timestamp created;

  @Column(name = "updated")
  @UpdateTimestamp
  private Timestamp updated;

  public Story() {
  }

  public Story(Long storyId, String storyName, Book book, Timestamp created,
      Timestamp updated) {
    this.storyId = storyId;
    this.storyName = storyName;
    this.book = book;
    this.created = created;
    this.updated = updated;
  }

  public Long getStoryId() {
    return storyId;
  }

  public void setStoryId(Long storyId) {
    this.storyId = storyId;
  }

  public String getStoryName() {
    return storyName;
  }

  public void setStoryName(String storyName) {
    this.storyName = storyName;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public Timestamp getCreated() {
    return created;
  }

  public void setCreated(Timestamp created) {
    this.created = created;
  }

  public Timestamp getUpdated() {
    return updated;
  }

  public void setUpdated(Timestamp updated) {
    this.updated = updated;
  }
}
