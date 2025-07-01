package com.example.relationshipsdemo.dto;

import com.example.relationshipsdemo.entity.Book;
import java.sql.Time;
import java.sql.Timestamp;

public class StoryDto {

  private Long storyId;
  private String storyName;
  private Book book;
  private Timestamp created;
  private Timestamp updated;

  public StoryDto() {
  }

  public StoryDto(Long storyId, String storyName, Book book, Timestamp created,
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
