package com.example.Library.Management.repository;

import com.example.Library.Management.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
