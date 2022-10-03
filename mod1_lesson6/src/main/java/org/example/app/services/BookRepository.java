package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

@Repository
public class BookRepository implements ProjectRepository<Book> {

    private final Logger logger = Logger.getLogger(BookRepository.class);
    private static final Map<Long, Book> repo = new ConcurrentHashMap<>();
    private static Long lastIndex = 0l;

    @Override
    public List<Book> retreiveAll() {
        return new ArrayList<>(repo.values());
    }

    @Override
    public synchronized void store(Book book) {
        if (book.getAuthor().isBlank() && book.getTitle().isBlank() && book.getSize() == null)
        {
            return;
        }
        book.setId(lastIndex++);
        logger.info("store new book: " + book);
        repo.put(book.getId(), book);
    }

    @Override
    public boolean removeItemById(Long bookIdToRemove) {
        if (!repo.containsKey(bookIdToRemove))
        {
            String error = String.format("Book with id %d doesn''t exist", bookIdToRemove);
            logger.error(error);
            return false;
        }
        repo.remove(bookIdToRemove);
        return true;
    }

    @Override
    public void removeItemsByRegexValue(String regex) {
        final Pattern fieldValueRegex = Pattern.compile(regex);
        Arrays.asList(Book.class.getDeclaredFields()).forEach(System.out::println);
        System.out.println(Book.class.getDeclaredFields().length);
        repo.forEach((key, value) -> {
            if (Arrays.stream(Book.class.getDeclaredFields())
                    .anyMatch(field -> {
                        field.setAccessible(true);
                        try
                        {
                            return fieldValueRegex.matcher(field.get(value).toString()).matches();
                        }
                        catch (IllegalAccessException e)
                        {
                            e.printStackTrace();
                            return false;
                        }
                        finally
                        {
                            field.setAccessible(false);
                        }
                    }))
            {
                repo.remove(key);
            }
        });
    }
}
