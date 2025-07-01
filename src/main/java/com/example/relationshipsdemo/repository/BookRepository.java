package com.example.relationshipsdemo.repository;

import com.example.relationshipsdemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
