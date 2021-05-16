package com.AtGuiGu.test;

import com.AtGuiGu.dao.impl.BookDao;
import com.AtGuiGu.dao.impl.BookDaoImpl;
import com.AtGuiGu.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/13-13:11
 */

public class BookDaoImplTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "javaEE", "ccq", new BigDecimal(9999), 11111111, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21, "javaEE改1", "ccq1", new BigDecimal(9999), 11111111, 0, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));

    }

    @Test
    public void queryBooks() {
        for(Book book: bookDao.queryBooks()){
            System.out.println(book);
        }
    }
}