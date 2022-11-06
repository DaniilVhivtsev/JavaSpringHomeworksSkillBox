package com.example.MyBookShopApp.data.author.repository;

import com.example.MyBookShopApp.data.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с авторами книг.
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>
{
}
