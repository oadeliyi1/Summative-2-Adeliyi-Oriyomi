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
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;



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

        publisher = publisherRepository.save(publisher);


        Book book = new Book();
        book.setIsbn("0-1024-1680-X");
        book.setPrice(BigDecimal.valueOf(30));
        book.setTitle("Moby Dick");
        book.setPublishDate("Jan-01-1899");
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());

        book = bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getId());
        assertEquals(book1.get(),book);


//
//        Book book2 = new Book();
//        book2.setIsbn("0-1024-9000-X");
//        book2.setPrice(BigDecimal.valueOf(10));
//        book2.setTitle("Hunger Games");
//        book2.setPublishDate("Mar-01-2007");



    }
    public void shouldUpdateBook() {

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
        publisher = publisherRepository.save(publisher);



        Book book = new Book();
        book.setIsbn("0-1024-1680-X");
        book.setPrice(BigDecimal.valueOf(30));
        book.setTitle("Moby Dick");
        book.setPublishDate("Jan-01-1899");
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());

        book = bookRepository.save(book);

        book.setPublishDate("Feb-02-1900");

        book = bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getId());
        assertEquals(book1.get(),book);
    }

    public void shoulDeleteBook(){
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

            publisher = publisherRepository.save(publisher);

            Book book = new Book();
            book.setIsbn("0-1024-1680-X");
            book.setPrice(BigDecimal.valueOf(30));
            book.setTitle("Moby Dick");
            book.setPublishDate("Jan-01-1899");
            book.setAuthorId(author.getId());
            book.setPublisherId(publisher.getId());

            book = bookRepository.save(book);

             bookRepository.deleteById(book.getId());

            Optional<Book> fromRepo = bookRepository.findById(book.getId());
            assertFalse(fromRepo.isPresent());
        }
    public void shouldFindBookbyID(){
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

            publisher = publisherRepository.save(publisher);

            Book book = new Book();
            book.setIsbn("0-1024-1680-X");
            book.setPrice(BigDecimal.valueOf(30));
            book.setTitle("Moby Dick");
            book.setPublishDate("Jan-01-1899");
            book.setAuthorId(author.getId());
            book.setPublisherId(publisher.getId());

            book = bookRepository.save(book);

            Optional<Book> book1 = bookRepository.findById(book.getId());
            assertEquals(book1.get(),book);
    }
    public void shouldReadAllBooks(){
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

            publisher = publisherRepository.save(publisher);

            Book book = new Book();
            book.setIsbn("0-1024-1680-X");
            book.setPrice(BigDecimal.valueOf(30));
            book.setTitle("Moby Dick");
            book.setPublishDate("Jan-01-1899");
            book.setAuthorId(author.getId());
            book.setPublisherId(publisher.getId());

            book = bookRepository.save(book);

            Book book2 = new Book();
            book.setIsbn("0-1134-1680-X");
            book.setPrice(BigDecimal.valueOf(20));
            book.setTitle("Pride & Prejudice");
            book.setPublishDate("Jan-02-1899");
            book.setAuthorId(author.getId());
            book.setPublisherId(publisher.getId());
            book2 = bookRepository.save(book2);

            List<Book> bookList = bookRepository.findAll();
            assertEquals(bookList.size(), 2);




        }
    }

