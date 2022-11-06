package com.example.MyBookShopApp.data.test.service;

import com.example.MyBookShopApp.data.test.entity.TestEntity;
import org.springframework.stereotype.Repository;

@Repository
public class TestEntityDao extends AbstractHibernateDao<TestEntity>{
    public TestEntityDao(){
        super();
        setClazz(TestEntity.class);
    }
}
