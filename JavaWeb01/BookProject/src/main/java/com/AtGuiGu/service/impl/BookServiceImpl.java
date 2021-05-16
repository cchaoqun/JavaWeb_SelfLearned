package com.AtGuiGu.service.impl;

import com.AtGuiGu.dao.impl.BookDao;
import com.AtGuiGu.dao.impl.BookDaoImpl;
import com.AtGuiGu.pojo.Book;
import com.AtGuiGu.service.BookService;

import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/13-13:27
 */

public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }
}
