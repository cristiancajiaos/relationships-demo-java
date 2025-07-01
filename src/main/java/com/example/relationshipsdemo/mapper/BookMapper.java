package com.example.relationshipsdemo.mapper;

import com.example.relationshipsdemo.dto.BookDto;
import com.example.relationshipsdemo.entity.Book;

public class BookMapper {

  public static BookDto mapToBookDto(Book book) {
    return new BookDto(book.getBookId(), book.getBookName(), book.getStory(), book.getCreated(), book.getUpdated());
  }

  public static Book mapToBook(BookDto bookDto) {
    return new Book(bookDto.getBookId(), bookDto.getBookName(), bookDto.getStory(), bookDto.getCreated(), bookDto.getUpdated());
  }

}
