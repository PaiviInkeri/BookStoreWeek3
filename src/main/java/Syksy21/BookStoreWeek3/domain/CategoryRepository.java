package Syksy21.BookStoreWeek3.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	//findBy on allokoitu muodostamaan tietokantakysely jonkin attribuutin avulla.
	//Eli findBy-metodeja voi luoda ilman, että täytyy kirjoittaa
	//koodia ja tehdä sql-lausekkeita. Palauttavat listan.
	List<Category> findByName(String name);

}
