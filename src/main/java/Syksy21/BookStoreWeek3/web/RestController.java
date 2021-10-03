package Syksy21.BookStoreWeek3.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


import Syksy21.BookStoreWeek3.domain.Book;
import Syksy21.BookStoreWeek3.domain.BookRepository;
import Syksy21.BookStoreWeek3.domain.CategoryRepository;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository crepository;
	
	@GetMapping("/books") 
	public List<Book> booklistRest() {
		System.out.println("RestController: /books");
		return (List<Book>) repository.findAll();
	}
}
