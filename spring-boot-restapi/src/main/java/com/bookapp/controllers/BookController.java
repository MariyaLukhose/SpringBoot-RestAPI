package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.models.Book;
import com.bookapp.service.BookService;

@RestController
@RequestMapping("book-restapi")
public class BookController {
	@Autowired
	BookService bookService;
	//http://localhost:8080/book-restapi/hello
	@GetMapping("/hello")
	public String sayHello() {
		return "Welcome to RESTAPI";
	}
	//http://localhost:8080/book-restapi/book-by-id/10
	@GetMapping("/book-by-id/{bookid}")
	public Book getBookById(@PathVariable int bookid){
		return bookService.getById(bookid);
	}
	//http://localhost:8080/book-restapi/book-by-author/Kathy
	@GetMapping("/book-by-author/{author}")
	public List<Book>  getBooksbyAuthor(@PathVariable String author){
		return bookService.getBooksByAuthor(author);
	}
	//http://localhost:8080/book-restapi/book-by-category/?category=Fiction  or more usev &
	@GetMapping("/book-by-category")
	public List<Book>  getBooksbyCategory(@RequestParam String category){
		return bookService.getBooksByCategory(category);
	}
	
}
