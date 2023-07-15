package com.ken.newsapp.services;

import com.ken.newsapp.dto.NewDTO;
import com.ken.newsapp.exceptions.NotFoundException;
import com.ken.newsapp.requests.NewsRequest;

import java.util.List;


public interface INewService {

    void generateNews(NewsRequest request);

    List<NewDTO> findAll();

    NewDTO findById(String id) throws NotFoundException;

    void deleteById(String id) throws NotFoundException;
}
