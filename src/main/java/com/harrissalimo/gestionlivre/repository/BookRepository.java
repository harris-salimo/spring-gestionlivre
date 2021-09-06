package com.harrissalimo.gestionlivre.repository;

import com.harrissalimo.gestionlivre.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
