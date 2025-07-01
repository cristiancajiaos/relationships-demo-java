package com.example.relationshipsdemo.controller;

import com.example.relationshipsdemo.dto.BookDto;
import com.example.relationshipsdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/book")
public class BookController {

  @Autowired
  private BookService bookService;

  @PostMapping(value = "/save")
  public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
    BookDto createdBook = bookService.createBook(bookDto);
    return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
  }

}
