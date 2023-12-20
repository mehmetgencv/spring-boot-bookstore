package com.mehmetgenc.bookstore;

import com.mehmetgenc.bookstore.model.Book;
import com.mehmetgenc.bookstore.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	public final BookRepository bookRepository;

	public BookstoreApplication(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book1 = Book.builder()
				.name("Yuzuklerin Efendisi 1")
				.author("Tolkien")
				.price(10.0)
				.stock(10).build();
		Book book2 = Book.builder()
				.name("Yuzuklerin Efendisi 2")
				.author("Tolkien")
				.price(15.0)
				.stock(5).build();
		Book book3 = Book.builder()
				.name("Yuzuklerin Efendisi 3")
				.author("Tolkien")
				.price(20.0)
				.stock(1).build();
		bookRepository.saveAll(Arrays.asList(book1, book2, book3));
	}
}
