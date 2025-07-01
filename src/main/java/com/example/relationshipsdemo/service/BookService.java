package com.example.relationshipsdemo.service;

import com.example.relationshipsdemo.dto.BookDto;
import com.example.relationshipsdemo.exception.BookNotFoundException;
import java.util.List;

public interface BookService {

  BookDto createBook(BookDto bookDto);

  BookDto getBookById(Long id) throws BookNotFoundException;

  List<BookDto> getBooks();

  BookDto updateBook(BookDto bookDto) throws BookNotFoundException;

}
