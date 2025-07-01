package com.example.relationshipsdemo.service;

import com.example.relationshipsdemo.dto.BookDto;
import com.example.relationshipsdemo.entity.Book;
import com.example.relationshipsdemo.mapper.BookMapper;
import com.example.relationshipsdemo.repository.BookDepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

  @Autowired
  private BookDepository bookDepository;

  @Override
  public BookDto createBook(BookDto bookDto) {
    Book book = BookMapper.mapToBook(bookDto);
    Book createdBook = bookDepository.save(book);
    return BookMapper.mapToBookDto(createdBook);
  }
}
