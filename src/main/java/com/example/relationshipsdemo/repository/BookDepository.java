package com.example.relationshipsdemo.repository;

import com.example.relationshipsdemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDepository extends JpaRepository<Book, Long> {

}
