package ru.zaza.springhibernatejpaapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zaza.springhibernatejpaapp.models.Book;
import ru.zaza.springhibernatejpaapp.models.Person;
import ru.zaza.springhibernatejpaapp.repositories.BooksRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BookService {

    private final BooksRepository booksRepository;

    @Autowired
    public BookService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    public List<Book> findAllPaginated(Integer page, Integer booksPerPage) {
        return booksRepository.findAll(PageRequest.of(page, booksPerPage)).getContent();
    }

    public List<Book> findAllSorted() {
        return booksRepository.findAll(Sort.by("year"));
    }

    public List<Book> findAllSortedPaginated(Integer page, Integer booksPerPage) {
        return booksRepository.findAll(PageRequest.of(page, booksPerPage, Sort.by("year"))).getContent();
    }

    public Book findOne(int id) {
        Optional<Book> foundBook = booksRepository.findById(id);
        return foundBook.orElse(null);
    }

    public List<Book> searchByTitle(String query) {
        return booksRepository.findBooksByTitleStartingWith(query);
    }

    @Transactional
    public void save(Book book) {
        booksRepository.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook) {
        updatedBook.setId(id);
        booksRepository.save(updatedBook);
    }

    @Transactional
    public void delete(int id) {
        booksRepository.deleteById(id);
    }

    public List<Book> findByOwner(Person owner) {
        return booksRepository.findByOwner(owner);
    }

    @Transactional
    public void release(int id) {
        Book book = booksRepository.findById(id).get();
        book.setOwner(null);

        booksRepository.save(book);
    }

    @Transactional
    public void assign(int id, Person selectedPerson) {
        Book book = booksRepository.findById(id).get();
        book.setDate(new Date());
        book.setOwner(selectedPerson);

        booksRepository.save(book);
    }
}
