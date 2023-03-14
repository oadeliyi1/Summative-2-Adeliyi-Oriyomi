package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import com.company.bookstore.repository.AuthorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AuthorRepository authorRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    private List<Author> authorList;

    @Before
    public void setUp() throws Exception{}

    @Test
    public void addAuthorTest() throws Exception {
//        Define author
        Author author = new Author();
        author.setFirstName("Jonathan");
        author.setLastName("Sanchez");
        author.setStreet("123 Street");
        author.setCity("Miami");
        author.setState("Florida");
        author.setPostal_code("12345");
        author.setPhone("111-222-3456");
        author.setEmail("jonathan@gmail.com");

        String input = objectMapper.writeValueAsString(author);

        mockMvc.perform(post("/authors").content(input)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void updateAuthorTest() throws Exception {
        Author author = new Author();
        author.setFirstName("Jonathan");
        author.setLastName("Sanchez");
        author.setStreet("123 Street");
        author.setCity("Miami");
        author.setId(10);
        author.setState("Florida");
        author.setPostal_code("12345");
        author.setPhone("111-222-3456");
        author.setEmail("jonathan@gmail.com");

        String input = objectMapper.writeValueAsString(author);

        mockMvc.perform(put("/authors/10")
                        .content(input)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldGetAuthorById() throws Exception{
        Author author = new Author();
        author.setFirstName("Jonathan");
        author.setLastName("Sanchez");
        author.setStreet("123 Street");
        author.setCity("Miami");
        author.setId(10);
        author.setState("Florida");
        author.setPostal_code("12345");
        author.setPhone("111-222-3456");
        author.setEmail("jonathan@gmail.com");

        mockMvc.perform(get("/authors/10}"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAllAuthors() throws Exception {
       String outputJson = objectMapper.writeValueAsString(authorList);

        mockMvc.perform(get("authors"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteAuthorById() throws Exception {
        mockMvc.perform(delete("authors/10"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


}