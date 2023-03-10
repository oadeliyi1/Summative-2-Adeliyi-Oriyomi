package com.company.bookstore.repository;

import com.company.bookstore.model.Author;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorRepositoryTest {
//    Using JUnit 4 for Repository Tests (As shown in class)

    @Autowired
    AuthorRepository authorRepository;

    @Before
    public void setUp() throws Exception {
        authorRepository.deleteAll();
    }

    @Test
    public void shouldDeleteAuthor() {
//        Arrange

        Author author = new Author();
        author.setFirstName("Jonathan");
        author.setLastName("Sanchez");
        author.setStreet("123 Lane");
        author.setCity("Miami");
        author.setState("Florida");
        author.setPostal_code("12345");
        author.setPhone("111-222-3456");
        author.setEmail("jon@gmail.com");

        author = authorRepository.save(author);

        Optional<Author> author1 = authorRepository.findById(author.getId());

        assertEquals(author1.get(), author);

        authorRepository.deleteById(author.getId());

        author1 = authorRepository.findById(author.getId());

        assertFalse(author1.isPresent());
    }

    @Test
    public void shouldUpdateAuthor() {

        Author author = new Author();
        author.setFirstName("Jonathan");
        author.setLastName("Sanchez");
        author.setStreet("123 Lane");
        author.setCity("Miami");
        author.setState("Florida");
        author.setPostal_code("12345");
        author.setPhone("111-222-3456");
        author.setEmail("jon@gmail.com");

        author = authorRepository.save(author);

        author.setFirstName("Jonny");

        Optional<Author> author1 = authorRepository.findById(author.getId());

        assertEquals(author1.get(), author);
    }

    @Test
    public void shouldGetAllAuthors() {
        Author author = new Author();
        author.setFirstName("Jonathan");
        author.setLastName("Sanchez");
        author.setStreet("123 Lane");
        author.setCity("Miami");
        author.setState("Florida");
        author.setPostal_code("12345");
        author.setPhone("111-222-3456");
        author.setEmail("jon@gmail.com");

        author = authorRepository.save(author);

        Author author1 = new Author();
        author.setFirstName("Dalonte");
        author.setLastName("Griffin");
        author.setStreet("321 Lane");
        author.setCity("Ney York");
        author.setState("New York");
        author.setPostal_code("54321");
        author.setPhone("111-222-3456");
        author.setEmail("dalonte@gmail.com");


        author1 = authorRepository.save(author1);

        List<Author> authorList = authorRepository.findAll();
        assertEquals(authorList.size(), 2);

    }

    @Test
    public void shouldAddAuthor() {
        Author author = new Author();
        author.setFirstName("Jonathan");
        author.setLastName("Sanchez");
        author.setStreet("123 Lane");
        author.setCity("Miami");
        author.setState("Florida");
        author.setPostal_code("12345");
        author.setPhone("111-222-3456");
        author.setEmail("jon@gmail.com");

        author = authorRepository.save(author);

        Optional<Author> author1 = authorRepository.findById(author.getId());

        assertEquals(author1.get(), author);
    }

    @Test
    public void shouldFindAuthorById() {
        Author author = new Author();
        author.setFirstName("Jonathan");
        author.setLastName("Sanchez");
        author.setStreet("123 Lane");
        author.setCity("Miami");
        author.setState("Florida");
        author.setPostal_code("12345");
        author.setPhone("111-222-3456");
        author.setEmail("jon@gmail.com");

        author = authorRepository.save(author);

        Optional<Author> author1 = authorRepository.findById(author.getId());

        assertEquals(author1.get(), author);
    }

}