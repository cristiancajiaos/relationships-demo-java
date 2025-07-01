package com.example.relationshipsdemo.controller;

import com.example.relationshipsdemo.dto.BookDto;
import com.example.relationshipsdemo.exception.BookNotFoundException;
import com.example.relationshipsdemo.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @GetMapping(value = "/{id}")
  public ResponseEntity<BookDto> getBookById(@PathVariable("id") Long id) throws BookNotFoundException {
    try {
      BookDto foundBook = bookService.getBookById(id);
      return new ResponseEntity<>(foundBook, HttpStatus.OK);
    } catch (BookNotFoundException ex) {
      throw ex;
    }
  }

  @GetMapping(value = "/")
  public ResponseEntity<List<BookDto>> getBooks() {
    List<BookDto> books = bookService.getBooks();
    return new ResponseEntity<>(books, HttpStatus.OK);
  }

  @PutMapping(value = "/update")
  public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto)
      throws BookNotFoundException {
    try {
      BookDto updatedBook = bookService.updateBook(bookDto);
      return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    } catch (BookNotFoundException ex) {
      throw ex;
    }

  }



}
