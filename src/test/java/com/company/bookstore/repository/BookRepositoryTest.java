package com.company.bookstore.repository;
import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Optional;


public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;
    AuthorRepository authorRepository;

    PublisherRepository publisherRepository;

    @Before
    public void setUp() throws Exception {
        bookRepository.deleteAll();
    }

    @Test
    public void shouldAddBook(){

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

        Publisher publisher = new Publisher();
        publisher.setCity("Detroit");
        publisher.setState("Michigan");
        publisher.setPhone("800-345-1345");
        publisher.setPostal_code("30456");
        publisher.setEmail("publisher@penguin.com");
        publisher.setStreet("312 Main Road");

        Book book = new Book();
        book.setIsbn("0-1024-1680-X");
        book.setPrice(BigDecimal.valueOf(30));
        book.setTitle("Moby Dick");
        book.setPublishDate("Jan-01-1899");
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());

        book1 = bookRepository.save(book1);

        Optional<Book> book


//
//        Book book2 = new Book();
//        book2.setIsbn("0-1024-9000-X");
//        book2.setPrice(BigDecimal.valueOf(10));
//        book2.setTitle("Hunger Games");
//        book2.setPublishDate("Mar-01-2007");



    }
    public void shouldUpdateBook(){}
    public void shoulDeleteBook(){}
    public void shouldFindBookbyID(){}
    public void shouldReadAllBooks(){}
}
