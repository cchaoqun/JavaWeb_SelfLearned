package com.AtGuiGu.test;

import com.AtGuiGu.pojo.Book;
import com.AtGuiGu.service.BookService;
import com.AtGuiGu.service.impl.BookServiceImpl;
import org.junit.Test;


import java.math.BigDecimal;



/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/13-13:28
 */

public class BookServiceTest {

    BookService bookService = new BookServiceImpl();


    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "javaEE", "ccq", new BigDecimal(9999), 11111111, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22, "javaEE2", "ccq2", new BigDecimal(9999), 11111111, 0, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        bookService.queryBooks().forEach(System.out :: println);
    }
}