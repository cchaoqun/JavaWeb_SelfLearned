package com.AtGuiGu.service;

import com.AtGuiGu.pojo.Book;

import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/13-13:25
 */

public interface BookService {

    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();
}
