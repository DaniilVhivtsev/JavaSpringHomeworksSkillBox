package org.example.app.services;

import org.example.web.dto.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    void saveBook(Book book);

    boolean removeBookById(Long bookIdToRemove);

    void removeByRegex(String regex);
}
