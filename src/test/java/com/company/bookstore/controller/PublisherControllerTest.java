package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PublisherController.class)
public class PublisherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    private List<Publisher> publisherList;

    @Before
    public void setUp() {}

    @Test
    public void shouldGetPublisherById() throws Exception {
       Set<Book> bookSet = new HashSet<>();
       Set<Author> authorSet = new HashSet<>();

        Publisher publisher = new Publisher();
        publisher.setName("Dalonte Griffin");
        publisher.setId(20);
        publisher.setCity("Miami");
        publisher.setEmail("jonathan@gmail.com");
        publisher.setPhone("111 - 222 - 3456");
        publisher.setState("Florida");
        publisher.setPostal_code("33172");
        publisher.setBooks(bookSet);
        publisher.setAuthors(authorSet);

        String outputJson = mapper.writeValueAsString(publisher);

        mockMvc.perform(get("/publishers/10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldGetAllPublishers() throws Exception {

        String outputJson = mapper.writeValueAsString(publisherList);

        mockMvc.perform(get("/publishers"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnNewPublisherOnPostRequest() throws Exception {

        Set<Book> bookSet = new HashSet<>();
        Set<Author> authorSet = new HashSet<>();

        Publisher publisher = new Publisher();
        publisher.setName("Dalonte Griffin");
        publisher.setId(20);
        publisher.setCity("Miami");
        publisher.setEmail("jonathan@gmail.com");
        publisher.setPhone("111 - 222 - 3456");
        publisher.setState("Florida");
        publisher.setPostal_code("33172");
        publisher.setBooks(bookSet);
        publisher.setAuthors(authorSet);

        String inputJson = mapper.writeValueAsString(publisher);

        Set<Book> bookSet1 = new HashSet<>();
        Set<Author> authorSet1 = new HashSet<>();

        Publisher publisher1 = new Publisher();
        publisher1.setName("Dalonte Griffin");
        publisher1.setId(20);
        publisher1.setCity("Miami");
        publisher1.setEmail("jonathan@gmail.com");
        publisher1.setPhone("111 - 222 - 3456");
        publisher1.setState("Florida");
        publisher1.setPostal_code("33172");
        publisher1.setBooks(bookSet);
        publisher1.setAuthors(authorSet);

        String outputJson = mapper.writeValueAsString(publisher1);

        mockMvc.perform(post("/publishers")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldUpdateById() throws Exception {

        Set<Book> bookSet = new HashSet<>();
        Set<Author> authorSet = new HashSet<>();

        Publisher publisher = new Publisher();
        publisher.setName("Dalonte Griffin");
        publisher.setId(20);
        publisher.setCity("Miami");
        publisher.setEmail("jonathan@gmail.com");
        publisher.setPhone("111 - 222 - 3456");
        publisher.setState("Florida");
        publisher.setPostal_code("33172");
        publisher.setBooks(bookSet);
        publisher.setAuthors(authorSet);

        String inputJson = mapper.writeValueAsString(publisher);

        mockMvc.perform(
                        put("/publishers/20")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteById() throws Exception {
        mockMvc.perform(delete("/records/5"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

}