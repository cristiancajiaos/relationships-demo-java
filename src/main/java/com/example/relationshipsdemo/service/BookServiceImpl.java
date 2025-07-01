package com.example.relationshipsdemo.service;

import com.example.relationshipsdemo.dto.BookDto;
import com.example.relationshipsdemo.entity.Book;
import com.example.relationshipsdemo.exception.BookNotFoundException;
import com.example.relationshipsdemo.mapper.BookMapper;
import com.example.relationshipsdemo.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

  @Autowired
  private BookRepository bookRepository;

  @Override
  public BookDto createBook(BookDto bookDto) {
    Book book = BookMapper.mapToBook(bookDto);
    Book createdBook = bookRepository.save(book);
    return BookMapper.mapToBookDto(createdBook);
  }

  @Override
  public BookDto getBookById(Long id) throws BookNotFoundException {
    Optional<Book> foundBook = bookRepository.findById(id);
    if (foundBook.isEmpty()) {
      throw new BookNotFoundException("Book with id " + id + " not found");
    }
    return BookMapper.mapToBookDto(foundBook.get());
  }

  @Override
  public List<BookDto> getBooks() {
    List<Book> books = bookRepository.findAll();
    return books.stream().map((bk) -> BookMapper.mapToBookDto(bk)).collect(Collectors.toList());
  }

  @Override
  public BookDto updateBook(BookDto bookDto) throws BookNotFoundException {
    Optional<Book> foundBook = bookRepository.findById(bookDto.getBookId());
    if (foundBook.isEmpty()) {
      throw new BookNotFoundException("Book with id " + bookDto.getBookId() + " not found");
    }
    Book bookToUpdate = foundBook.get();
    bookToUpdate.setBookName(bookDto.getBookName());
    Book updatedBook = bookRepository.save(bookToUpdate);
    return BookMapper.mapToBookDto(updatedBook);
  }

  @Override
  public BookDto deleteBook(Long id) throws BookNotFoundException {
    Optional<Book> foundBook = bookRepository.findById(id);
    if (foundBook.isEmpty()) {
      throw new BookNotFoundException("Book with ID " + id + " not found");
    }
    Book deletedBook = foundBook.get();
    bookRepository.deleteById(id);
    return BookMapper.mapToBookDto(deletedBook);
  }
}
