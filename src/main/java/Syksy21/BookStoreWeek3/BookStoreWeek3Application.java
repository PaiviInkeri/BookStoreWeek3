package Syksy21.BookStoreWeek3;

import org.slf4j.Logger;	
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Syksy21.BookStoreWeek3.domain.Book;
import Syksy21.BookStoreWeek3.domain.BookRepository;
import Syksy21.BookStoreWeek3.domain.Category;
import Syksy21.BookStoreWeek3.domain.CategoryRepository;


@SpringBootApplication
public class BookStoreWeek3Application {
	private static final Logger log = LoggerFactory.getLogger(BookStoreWeek3Application.class);

	public static void main(String[] args) {
		SpringApplication.run(BookStoreWeek3Application.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of students");
			
			crepository.save(new Category("Detective Story"));
			crepository.save(new Category("Drama"));
			crepository.save(new Category("Biography"));
			crepository.save(new Category("Suspense"));
			crepository.save(new Category("Romance"));
				
			Book book1 = new Book("Loistava ystäväni", "Elena Ferrante", 2016, "9789510414699", 16.99, crepository.findByName("Drama").get(0));
			Book book2 = new Book("Uuden nimen tarina", "Elena Ferrante", 2017, "ISBN-404088", 16.99, crepository.findByName("Drama").get(0));
			Book book3 = new Book("Ne jotka lähtevät ja ne jotka jäävät", "Elena Ferrante", 2018, "ISBN-667788", 18.99, crepository.findByName("Drama").get(0));
					
			repository.save(book1);
			repository.save(book2);
			repository.save(book3);
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			
			
		};	
	}

}
