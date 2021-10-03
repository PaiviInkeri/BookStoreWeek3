package Syksy21.BookStoreWeek3.web;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Syksy21.BookStoreWeek3.domain.Book;
import Syksy21.BookStoreWeek3.domain.BookRepository;
import Syksy21.BookStoreWeek3.domain.CategoryRepository;


@Controller
public class BookController {
	
	//Spring-annotaatio, tuo rajapinnan luokan käyttöön
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository crepository;
	
	@GetMapping("/bookstore") 
	public String listBooks(Model model) {
		model.addAttribute("books", repository.findAll());	//avain books, arvo repositoryn findAll-metodilla generoima lista tietokantataulusta
		
		return "bookstore";
	}
	
	//poistettavan kirjan id välitetään end pointissa PathVariable-muodossa. Repository-luokan metodi poistaa
	//kirjan id:n perusteella
	@GetMapping(value = "/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
        return "redirect:../bookstore";
    }    
	
	//metodi kuuntelee kun bookstore.html:ssä klikataan /add end pointiin johtavaa linkkiä
	//metodi luo tyhjän Book-olion, joka viedään addBook.html-thymeleafille
	//lisäksi addBookille viedään lista kategorioista
	@GetMapping(value = "/add")	
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addBook";
	}
	
	@PostMapping(value = "/save")
	public String saveBook(@Valid Book book, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "editBook";
		}
		repository.save(book);
		return "redirect:bookstore";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		Optional<Book> book = repository.findById(bookId);
		model.addAttribute("book", book);
		model.addAttribute("categories", crepository.findAll());
		return "editBook";
	}
	

}

