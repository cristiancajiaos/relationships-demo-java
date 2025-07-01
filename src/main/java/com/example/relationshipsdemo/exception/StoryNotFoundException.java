package com.example.relationshipsdemo.exception;

public class StoryNotFoundException extends Exception {

  public static final Long serialVersionUID = 1L;

  public StoryNotFoundException() {
  }

  public StoryNotFoundException(String message) {
    super(message);
  }
}
