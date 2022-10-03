package org.example.app.services;

import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final ProjectRepository<Book> bookRepo;

    @Autowired
    public BookServiceImpl(ProjectRepository<Book> bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.retreiveAll();
    }

    @Override
    public void saveBook(Book book) {
        bookRepo.store(book);
    }

    @Override
    public boolean removeBookById(Long bookIdToRemove) {
        return bookRepo.removeItemById(bookIdToRemove);
    }

    @Override
    public void removeByRegex(String regex)
    {
        bookRepo.removeItemsByRegexValue(regex);
    }
}
