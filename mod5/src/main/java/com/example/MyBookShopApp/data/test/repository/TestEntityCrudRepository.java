package com.example.MyBookShopApp.data.test.repository;

import com.example.MyBookShopApp.data.test.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestEntityCrudRepository extends JpaRepository<TestEntity,Long> {
}
