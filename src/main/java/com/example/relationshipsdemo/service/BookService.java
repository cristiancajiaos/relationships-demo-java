package com.example.relationshipsdemo.service;

import com.example.relationshipsdemo.dto.BookDto;
import com.example.relationshipsdemo.exception.BookNotFoundException;

public interface BookService {

  BookDto createBook(BookDto bookDto);

  BookDto getBookById(Long id) throws BookNotFoundException;

}
