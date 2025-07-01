package com.example.relationshipsdemo.dto;

import com.example.relationshipsdemo.entity.Story;
import java.sql.Timestamp;

public class BookDto {

  private int bookId;
  private String bookName;
  private Story story;
  private Timestamp created;
  private Timestamp updated;

  public BookDto() {
  }

  public BookDto(int bookId, String bookName, Story story, Timestamp created,
      Timestamp updated) {
    this.bookId = bookId;
    this.bookName = bookName;
    this.story = story;
    this.created = created;
    this.updated = updated;
  }

  public int getBookId() {
    return bookId;
  }

  public void setBookId(int bookId) {
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
