package ru.zaza.springhibernatejpaapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.zaza.springhibernatejpaapp.models.Book;
import ru.zaza.springhibernatejpaapp.models.Person;

import java.util.List;
import java.util.Optional;


public class BookDAO {

    // Join'им таблицы Book и Person и получаем человека, которому принадлежит книга с указанным id
//    public Optional<Person> getBookOwner(int id) {
//        // Выбираем все колонки таблицы Person из объединенной таблицы
//        return jdbcTemplate.query("SELECT Person.* FROM Book JOIN Person ON Book.person_id = Person.id " +
//                        "WHERE Book.id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
//                .stream().findAny();
//    }

    // Освбождает книгу (этот метод вызывается, когда человек возвращает книгу в библиотеку)
//    public void release(int id) {
//        jdbcTemplate.update("UPDATE Book SET person_id=NULL WHERE id=?", id);
//    }

    // Назначает книгу человеку (этот метод вызывается, когда человек забирает книгу из библиотеки)
//    public void assign(int id, Person selectedPerson) {
//        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE id=?", selectedPerson.getId(), id);
//    }
}
