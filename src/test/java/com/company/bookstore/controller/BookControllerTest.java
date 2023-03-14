package com.company.bookstore.controller;

import com.company.bookstore.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    private List<Book> bookList;

    @Before
    public void setUp() {}

    @Test
    public void shouldGetBookById() throws Exception {
        Book book = new Book();
        book.setId(10);
        book.setAuthorId(20);
        book.setPublisherId(30);
        book.setIsbn("1234");
        book.setPublishDate("March 13");
        book.setTitle("The Boy Who Lived");

        String outputJson = mapper.writeValueAsString(book);

        mockMvc.perform(get("/book/10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldGetAllBooks() throws Exception {

        String outputJson = mapper.writeValueAsString(bookList);

        mockMvc.perform(get("/books"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnNewBook() throws Exception {
        Book book = new Book();
        book.setId(10);
        book.setAuthorId(20);
        book.setPublisherId(30);
        book.setIsbn("1234");
        book.setPublishDate("March 13");
        book.setTitle("The Boy Who Lived");

        String inputJson = mapper.writeValueAsString(book);

        Book book1 = new Book();
        book1.setId(100);
        book1.setAuthorId(200);
        book1.setPublisherId(300);
        book1.setIsbn("4321");
        book1.setPublishDate("December 31");
        book1.setTitle("The Boy Who Died");

        String outputJson = mapper.writeValueAsString(book);

        mockMvc.perform(post("/books")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

}