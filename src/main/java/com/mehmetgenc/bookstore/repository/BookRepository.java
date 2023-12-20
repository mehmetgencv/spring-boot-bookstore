package com.mehmetgenc.bookstore.repository;

import com.mehmetgenc.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
    /*
    * Uygulama ile veritabani arasindaki kopru
    * */
}
