package ru.zaza.springhibernatejpaapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.zaza.springhibernatejpaapp.models.Book;
import ru.zaza.springhibernatejpaapp.models.Person;

import java.util.List;
import java.util.Optional;

public class PersonDAO {

    // Для валидации уникальности ФИО
//    public Optional<Person> getPersonByFullName(String fullName) {
//        return jdbcTemplate.query("SELECT * FROM Person WHERE full_name=?", new Object[]{fullName},
//                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
//    }

    // Здесь Join не нужен. И так уже получили человека с помощью отдельного метода
//    public List<Book> getBooksByPersonId(int id) {
//        return jdbcTemplate.query("SELECT * FROM Book WHERE person_id = ?", new Object[]{id},
//                new BeanPropertyRowMapper<>(Book.class));
//    }
}
