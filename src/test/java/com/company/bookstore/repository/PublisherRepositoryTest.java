package com.company.bookstore.repository;
import com.company.bookstore.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;


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
    public void shouldAddPublisher(){}
    public void shouldUpdatePublisher(){}
    public void shoulDeletePublisher(){}
    public void shouldFindPublisherbyID(){}
    public void shouldReadAllPublisher(){}


}
