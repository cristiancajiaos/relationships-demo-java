package com.example.relationshipsdemo.service;

import com.example.relationshipsdemo.dto.BookDto;
import com.example.relationshipsdemo.entity.Book;
import com.example.relationshipsdemo.exception.BookNotFoundException;
import com.example.relationshipsdemo.mapper.BookMapper;
import com.example.relationshipsdemo.repository.BookDepository;
import java.util.Optional;
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

  @Override
  public BookDto getBookById(Long id) throws BookNotFoundException {
    Optional<Book> foundBook = bookDepository.findById(id);
    if (foundBook.isEmpty()) {
      throw new BookNotFoundException("Book with id " + id + " not found");
    }
    return BookMapper.mapToBookDto(foundBook.get());
  }
}
