package com.AtGuiGu.dao.impl;

import com.AtGuiGu.pojo.Book;

import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/13-12:56
 */

public interface BookDao {


    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();
}
