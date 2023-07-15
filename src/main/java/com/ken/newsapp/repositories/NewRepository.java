package com.ken.newsapp.repositories;

import com.ken.newsapp.entities.New;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewRepository extends MongoRepository<New, String> {

    boolean existsByUrl(String url);
}
