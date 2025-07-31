package com.example.Personal.Library.Service.Repository;

import com.example.Personal.Library.Service.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
}
