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

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherRepositoryTest {

  @Autowired
  PublisherRepository publisherRepository;

    @Before
    public void setUp() throws Exception {
        publisherRepository.deleteAll();
    }

    @Test
    public void shouldAddPublisher(){
      Publisher publisher = new Publisher();
      publisher.setCity("Detroit");
      publisher.setState("Michigan");
      publisher.setPhone("800-345-1345");
      publisher.setPostal_code("30456");
      publisher.setEmail("publisher@penguin.com");
      publisher.setStreet("312 Main Road");
      publisher = publisherRepository.save(publisher);

      publisher = publisherRepository.save(publisher);

      publisher = publisherRepository.save(publisher);

      Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getId());
      assertEquals(publisher1.get(),publisher);

    }
    public void shouldUpdatePublisher(){
      Publisher publisher = new Publisher();
      publisher.setCity("Detroit");
      publisher.setState("Michigan");
      publisher.setPhone("800-345-1345");
      publisher.setPostal_code("30456");
      publisher.setEmail("publisher@penguin.com");
      publisher.setStreet("312 Main Road");
      publisher = publisherRepository.save(publisher);

      publisher.setCity("Kalamazoo");

      publisher = publisherRepository.save(publisher);

      Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getId());
      assertEquals(publisher1.get(),publisher);

    }
    public void shoulDeletePublisher(){
      Publisher publisher = new Publisher();
      publisher.setCity("Detroit");
      publisher.setState("Michigan");
      publisher.setPhone("800-345-1345");
      publisher.setPostal_code("30456");
      publisher.setEmail("publisher@penguin.com");
      publisher.setStreet("312 Main Road");
      publisher = publisherRepository.save(publisher);


      publisherRepository.deleteById(publisher.getId());
      Optional<Publisher> fromRepo = publisherRepository.findById(publisher.getId());
      assertFalse(fromRepo.isPresent());

    }
    public void shouldFindPublisherbyID(){
      Publisher publisher = new Publisher();
      publisher.setCity("Detroit");
      publisher.setState("Michigan");
      publisher.setPhone("800-345-1345");
      publisher.setPostal_code("30456");
      publisher.setEmail("publisher@penguin.com");
      publisher.setStreet("312 Main Road");
      publisher = publisherRepository.save(publisher);

      publisher = publisherRepository.save(publisher);


      Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getId());
      assertEquals(publisher1.get(),publisher);

    }
    public void shouldReadAllPublisher(){
      Publisher publisher = new Publisher();
      publisher.setCity("Detroit");
      publisher.setState("Michigan");
      publisher.setPhone("800-345-1345");
      publisher.setPostal_code("30456");
      publisher.setEmail("publisher@penguin.com");
      publisher.setStreet("312 Main Road");
      publisher = publisherRepository.save(publisher);

      publisher = publisherRepository.save(publisher);


      Publisher publisher1 = new Publisher();
      publisher1.setCity("New York");
      publisher1.setState("New York");
      publisher.setPhone("201-123-1345");
      publisher1.setPostal_code("10025");
      publisher1.setEmail("publisher@hacket.com");
      publisher1.setStreet("100 Broadway");
      publisher1 = publisherRepository.save(publisher);

      publisher1 = publisherRepository.save(publisher1);

      List<Publisher> publisherList = publisherRepository.findAll();
      assertEquals(publisherList.size(), 2);

    }


}
