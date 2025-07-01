package com.example.relationshipsdemo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "book")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long bookId;

  @Column(name = "book_name")
  private String bookName;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "book")
  @JsonManagedReference
  private Story story;

  @Column(name = "created")
  @CreationTimestamp
  private Timestamp created;

  @Column(name = "updated")
  @UpdateTimestamp
  private Timestamp updated;

  public Book() {
  }

  public Book(Long bookId, String bookName, Story story, Timestamp created, Timestamp updated) {
    this.bookId = bookId;
    this.bookName = bookName;
    this.story = story;
    this.created = created;
    this.updated = updated;
  }

  public Long getBookId() {
    return bookId;
  }

  public void setBookId(Long bookId) {
    this.bookId = bookId;
  }

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public Story getStory() {
    return story;
  }

  public void setStory(Story story) {
    this.story = story;
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
