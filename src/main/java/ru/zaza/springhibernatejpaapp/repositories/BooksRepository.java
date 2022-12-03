package ru.zaza.springhibernatejpaapp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zaza.springhibernatejpaapp.models.Book;
import ru.zaza.springhibernatejpaapp.models.Person;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
    List<Book> findByOwner(Person owner);

    List<Book> findBooksByTitleStartingWith(String title);
}
