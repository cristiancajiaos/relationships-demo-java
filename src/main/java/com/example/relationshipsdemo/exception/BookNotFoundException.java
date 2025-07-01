package com.example.relationshipsdemo.exception;

public class BookNotFoundException extends Exception {

  public static final Long serialVersionUID = 1L;

  public BookNotFoundException() {
  }

  public BookNotFoundException(String message) {
    super(message);
  }
}
